package ui.Admin;

import domain.Group;
import domain.Member;
import services.GroupService;
import services.MemberService;

import javax.swing.*;
import java.awt.*;

public class EditGroupAdmin {
    EditGroupAdmin(Group group) {

        JFrame frame = new JFrame("Edit Group");
        Container container = frame.getContentPane();

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        topPanel.setLayout(null);
        bottomPanel.setLayout(null);

        topPanel.setBackground(Color.GRAY);
        topPanel.setBounds(0, 0, 1000, 100);
        bottomPanel.setBackground(Color.lightGray);
        bottomPanel.setBounds(0, 100, 1000, 800);

        JLabel title = new JLabel("Edit Group");

        JLabel groupN = new JLabel("Group Name");
        JTextField groupName = new JTextField(10);
        groupName.setText(group.getName());

        JLabel timing = new JLabel("Timing");
        JTextField timingTf = new JTextField(10);
        timingTf.setText(group.getTiming());

        JLabel type = new JLabel("Type");
        JTextField typeTf = new JTextField(10);
        typeTf.setText(group.getType());

        JLabel trainerId = new JLabel("Trainer ID");
        JTextField traineridtf = new JTextField(10);
        traineridtf.setText(group.getTrainerId().toString());

        JButton editButton = new JButton("Edit");

        JButton backButton = new JButton(">");



        groupN.setBounds(250, 50, 150, 35);
        groupName.setBounds(400, 50, 150, 35);

        timing.setBounds(250,100,150,35);
        timingTf.setBounds(400,100,150,35);

        type.setBounds(250, 150, 150, 35);
        typeTf.setBounds(400, 150, 150, 35);

        trainerId.setBounds(250, 200, 150, 35);
        traineridtf.setBounds(400, 200, 150, 35);



        backButton.setBounds(900,5,50,50);
        editButton.setBounds(500, 450, 150, 35);

        editButton.addActionListener(btn->{
            String _name = groupName.getText();
            String _timing = timingTf.getText();
            String _type = typeTf.getText();
            Long _trainerid = Long.parseLong(traineridtf.getText());
            Boolean updateGroup = GroupService.updateGroup(group.getId(), _name,_timing,_type,_trainerid);

            if(updateGroup){
                JOptionPane.showMessageDialog(frame,"Group Edited Succesfully");
            }else {
                JOptionPane.showMessageDialog(frame,"Error! Group not Edited");
            }

        });

        backButton.addActionListener(btn->{
            frame.dispose();
            new ManageGroups();
        });

        topPanel.add(title);
        bottomPanel.add(groupN);
        bottomPanel.add(groupName);
        bottomPanel.add(timing);
        bottomPanel.add(timingTf);
        bottomPanel.add(type);
        bottomPanel.add(typeTf);
        bottomPanel.add(trainerId);
        bottomPanel.add(traineridtf);
        bottomPanel.add(editButton);
        bottomPanel.add(backButton);

        container.add(topPanel);
        container.add(bottomPanel);

        frame.setLayout(null);
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
