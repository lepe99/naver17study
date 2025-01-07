package day0107;

import day0106.Ex2ShopTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Vector;

public class Ex1FoodMysqlDb extends JFrame {
    Ex1Model foodModel = new Ex1Model();

    DefaultTableModel resTableModel;
    DefaultTableModel orderTableModel;
    JTable resTable;
    JTable orderTable;

    JButton btnResAdd, btnResDel;
    JButton btnOrderAdd, btnOrderDel;
    JTextField tfFoodNum, tfOrderName, tfOrderCnt, tfBookingDay;
    JTextField tfFoodName, tfFoodPrice, tfFoodSize;

    public Ex1FoodMysqlDb() {
        super("메뉴 등록 / 예약");
        this.setBounds(200, 100, 1000, 600);
        this.initDesign();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void initDesign() {
        // 상단 버튼, 입력부 배치
        JPanel p1 = new JPanel();
        btnResAdd = new JButton("메뉴등록");
        btnResDel = new JButton("메뉴삭제");
        btnOrderAdd = new JButton("예약하기");
        btnOrderDel = new JButton("예약취소");

        tfFoodName = new JTextField(7);
        tfFoodPrice = new JTextField(5);
        tfFoodSize = new JTextField(5);
        p1.add(new JLabel("메뉴명"));
        p1.add(tfFoodName);
        p1.add(new JLabel(" | 가격"));
        p1.add(tfFoodPrice);
        p1.add(new JLabel(" | 크기"));
        p1.add(tfFoodSize);

        p1.add(btnResAdd);
        p1.add(btnResDel);
        p1.add(btnOrderAdd);
        p1.add(btnOrderDel);
        this.add("North", p1);

        // 왼쪽 메뉴판
        String[] resTitle = {"번호", "메뉴명", "사이즈", "가격"};
        resTableModel = new DefaultTableModel(resTitle, 0); // 제목, 행 갯수 0으로
        resTable = new JTable(resTableModel);
        this.add("West", new JScrollPane(resTable)); // 제목

        // 가운데 예약 테이블
        String[] orderTitle = {"번호", "예약자명", "메뉴명", "가격", "사이즈", "인원수", "예약일"};
        orderTableModel = new DefaultTableModel(orderTitle, 0); // 제목, 행 갯수 0으로
        orderTable = new JTable(orderTableModel);
        this.add("Center", new JScrollPane(orderTable)); // 제목

        // 하단 예약내용 입력부 추가
        tfOrderName = new JTextField(5);
        tfOrderCnt = new JTextField(3);
        tfBookingDay = new JTextField(12);
        tfFoodNum = new JTextField(3);

        JPanel p2 = new JPanel();
        p2.add(new JLabel("메뉴번호"));
        p2.add(tfFoodNum);
        p2.add(new JLabel(" | 예약자명"));
        p2.add(tfOrderName);
        p2.add(new JLabel(" | 인원수"));
        p2.add(tfOrderCnt);
        p2.add(new JLabel(" | 예약일자"));
        p2.add(tfBookingDay);
        this.add("South", p2);

        // 테이블 입력
        this.writeMenu();
        this.writeOrderJoin();


        // 버튼 이벤트
        // 메뉴 등록
        btnResAdd.addActionListener(e -> {
            String foodName = tfFoodName.getText();
            if (foodName.isEmpty()) {
                JOptionPane.showMessageDialog(Ex1FoodMysqlDb.this, "메뉴명을 입력해주세요");
                return;
            }
            int foodPrice = Integer.parseInt(tfFoodPrice.getText());
            if (foodPrice == 0) {
                JOptionPane.showMessageDialog(Ex1FoodMysqlDb.this, "가격을 입력해주세요");
                return;
            }
            String foodSize = tfFoodSize.getText();
            if (foodSize.isEmpty()) {
                JOptionPane.showMessageDialog(Ex1FoodMysqlDb.this, "크기를 입력해주세요");
                return;
            }
            Ex1Dto dto = new Ex1Dto(foodName, foodPrice, foodSize);

            // insert 호출
            foodModel.menuInsert(dto);
            // 테이블 다시 출력
            writeMenu();
            // 텍스트 필드 초기화
            tfFoodName.setText("");
            tfFoodPrice.setText("");
            tfFoodSize.setText("");
        });

        // 메뉴 삭제
        btnResDel.addActionListener(e -> {
            int row = resTable.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(Ex1FoodMysqlDb.this, "삭제할 행을 선택해주세요");
                return;
            }
            int idx = Integer.parseInt(resTableModel.getValueAt(row, 0).toString());
            // 조인 테이블의 참조 시 대처 위한 처리
            for (int i = 0; i < orderTableModel.getRowCount(); i++) {
                int orderNum = Integer.parseInt(orderTableModel.getValueAt(i, 0).toString());
                if (orderNum == idx) {
                    JOptionPane.showMessageDialog(Ex1FoodMysqlDb.this, "삭제 불가능, 이 상품의 예약자가 존재합니다");
                    return;
                }
            }
            // 삭제
            foodModel.menuDelete(idx);
            // 테이블 호출
            writeMenu();
        });

        // 예약 추가
        btnOrderAdd.addActionListener(e -> {
            int orderNum = Integer.parseInt(tfFoodNum.getText());
            if (orderNum == 0) {
                JOptionPane.showMessageDialog(Ex1FoodMysqlDb.this, "메뉴번호를 입력해주세요");
                return;
            }
            String orderName = tfOrderName.getText();
            if (orderName.isEmpty()) {
                JOptionPane.showMessageDialog(Ex1FoodMysqlDb.this, "예약자명을 입력해주세요");
                return;
            }
            int orderCnt = Integer.parseInt(tfOrderCnt.getText());
            if (orderCnt == 0) {
                JOptionPane.showMessageDialog(Ex1FoodMysqlDb.this, "수량을 입력해주세요");
                return;
            }
            String bookingDay = tfBookingDay.getText();
            if (bookingDay.isEmpty()) {
                JOptionPane.showMessageDialog(Ex1FoodMysqlDb.this, "예약일자를 입력해주세요");
                return;
            }
            Ex1Dto dto = new Ex1Dto(orderNum, orderName, orderCnt, bookingDay);

            // insert 호출
            foodModel.orderInsert(dto);
            // 테이블 다시 출력
            writeOrderJoin();
            // 텍스트 필드 초기화
            tfFoodNum.setText("");
            tfOrderName.setText("");
            tfOrderCnt.setText("");
            tfBookingDay.setText("");
        });

        // 예약 제거
        btnOrderDel.addActionListener(e -> {
            int row = orderTable.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(Ex1FoodMysqlDb.this, "삭제할 행을 선택해주세요");
                return;
            }
            int idx = Integer.parseInt(orderTableModel.getValueAt(row, 0).toString());
            // 삭제
            foodModel.orderDelete(idx);
            // 테이블 호출
            writeOrderJoin();
        });
    }

    public void writeMenu() {
        // 기존 테이블 삭제
        resTableModel.setRowCount(0);
        // 테이블 다시 로드
        List<Vector<String>> list = foodModel.getResData();
        for (Vector<String> data : list)
            resTableModel.addRow(data);
    }

    public void writeOrderJoin() {
        // 기존 테이블 삭제
        orderTableModel.setRowCount(0);
        // 테이블 다시 로드
        List<Vector<String>> list = foodModel.getOrderData();
        for (Vector<String> data : list)
            orderTableModel.addRow(data);
    }

    public static void main(String[] args) {
        Ex1FoodMysqlDb ex1 = new Ex1FoodMysqlDb();
    }
}
