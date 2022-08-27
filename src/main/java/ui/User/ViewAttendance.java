package ui.User;

import domain.Member;
import services.AttendanceService;
import services.MemberService;
import services.PaymentService;

import javax.swing.*;
import java.awt.*;

public class ViewAttendance {
    ViewAttendance(){
        JFrame f=new JFrame("VIEW ATTENDANCE");
        Container c = f.getContentPane();

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        panel1.setLayout(null);
        panel2.setLayout(null);

        panel2.setBackground(Color.lightGray);
        panel1.setBounds(0,0,760,200);
        panel2.setBounds(0,250,760,600);


        JLabel memberidLb = new JLabel("Enter the Member Details to Search attendance");
        memberidLb.setBounds(40,20,450,20);
        JTextField memberidTf = new JTextField();
        memberidTf.setBounds(30,80,150,30);
        memberidTf.setText("Member Id");
        memberidLb.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        JButton btnsearch = new JButton();
        btnsearch.setBounds(560,80,150,30);
        btnsearch.setText("Search");

        JButton backBtn = new JButton();
        backBtn.setBounds(560,150,150,30);
        backBtn.setText("Back");


        String[] months = { "january","february", "march","april","may","june","july","august","september","october","november","december"};
        JComboBox<String> mo = new JComboBox<>(months);
        mo.setBounds(200,80,150,30);
        String[] year = {"2022","2021","2020","2019","2018","2017","2016","2015","2014","2013","2012","2011","2010"};
        JComboBox<String> ye = new JComboBox<>(year);
        ye.setBounds(380,80,150,30);




        backBtn.addActionListener(btn->{
            f.dispose();
            new ManageAttendance();
        });


        btnsearch.addActionListener(fl->{
//            Member member = null;
//            if (id.isSelected()){
//                member = MemberService.checkMemberbyId(Long.parseLong(memberidTf.getText()));
//            }else{
//                JOptionPane.showMessageDialog(f,"Please select the field");
//            }

            JTable jt= null;

            String _month = mo.getSelectedItem().toString();
            String _year = ye.getSelectedItem().toString();
            String _memberid = memberidTf.getText();
            if (!_memberid.equalsIgnoreCase("Member Id")){
                if(AttendanceService.checkMemberIdPResent(_memberid)){
            String column[]={"Member Id","Day","Month","Year","Present"};
            String data[][] = AttendanceService.getAllAttendanceForJTable(column.length,_month
                    ,_year,_memberid);
            jt=new JTable(data,column);
            panel2.add(jt);
            JScrollPane sp=new JScrollPane(jt);
            sp.setBounds(15,0,700,600);
                    panel2.add(sp);
           ;}else {
                    JOptionPane.showMessageDialog(f,"Wrong Member ID");
                }
            }else {
                JOptionPane.showMessageDialog(f,"Please Insert Member ID");

            }


        });



        panel1.add(memberidLb);
        panel1.add(memberidTf);

        panel1.add(btnsearch);
        panel1.add(backBtn);

       panel1.add(mo);
        panel1.add(ye);

        c.add(panel1);
        c.add(panel2);
        mo.setVisible(true);
        ye.setVisible(true);
        f.setLayout(null);
        f.setSize(760,860);
        f.setVisible(true);;
        f.setLocationRelativeTo(null);


    }

    public static void main(String[] args) {
        new ViewAttendance();
    }
}
