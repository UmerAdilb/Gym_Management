package ui.User;

import domain.Member;
import services.AttendanceService;
import services.MemberService;

import javax.swing.*;
import java.util.ArrayList;

public class MarkMemberAttendance {
    public MarkMemberAttendance(Member member) {
        JFrame frame = new JFrame("SHOW Member");

        JLabel mname = new JLabel();
        mname.setBounds(150,10,150,100);
        mname.setText(member.getName());

        JLabel mgender = new JLabel();
        mgender.setBounds(150,50,150,100);
        mgender.setText(member.getGender());

        JLabel mage = new JLabel();
        mage.setBounds(150,90,150,100);
        mage.setText(member.getAge().toString());

        JLabel mcontact = new JLabel();
        mcontact.setBounds(150,130,150,100);
        mcontact.setText(member.getContact());

        JLabel maddress = new JLabel();
        maddress.setBounds(150,170,150,100);
        maddress.setText(member.getAddress());

        JLabel mstatus = new JLabel();
        mstatus.setBounds(150,210,150,100);
        mstatus.setText(member.getStatus());

        JLabel mgroupid = new JLabel();
        mgroupid.setBounds(150,250,150,100);
        mgroupid.setText(member.getGroupId().toString());

        String[] date={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        JComboBox<String> da = new JComboBox<>(date);
        da.setBounds(10,330,150,20);
        String[] months = { "january","feburary", "march","april","may","june","july","august","september","october","november","december"};
        JComboBox<String> mo = new JComboBox<>(months);
        mo.setBounds(175,330,150,20);
        String[] year = { "2022","2021","2020","2019","2018","2017","2016","2015","2014","2013","2012","2011","2010"};
        JComboBox<String> ye = new JComboBox<>(year);
        ye.setBounds(350,330,150,20);


        JButton mark= new JButton("MARK ATTENDANCE");
        mark.setBounds(120,450,175,20);

        JButton back= new JButton("Back");
        back.setBounds(350,450,125,20);


        frame.add(mname);
        frame.add(mgender);
        frame.add(mage);
        frame.add(mcontact);
        frame.add(maddress);
        frame.add(mstatus);
        frame.add(mgroupid);
        frame.add(da);
        frame.add(mo);
        frame.add(ye);
        frame.add(mark);
        frame.add(back);

        mark.addActionListener(btn->{

            String _date = da.getSelectedItem().toString();
            String _month = mo.getSelectedItem().toString();
            String _year = ye.getSelectedItem().toString();
            Long _memberid = Long.parseLong(member.getId().toString());
            Boolean markattend = AttendanceService.AddAttendance(_date,_month,_year,_memberid);

            if(markattend){
                JOptionPane.showMessageDialog(frame,"Attendance marked");
            }else {
                JOptionPane.showMessageDialog(frame,"Error!");
            }
        });

        back.addActionListener(btn->{
            frame.dispose();
            new ManageAttendance();
        });


        da.setVisible(true);
        mo.setVisible(true);
        ye.setVisible(true);
        frame.setLayout(null);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
