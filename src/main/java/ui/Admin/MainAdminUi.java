package ui.Admin;

import services.ReportAnalyticService;
import ui.LoginUi;
import ui.User.ManageAttendance;

import javax.swing.*;
import java.awt.*;

public class MainAdminUi {
    public MainAdminUi(){
        JFrame frame = new JFrame("Admin Panel");
        JLabel Gym = new JLabel();
        Gym.setText("GYM ADMIN PANEL");
        Gym.setFont(new Font("TimesRoman",Font.BOLD,30));
        Gym.setBounds(100,10,300,80);


        JButton btnmember = new JButton();
        btnmember.setBounds(150,100,200,30);

        btnmember.setText("Manage Member");

        JButton btntrainer = new JButton();
        btntrainer.setBounds(150,160,200,30);
        btntrainer.setText("Manage Trainer");

        JButton btnpackages = new JButton();
        btnpackages.setBounds(150,220,200,30);
        btnpackages.setText("Manage Groups");


        JButton btnreport = new JButton();
        btnreport.setBounds(150,280,200,30);
        btnreport.setText("Manage Report");

        JButton btnLogout = new JButton();
        btnLogout.setBounds(185,400,150,30);
        btnLogout.setFocusable(false);
        btnLogout.setText("Logout");

        frame.add(btnmember);
        frame.add(btntrainer);
        frame.add(btnpackages);
        frame.add(btnreport);
        frame.add(btnLogout);
        frame.add(Gym);

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
            new ManageGroups();
        });

        btnreport.addActionListener(el->{

            frame.dispose();
            new ManageReport(ReportAnalyticService.reportData());
        });
        btnLogout.addActionListener(el->{
            frame.dispose();
            new LoginUi();
        });

    }

    public static void main(String[] args) {
        new MainAdminUi();
    }
}
