package ui.User;

import services.GroupService;
import ui.LoginUi;

import javax.swing.*;
import java.awt.*;

public class MainUserUi {
    public MainUserUi(){

        JFrame frame = new JFrame("User Panel");
        Container c = frame.getContentPane();

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        panel1.setLayout(null);
        panel2.setLayout(null);
        panel3.setLayout(null);

JLabel Gym = new JLabel();
Gym.setText("GYM MANAGEMENT");
Gym.setFont(new Font("TimesRoman",Font.BOLD,30));
Gym.setBounds(200,10,300,80);

        JLabel group = new JLabel();
        group.setText("GROUPS");
        group.setFont(new Font("TimesRoman",Font.BOLD,20));
        group.setBounds(150,5,200,20);
        String column[]={"Name","Timing","Type","Trainer Name"};
        String data[][] = GroupService.getGroupsForUSER(column.length);


        JTable tbl=new JTable(data,column);
        JScrollPane sp=new JScrollPane(tbl);
        sp.setBounds(0,50,500,350);
        panel3.add(sp);

        JButton btnMember = new JButton();
        btnMember.setBounds(40,50,200,30);

        btnMember.setText("Member");

        JButton btnGenPayRec = new JButton();
        btnGenPayRec.setBounds(40,150,200,30);

        btnGenPayRec.setText("Payment");

        JButton btnAttendance = new JButton();
        btnAttendance.setBounds(40,250,200,30);

        btnAttendance.setText("Attendance");
        JButton btnLogout = new JButton();
        btnLogout.setBounds(80,350,100,30);

        btnLogout.setText("Logout");

panel1.add(Gym);
panel3.add(group);
        panel2.add(btnMember);
        panel2.add(btnGenPayRec);
        panel2.add(btnAttendance);
        panel2.add(btnLogout);
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

panel1.setBounds(0,0,800,100);
panel2.setBounds(0,100,300,400);
panel3.setBounds(300,100,500,400);
panel1.setBackground(Color.lightGray);
panel2.setBackground(Color.lightGray);
panel3.setBackground(Color.lightGray);

c.add(panel1);
c.add(panel2);
c.add(panel3);
        frame.setSize(800, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new MainUserUi();
    }
}
