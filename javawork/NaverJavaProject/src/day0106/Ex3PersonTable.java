package day0106;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Vector;

public class Ex3PersonTable extends JFrame {
    JTextField tfName, tfAge, tfBlood, tfHp;
    JButton btnAdd, btnDel;
    DefaultTableModel tableModel;
    JTable table;

    Ex3PersonModel personModel = new Ex3PersonModel();

    public Ex3PersonTable() {
        super("사원 관리");
        this.setBounds(300, 100, 600, 400);
        this.initDesign();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initDesign() {
        JPanel p1 = new JPanel();
        tfName = new JTextField(4);
        tfAge = new JTextField(2);
        tfBlood = new JTextField(2);
        tfHp = new JTextField(12);

        p1.add(new JLabel("이름 : "));
        p1.add(tfName);
        p1.add(new JLabel(" | 나이 : "));
        p1.add(tfAge);
        p1.add(new JLabel(" | 혈액형 : "));
        p1.add(tfBlood);
        p1.add(new JLabel(" | 전화번호 : "));
        p1.add(tfHp);

        this.add("North", p1);


        String[] title = {"번호", "이름", "나이", "혈액형", "전화번호"};
        tableModel = new DefaultTableModel(title, 0);
        table = new JTable(tableModel);
        this.add("Center", new JScrollPane(table));

        this.rowSelect();

        btnAdd = new JButton("직원추가");
        btnDel = new JButton("직원삭제");

        JPanel p2 = new JPanel();
        p2.add(btnAdd);
        p2.add(btnDel);
        this.add("South", p2);

        btnAdd.addActionListener(e -> {
            String name = tfName.getText();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(Ex3PersonTable.this, "이름을 입력해주세요");
                return;
            }
            int age = Integer.parseInt(tfAge.getText());
            if (age == 0) {
                JOptionPane.showMessageDialog(Ex3PersonTable.this, "나이를 입력해주세요");
                return;
            }
            String blood = tfBlood.getText();
            if (blood.isEmpty()) {
                JOptionPane.showMessageDialog(Ex3PersonTable.this, "혈액형을 입력해주세요");
                return;
            }
            String hp = tfHp.getText();
            if (hp.isEmpty()) {
                JOptionPane.showMessageDialog(Ex3PersonTable.this, "전화번호를 입력해주세요");
                return;
            }
            Ex3PersonDto dto = new Ex3PersonDto();
            dto.setName(name);
            dto.setAge(age);
            dto.setBlood(blood);
            dto.setHp(hp);
            personModel.personInsert(dto);

            rowSelect();

            tfName.setText("");
            tfAge.setText("");
            tfBlood.setText("");
            tfHp.setText("");
        });

        btnDel.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(Ex3PersonTable.this, "삭제할 행을 선택해주세요");
                return;
            }
            int idx = Integer.parseInt(tableModel.getValueAt(row, 0).toString());
            personModel.personDelete(idx);
            rowSelect();
        });

    }

    public void rowSelect() {
        // 기존 테이블의 테이터 모두 삭제
        tableModel.setRowCount(0);

        // db 의 모든 데이터 가져오기
        List<Vector<String>> list = personModel.getPersonInfo();
        for (Vector<String> data : list) {
            tableModel.addRow(data);
        }

    }
    public static void main(String[] args) {
        Ex3PersonTable ex3 = new Ex3PersonTable();
    }
}

