package ui.Admin;

import services.GroupService;
import services.MemberService;

import javax.swing.*;

public class DeleteGroupAdmin {
    public DeleteGroupAdmin(){
        JFrame frame = new JFrame("Delete Group");

        JLabel groupidLb = new JLabel("Enter the Group ID to Delete");
        groupidLb.setBounds(180,60,250,120);
        JTextField groupidTf = new JTextField();
        groupidTf.setBounds(200,150,150,20);



        JButton btnDelete = new JButton();
        btnDelete.setBounds(190,300,90,40);
        btnDelete.setText("Delete");

        JButton backBtn = new JButton();
        backBtn.setBounds(290,300,90,40);
        backBtn.setText("Back");


        frame.add(groupidLb);
        frame.add(groupidTf);

        frame.add(btnDelete);
        frame.add(backBtn);

        btnDelete.addActionListener(btn->{

            Boolean delete =  GroupService.deleteGroup(Long.parseLong(groupidTf.getText()));
            if (delete){
                JOptionPane.showMessageDialog(frame,"Group Deleted");


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
