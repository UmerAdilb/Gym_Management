package ui.User;

import services.AttendanceService;
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
        panel2.setBounds(0,105,760,660);


        JLabel memberidLb = new JLabel("Enter the Member Details to Search attendance");
        memberidLb.setBounds(25,20,250,20);
        JTextField memberidTf = new JTextField();
        memberidTf.setBounds(300,20,200,20);

        JRadioButton id=new JRadioButton("Member Id");
        JRadioButton contactno=new JRadioButton("Contact No");
        id.setBounds(100,50,100,30);
        contactno.setBounds(100,70,100,30);

        JButton btnsearch = new JButton();
        btnsearch.setBounds(25,125,90,20);
        btnsearch.setText("Search");

        JButton backBtn = new JButton();
        backBtn.setBounds(150,125,90,20);
        backBtn.setText("Back");


        String[] date={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        JComboBox<String> da = new JComboBox<>(date);
        da.setBounds(550,20,150,20);
        String[] months = { "january","feburary", "march","april","may","june","july","august","september","october","november","december"};
        JComboBox<String> mo = new JComboBox<>(months);
        mo.setBounds(550,60,150,20);
        String[] year = { "2022","2021","2020","2019","2018","2017","2016","2015","2014","2013","2012","2011","2010"};
        JComboBox<String> ye = new JComboBox<>(year);
        ye.setBounds(550,100,150,20);




        backBtn.addActionListener(btn->{
            f.dispose();
            new ManageAttendance();
        });


        btnsearch.addActionListener(fl->{
//            String _date = da.getSelectedItem().toString();
//            String _month = mo.getSelectedItem().toString();
//            String _year = ye.getSelectedItem().toString();
//            Long _memberid = Long.parseLong(member.getId().toString());
//            Boolean markattend = AttendanceService.AddAttendance(_date,_month,_year,_memberid);
//
//            if(markattend){
//                JOptionPane.showMessageDialog(frame,"Attendance marked");
//            }else {
//                JOptionPane.showMessageDialog(frame,"Error!");
//            }
        });



        panel1.add(memberidLb);
        panel1.add(memberidTf);
        panel1.add(id);
        panel1.add(contactno);
        panel1.add(btnsearch);
        panel1.add(backBtn);

        panel1.add(da);
        panel1.add(mo);
        panel1.add(ye);

        c.add(panel1);
        c.add(panel2);
        da.setVisible(true);
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
