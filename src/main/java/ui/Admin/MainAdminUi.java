package ui.Admin;

import ui.LoginUi;
import ui.User.ManageAttendance;

import javax.swing.*;

public class MainAdminUi {
    public MainAdminUi(){
        JFrame frame = new JFrame("Admin Panel");

        JButton btnmember = new JButton();
        btnmember.setBounds(150,100,150,30);
        btnmember.setFocusable(false);
        btnmember.setText("Manage Member");

        JButton btntrainer = new JButton();
        btntrainer.setBounds(150,150,150,30);
        btntrainer.setFocusable(true);
        btntrainer.setText("Manage Trainer");

        JButton btnpackages = new JButton();
        btnpackages.setBounds(150,200,150,30);
        btnpackages.setFocusable(true);
        btnpackages.setText("Manage Packages");

        JButton btnattendance = new JButton();
        btnattendance.setBounds(150,250,150,30);
        btnattendance.setFocusable(true);
        btnattendance.setText("Manage Attendance");

        JButton btnreport = new JButton();
        btnreport.setBounds(150,300,150,30);
        btnreport.setFocusable(true);
        btnreport.setText("Manage Report");

        JButton btnLogout = new JButton();
        btnLogout.setBounds(150,400,150,30);
        btnLogout.setFocusable(false);
        btnLogout.setText("Logout");

        frame.add(btnmember);
        frame.add(btntrainer);
        frame.add(btnpackages);
        frame.add(btnattendance);
        frame.add(btnreport);
        frame.add(btnLogout);

//        frame.setLayout(new FlowLayout(FlowLayout.CENTER,120,25));
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        btnmember.addActionListener(el->{
            frame.dispose();
            new ManageMember();
        });
        btntrainer.addActionListener(el->{
            frame.dispose();
            new ManageTrainer();
        });
        btnpackages.addActionListener(el->{
            frame.dispose();
            new ManagePackages();
        });
        btnattendance.addActionListener(el->{
            frame.dispose();
            new ManageAttendance();
        });
        btnreport.addActionListener(el->{
            frame.dispose();
            new ManageReport();
        });
        btnLogout.addActionListener(el->{
            frame.dispose();
            new LoginUi();
        });

    }
}
