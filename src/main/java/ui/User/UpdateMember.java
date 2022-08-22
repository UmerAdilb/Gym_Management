package ui.User;



import domain.Member;
import services.MemberService;

import javax.swing.*;

public class UpdateMember {
    UpdateMember(){
        JFrame frame = new JFrame("Update Member");

        JLabel MemberidLb = new JLabel("Enter the Member id to update");
        MemberidLb.setBounds(180,60,250,120);
        JTextField MemberidTf = new JTextField();
        MemberidTf.setBounds(200,150,150,20);



        JButton btnNext = new JButton();
        btnNext.setBounds(190,300,90,40);
        btnNext.setText("Next");

        JButton backBtn = new JButton();
        backBtn.setBounds(290,300,90,40);
        backBtn.setText("Back");


        frame.add(MemberidLb);
        frame.add(MemberidTf);

        frame.add(btnNext);
        frame.add(backBtn);

        btnNext.addActionListener(btn->{
           Member member =  MemberService.checkMemberbyId(Long.parseLong(MemberidTf.getText()));

           if (member != null){
               frame.dispose();
               new EditMemberForm(member);

           }else {
               JOptionPane.showMessageDialog(frame,"Error! Member not exists");
           }


        });

        backBtn.addActionListener(btn->{
            frame.dispose();
            new LookUpMember();
        });


        //     frame.setLayout(new FlowLayout(FlowLayout.CENTER,120,25));
        frame.setLayout(null);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
