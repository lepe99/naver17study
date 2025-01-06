package day0106;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Vector;

public class Ex2ShopTable extends JFrame {
    JTextField tfPrdt, tfNum, tfPrice;
    JButton btnAdd, btnDel, btnUpdate, btnSearch, btnShowAll;
    DefaultTableModel tableModel;
    JTable table;

    Ex2ShopModel shopModel = new Ex2ShopModel(); // shop db 데이터 관리 할 클래스

    public Ex2ShopTable() {
        super("shop 관리");
        this.setBounds(300, 100, 600, 400);
        this.initDesign();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void initDesign() {
        JPanel p1 = new JPanel();
        tfPrdt = new JTextField(6);
        tfNum = new JTextField(3);
        tfPrice = new JTextField(6);

        p1.add(new JLabel("상품명"));
        p1.add(tfPrdt);
        p1.add(new JLabel("수량"));
        p1.add(tfNum);
        p1.add(new JLabel("단가"));
        p1.add(tfPrice);

        // p1 panel frame 상단에 추가하기
        this.add("North", p1);

        // frame 중간에 table 넣기
        String[] title = {"인덱스", "상품명", "수량", "단가", "총금액", "입고일"};
        tableModel = new DefaultTableModel(title, 0);
        table = new JTable(tableModel);
        this.add("Center", new JScrollPane(table)); // 제목과 스크롤이 보이도록 추가

        // 생성된 테이블에 db데이터 출력하기
        this.rowSelect();

        // 하단에는 버튼 3개 + 2개 (조회, 전체출력)
        btnAdd = new JButton("상품추가");
        btnDel = new JButton("상품삭제");
        btnUpdate = new JButton("상품수정");
        btnSearch = new JButton("상품조회");
        btnShowAll = new JButton("전체조회");

        JPanel p2 = new JPanel();
        p2.add(btnAdd);
        p2.add(btnDel);
        p2.add(btnUpdate);
        p2.add(btnSearch);
        p2.add(btnShowAll);
        this.add("South", p2);

        // 상품추가 버튼 이벤트
        btnAdd.addActionListener(e -> {
            // 입력한 데이터들을 읽어 dto로 묶음
            String prdt = tfPrdt.getText();
            if (prdt.length() == 0) {
                JOptionPane.showMessageDialog(Ex2ShopTable.this, "상품명을 입력해주세요");
                return; // 메세지 띄운 후 메서드 종료
            }

            String textNum = tfNum.getText();
            int num = 0;
            if (textNum.length() == 0) {
                JOptionPane.showMessageDialog(Ex2ShopTable.this, "수량을 입력해주세요");
                return;
            } else
                num = Integer.parseInt(textNum);

            String textPrice = tfPrice.getText();
            int price = 0;
            if (textPrice.length() == 0) {
                JOptionPane.showMessageDialog(Ex2ShopTable.this, "가격을 입력해주세요");
                return;
            } else
                price = Integer.parseInt(textPrice);

            // insert 메서드 호출
            shopModel.insertShop(new Ex2ShopDto(prdt, num, price));
            // 전체 데이터 다시 출력
            rowSelect();
            // 입력한 데이터 초기화
            tfPrdt.setText("");
            tfNum.setText("");
            tfPrice.setText("");
        });

        btnDel.addActionListener(e -> {
            // table 의 선택한 행번호 가져오기
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(Ex2ShopTable.this, "삭제할 행을 선택해주세요");
                return;
            }
            // 선택한 행의 인덱스 값 가져오기
            int idx = Integer.parseInt(table.getValueAt(row, 0).toString());
            //getValueAt : 테이블의 (행, 열) 필드의 있는 값 반환

            // 삭제 메서드 호출
            shopModel.deleteShop(idx);
            // 테이블 테이터 다시 출력
            rowSelect();
        });

        btnUpdate.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(Ex2ShopTable.this, "수정할 행을 선택해주세요");
                return;
            }

            int idx = Integer.parseInt(table.getValueAt(row, 0).toString());
            Ex2ShopDto dto = new Ex2ShopDto();
            dto.setPrdt(tfPrdt.getText());
            dto.setNum(Integer.parseInt(tfNum.getText()));
            dto.setPrice(Integer.parseInt(tfPrice.getText()));
            shopModel.updateShop(dto, idx);
            rowSelect();

//            String prdt;
//            int price;
//
//            prdt = JOptionPane.showInputDialog("수정할 상품명을 입력하세요");
//            price = Integer.parseInt(JOptionPane.showInputDialog("수정할 단가를 입력하세요"));
//
//            // 수정 메서드 호출
//            shopModel.updateShop(idx, prdt, price);
//            rowSelect();
        });

        btnSearch.addActionListener(e -> {
            String prdt = tfPrdt.getText();
            if (prdt.length() == 0) {
                JOptionPane.showMessageDialog(Ex2ShopTable.this, "상품명을 입력해주세요");
                rowSelect();
                return;
            }
            // 기존 데이터 삭제
            tableModel.setRowCount(0);
            // 검색 결과 가져오기
            Ex2ShopDto dto = new Ex2ShopDto();
            dto.setPrdt(tfPrdt.getText());
            Vector<String> searchList = shopModel.prdtSearch(dto);
            // 테이블에 출력
            tableModel.addRow(searchList);

        });

        btnShowAll.addActionListener(e -> {
            rowSelect();
        });
    }


    /**
     * table에 데이터 출력하는 메서드
     */
    public void rowSelect() {
        // 기존 테이블의 테이터 모두 삭제
        tableModel.setRowCount(0);

        // db 의 모든 데이터 가져오기
        List<Vector<String>> list = shopModel.getAllData();
        for (Vector<String> data : list) {
            tableModel.addRow(data);
        }
    }



    public static void main(String[] args) {
        Ex2ShopTable ex2 = new Ex2ShopTable();
    }
}
