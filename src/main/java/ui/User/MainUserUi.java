package ui.User;

import ui.LoginUi;

import javax.swing.*;

public class MainUserUi {
    public MainUserUi(){
        JFrame frame = new JFrame("User Panel");
        JButton btnMember = new JButton();
        btnMember.setBounds(100,100,250,30);
        btnMember.setFocusable(false);
        btnMember.setText("Member");

        JButton btnGenPayRec = new JButton();
        btnGenPayRec.setBounds(100,200,250,30);
        btnGenPayRec.setFocusable(false);
        btnGenPayRec.setText("Generate Payment Receipt");

        JButton btnAttendance = new JButton();
        btnAttendance.setBounds(100,300,250,30);
        btnAttendance.setFocusable(false);
        btnAttendance.setText("Attendance");
        JButton btnLogout = new JButton();
        btnLogout.setBounds(150,400,150,30);
        btnLogout.setFocusable(false);
        btnLogout.setText("Logout");


        frame.add(btnMember);
        frame.add(btnGenPayRec);
        frame.add(btnAttendance);
        frame.add(btnLogout);
        btnMember.addActionListener(btn->{
            frame.dispose();
            new LookUpMember();
        });
        btnGenPayRec.addActionListener(btn->{
            frame.dispose();
            new PaymentReceipt();
        });
        btnAttendance.addActionListener(btn->{
            frame.dispose();
            new ManageAttendance();
        });
        btnLogout.addActionListener(el->{frame.dispose();
            new LoginUi();
        });


        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
