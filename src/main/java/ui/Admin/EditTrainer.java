package ui.Admin;

import javax.swing.*;
import java.awt.*;

public class EditTrainer {
    EditTrainer() {
        JFrame frame = new JFrame("Trainer");

        JLabel memberNameLb = new JLabel("Name");
        memberNameLb.setBounds(200, 60, 150, 100);
        JTextField memberNameTf = new JTextField();
        memberNameTf.setBounds(270, 100, 150, 20);
//        memberNameTf.setText();

        JLabel contactnoLb = new JLabel("Contact Number");
        contactnoLb.setBounds(200, 110, 150, 100);
        JTextField contactnoTf = new JTextField();
        contactnoTf.setBounds(270, 150, 150, 20);
//        contactnoTf.setText();

        JLabel addressgLb = new JLabel("Address");
        addressgLb.setBounds(200, 160, 150, 100);
        JTextField addressTf = new JTextField();
        addressTf.setBounds(270, 200, 150, 20);
//        timingTf.setText();

        JButton btnupdatemember = new JButton();
        btnupdatemember.setBounds(200, 300, 100, 50);
        btnupdatemember.setText("Update");

        JButton backBtn = new JButton();
        backBtn.setBounds(300, 300, 100, 50);
        backBtn.setText("Back");


        frame.add(memberNameLb);
        frame.add(memberNameTf);
        frame.add(contactnoLb);
        frame.add(contactnoTf);
        frame.add(addressgLb);
        frame.add(addressTf);
        frame.add(btnupdatemember);
        frame.add(backBtn);

        btnupdatemember.addActionListener(btn -> {

        });

        backBtn.addActionListener(btn -> {
            frame.dispose();
            new ManageTrainer();
        });


        frame.setLayout(new FlowLayout(FlowLayout.CENTER,120,25));
        frame.setLayout(null);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
