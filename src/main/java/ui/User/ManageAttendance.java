package ui.User;


import ui.LoginUi;

import javax.swing.*;


public class ManageAttendance {
    ManageAttendance() {
        JFrame frame = new JFrame("Attendance Panel");
        JButton btnaddattendance = new JButton();
        btnaddattendance.setBounds(100, 100, 250, 30);
        btnaddattendance.setFocusable(false);
        btnaddattendance.setText("MARK ATTENDANCE");

        JButton btnviewattendance = new JButton();
        btnviewattendance.setBounds(100, 200, 250, 30);
        btnviewattendance.setFocusable(false);
        btnviewattendance.setText("VIEW ATTENDANCE");

        JButton btndeactivatemembers = new JButton();
        btndeactivatemembers.setBounds(100, 300, 250, 30);
        btndeactivatemembers.setFocusable(false);
        btndeactivatemembers.setText("De ACTIVATE MEMBERS");
        JButton btnLogout = new JButton();
        btnLogout.setBounds(150, 400, 150, 30);
        btnLogout.setFocusable(false);
        btnLogout.setText("Logout");


        frame.add(btnaddattendance);
        frame.add(btnviewattendance);
        frame.add(btndeactivatemembers);
        frame.add(btnLogout);
        btnaddattendance.addActionListener(btn -> {
            frame.dispose();
            new MarkAttendnce();
        });
        btnviewattendance.addActionListener(btn -> {
            frame.dispose();
            new ViewAttendance();
        });
        btndeactivatemembers.addActionListener(btn -> {
            frame.dispose();
            new DeActivateMembers();
        });
        btnLogout.addActionListener(el -> {
            frame.dispose();
            new LoginUi();
        });


        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }


}
