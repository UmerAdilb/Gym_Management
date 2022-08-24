package ui.User;

import domain.Member;

import services.MemberService;
import services.TrainerService;


import javax.swing.*;


public class MarkAttendnce  {
    MarkAttendnce(){
        JFrame frame = new JFrame("Mark Attendance");

        JLabel memberidLb = new JLabel("Enter the Member id to mark attendance");
        memberidLb.setBounds(180,60,250,120);
        JTextField memberidTf = new JTextField();
        memberidTf.setBounds(200,150,150,20);

        JRadioButton id=new JRadioButton("Member Id");
        JRadioButton contactno=new JRadioButton("Contact No");
        id.setBounds(200,200,100,30);
        contactno.setBounds(200,225,100,30);


        JButton btnNext = new JButton();
        btnNext.setBounds(190,300,90,40);
        btnNext.setText("Next");

        JButton backBtn = new JButton();
        backBtn.setBounds(290,300,90,40);
        backBtn.setText("Back");


        frame.add(memberidLb);
        frame.add(memberidTf);

        frame.add(id);
        frame.add(contactno);

        frame.add(btnNext);
        frame.add(backBtn);

        btnNext.addActionListener(btn->{
            Member member =  MemberService.checkMemberbyId(Long.parseLong(memberidTf.getText()));

            if (member != null){
                frame.dispose();
                new MarkMemberAttendance(member);

            }else {
                JOptionPane.showMessageDialog(frame,"Error! Member not exists");
            }

        });

        backBtn.addActionListener(btn->{
            frame.dispose();
            new ManageAttendance();
        });


        //     frame.setLayout(new FlowLayout(FlowLayout.CENTER,120,25));
        frame.setLayout(null);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

}
