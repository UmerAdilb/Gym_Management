package ui.Admin;

import domain.Group;
import domain.Member;
import services.GroupService;
import services.MemberService;

import javax.swing.*;

public class UpdateGroupAdmin {
    UpdateGroupAdmin(){
        JFrame frame = new JFrame("Update Group");

        JLabel GroupidLb = new JLabel("Enter the Group id to update");
        GroupidLb.setBounds(180,60,250,120);
        JTextField GroupidTf = new JTextField();
        GroupidTf.setBounds(200,150,150,20);



        JButton btnNext = new JButton();
        btnNext.setBounds(190,300,90,40);
        btnNext.setText("Next");

        JButton backBtn = new JButton();
        backBtn.setBounds(290,300,90,40);
        backBtn.setText("Back");


        frame.add(GroupidLb);
        frame.add(GroupidTf);

        frame.add(btnNext);
        frame.add(backBtn);

        btnNext.addActionListener(btn->{

            frame.dispose();
            Group group =  GroupService.checkGroupbyId(Long.parseLong(GroupidTf.getText()));
            if (group != null){
                frame.dispose();
                new EditGroupAdmin(group);

            }else {
                JOptionPane.showMessageDialog(frame,"Error! Group not exists");
            }


        });

        backBtn.addActionListener(btn->{
            frame.dispose();
            new ManageGroups();
        });



        frame.setLayout(null);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
