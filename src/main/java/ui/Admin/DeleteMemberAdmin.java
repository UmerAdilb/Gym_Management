package ui.Admin;



import domain.Member;
import services.MemberService;

import javax.swing.*;
import java.awt.*;

public class DeleteMemberAdmin {
    public DeleteMemberAdmin(){
        JFrame frame = new JFrame("Delete Member");

        JLabel MemberidLb = new JLabel("Enter the Member ID to Delete");
        MemberidLb.setBounds(180,60,250,120);
        JTextField MemberidTf = new JTextField();
        MemberidTf.setBounds(200,150,150,20);



        JButton btnDelete = new JButton();
        btnDelete.setBounds(190,300,90,40);
        btnDelete.setText("Delete");

        JButton backBtn = new JButton();
        backBtn.setBounds(290,300,90,40);
        backBtn.setText("Back");


        frame.add(MemberidLb);
        frame.add(MemberidTf);

        frame.add(btnDelete);
        frame.add(backBtn);

        btnDelete.addActionListener(btn->{

            frame.dispose();
            Boolean delete =  MemberService.deleteMember(Long.parseLong(MemberidTf.getText()));
            if (delete){
                JOptionPane.showMessageDialog(frame,"Member Deleted");


            }else {
                JOptionPane.showMessageDialog(frame,"Error! Member not exists");
            }


        });

        backBtn.addActionListener(btn->{
            frame.dispose();
            new ManageMember();
        });



        frame.setLayout(null);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
