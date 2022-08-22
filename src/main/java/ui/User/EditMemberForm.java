package ui.User;

import domain.Member;
import services.MemberService;
import ui.Admin.ManageMember;

import javax.swing.*;
import java.awt.*;

public class EditMemberForm {
    EditMemberForm(Member member) {
        JFrame frame = new JFrame("Edit Member");
        Container container = frame.getContentPane();

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        topPanel.setLayout(null);
        bottomPanel.setLayout(null);

        topPanel.setBackground(Color.GRAY);
        topPanel.setBounds(0, 0, 1000, 100);
        bottomPanel.setBackground(Color.lightGray);
        bottomPanel.setBounds(0, 100, 1000, 800);

        JLabel title = new JLabel("ADD Member");

        JLabel memberN = new JLabel("Member Name");
        JTextField memberName = new JTextField(10);
        memberName.setText(member.getName());

        JLabel gender = new JLabel("Gender");
        JTextField genderTf = new JTextField(10);
        genderTf.setText(member.getGender());

        JLabel age = new JLabel("Age");
        JTextField ageTf = new JTextField(10);
        ageTf.setText(member.getAge().toString());

        JLabel contact = new JLabel("Contact");
        JTextField contactTf = new JTextField(10);
        contactTf.setText(member.getContact());

        JLabel address = new JLabel("Address");
        JTextField addressTf = new JTextField(10);
        addressTf.setText(member.getAddress());

        JLabel status = new JLabel("Status");
        JTextField statustf = new JTextField(10);
        statustf.setText(member.getStatus());

        JLabel groupId = new JLabel("Group ID");
        JTextField groupidtf = new JTextField(10);
        groupidtf.setText(member.getGroupId().toString());

        JButton editButton = new JButton("Edit");

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

        status.setBounds(250, 300, 150, 35);
        statustf.setBounds(400, 300, 150, 35);

        groupId.setBounds(250, 350, 150, 35);
        groupidtf.setBounds(400, 350, 150, 35);


        backButton.setBounds(900,5,50,50);
        editButton.setBounds(500, 450, 150, 35);

        editButton.addActionListener(btn->{
            String _name = memberName.getText();
            String _gender = genderTf.getText();
            Integer _age = Integer.valueOf(ageTf.getText());
            String _contact = contactTf.getText();
            String _address = addressTf.getText();
            String _status = statustf.getText();
            Long _groupid = Long.parseLong(groupidtf.getText());
            Boolean updateMember = MemberService.updateMember(member.getId(), _name,_gender,_age,_contact,_address,_status,_groupid);

            if(updateMember){
                JOptionPane.showMessageDialog(frame,"Member Edited Succesfully");
            }else {
                JOptionPane.showMessageDialog(frame,"Error! Member not Edited");
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
        bottomPanel.add(status);
        bottomPanel.add(statustf);
        bottomPanel.add(groupidtf);
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
