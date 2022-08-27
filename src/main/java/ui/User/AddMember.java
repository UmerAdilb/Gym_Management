package ui.User;

import services.GroupService;
import services.MemberService;
import ui.Admin.ManageMember;

import javax.swing.*;
import java.awt.*;


public class AddMember {
    public  AddMember() {
        JFrame frame = new JFrame("Add Member");
        Container container = frame.getContentPane();

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        topPanel.setLayout(null);
        bottomPanel.setLayout(null);

        topPanel.setBackground(Color.GRAY);
        topPanel.setBounds(0, 0, 800, 100);
        bottomPanel.setBackground(Color.lightGray);
        bottomPanel.setBounds(0, 100, 800, 800);

        JLabel title = new JLabel("ADD Member");

        JLabel memberN = new JLabel("Member Name");
        JTextField memberName = new JTextField(10);

        JLabel gender = new JLabel("Gender");
        JTextField genderTf = new JTextField(10);

        JLabel age = new JLabel("Age");
        JTextField ageTf = new JTextField(10);

        JLabel contact = new JLabel("Contact");
        JTextField contactTf = new JTextField(10);

        JLabel address = new JLabel("Address");
        JTextField addressTf = new JTextField(10);



        JLabel groupId = new JLabel("Group Name");
        JTextField groupidtf = new JTextField(10);

        JButton Add = new JButton("Add");

        JButton backButton = new JButton(">");



        memberN.setBounds(250, 50, 150, 35);
        memberName.setBounds(400, 50, 150, 35);

        gender.setBounds(250,100,150,35);
        genderTf.setBounds(400,100,150,35);

        age.setBounds(250, 150, 150, 35);
        ageTf.setBounds(400, 150, 150, 35);

        contact.setBounds(250, 200, 150, 35);
        contactTf.setBounds(400, 200, 150, 35);

        address.setBounds(250, 250, 150, 35);
        addressTf.setBounds(400, 250, 150, 35);

        groupId.setBounds(250, 300, 150, 35);
        groupidtf.setBounds(400, 300, 150, 35);

        backButton.setBounds(700,5,50,50);
        Add.setBounds(400, 350, 150, 35);

        Add.addActionListener(btn->{
            String _name = memberName.getText();
            String _gender = genderTf.getText();
            Integer _age = Integer.valueOf(ageTf.getText());
            String _contact = contactTf.getText();
            String _address = addressTf.getText();
            String _groupName =(groupidtf.getText());

            Long Id= GroupService.checkGroupNAme(_groupName);
            if (Id!=null){
                Boolean addmember = MemberService.addMember(_name,_gender,_age,_contact,_address,"ACTIVE",Id);
            if(addmember){
                JOptionPane.showMessageDialog(frame,"Member Added Succesfully");
            }else {
                JOptionPane.showMessageDialog(frame,"Error! Member not added");
            }}else {
                JOptionPane.showMessageDialog(frame,"Wrong Group Name");
            }

        });

        backButton.addActionListener(btn->{
            frame.dispose();
            new LookUpMember();
        });

        topPanel.add(title);
        bottomPanel.add(memberN);
        bottomPanel.add(memberName);
        bottomPanel.add(gender);
        bottomPanel.add(genderTf);
        bottomPanel.add(age);
        bottomPanel.add(ageTf);
        bottomPanel.add(contact);
        bottomPanel.add(contactTf);
        bottomPanel.add(address);
        bottomPanel.add(addressTf);
        bottomPanel.add(groupId);
        bottomPanel.add(groupidtf);
        bottomPanel.add(Add);
        bottomPanel.add(backButton);

        container.add(topPanel);
        container.add(bottomPanel);

        frame.setLayout(null);
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }
    }

