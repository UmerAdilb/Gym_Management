package ui.Admin;

import services.GroupService;
import services.MemberService;

import javax.swing.*;
import java.awt.*;

public class AddGroupAdmin {
    public AddGroupAdmin() {
        JFrame frame = new JFrame("Add Group");
        Container container = frame.getContentPane();

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        topPanel.setLayout(null);
        bottomPanel.setLayout(null);

        topPanel.setBackground(Color.GRAY);
        topPanel.setBounds(0, 0, 1000, 100);
        bottomPanel.setBackground(Color.lightGray);
        bottomPanel.setBounds(0, 100, 1000, 800);

        JLabel title = new JLabel("ADD Group");

        JLabel GroupN = new JLabel("Group Name");
        JTextField groupName = new JTextField(10);

        JLabel timing = new JLabel("timing");
        JTextField timingTf = new JTextField(10);

        JLabel type = new JLabel("type");
        JTextField typeTf = new JTextField(10);

        JLabel trainerId = new JLabel("Trainer ID");
        JTextField traineridtf = new JTextField(10);

        JButton Add = new JButton("Add");

        JButton backButton = new JButton(">");



        GroupN.setBounds(250, 50, 150, 35);
        groupName.setBounds(400, 50, 150, 35);

        timing.setBounds(250,100,150,35);
        timingTf.setBounds(400,100,150,35);

        type.setBounds(250, 150, 150, 35);
        typeTf.setBounds(400, 150, 150, 35);


        trainerId.setBounds(250, 300, 150, 35);
        traineridtf.setBounds(400, 300, 150, 35);

        backButton.setBounds(900,5,50,50);
        Add.setBounds(400, 350, 150, 35);

        Add.addActionListener(btn->{
            String _name = groupName.getText();
            String _timing = timingTf.getText();
            String _type = typeTf.getText();
            Long _trainerid = Long.parseLong(traineridtf.getText());
            Boolean addgroup = GroupService.addGroup(_name,_timing,_type,_trainerid);

            if(addgroup){
                JOptionPane.showMessageDialog(frame,"Group Added Succesfully");
            }else {
                JOptionPane.showMessageDialog(frame,"Error! Group not added");
            }

        });

        backButton.addActionListener(btn->{
            frame.dispose();
            new ManageGroups();
        });

        topPanel.add(title);
        bottomPanel.add(GroupN);
        bottomPanel.add(groupName);
        bottomPanel.add(timing);
        bottomPanel.add(timingTf);
        bottomPanel.add(type);
        bottomPanel.add(typeTf);
        bottomPanel.add(trainerId);
        bottomPanel.add(traineridtf);
        bottomPanel.add(Add);
        bottomPanel.add(backButton);

        container.add(topPanel);
        container.add(bottomPanel);

        frame.setLayout(null);
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
