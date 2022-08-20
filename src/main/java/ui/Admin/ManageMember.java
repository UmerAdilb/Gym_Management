package ui.Admin;

import javax.swing.*;
import java.awt.*;

public class ManageMember {
    public ManageMember() {
        JFrame frame = new JFrame("MEMBER'S");
        Container c=frame.getContentPane();

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        panel1.setLayout(null);
        panel2.setLayout(null);

        panel1.setBackground(Color.cyan);
        panel1.setBounds(0, 5, 985, 100);
        panel2.setBounds(10, 250, 900, 700);


        JButton btnAdd=new JButton("ADD");
        btnAdd.setBounds(75, 30, 130, 30);

        JButton btnUpdate = new JButton("UPDATE");
        btnUpdate.setBounds(275, 30, 130, 30);

        JButton btnDelete = new JButton("DELETE");
        btnDelete.setBounds(475, 30, 130, 30);

        JButton back = new JButton("Back");
        back.setBounds(675, 30, 130, 30);

        btnUpdate.addActionListener(bk->{
            frame.dispose();
            new UpdateMemberAdmin();
        });


        panel1.add(btnAdd);
        panel1.add(btnUpdate);
        panel1.add(btnDelete);
        panel1.add(back);

        back.addActionListener(bk -> {
            frame.dispose();
            new MainAdminUi();
        });
        btnAdd.addActionListener(bk->{
            frame.dispose();
            new AddMemberAdmin();
        });
        btnDelete.addActionListener(bk->{
            frame.dispose();
            new DeleteMemberAdmin();
        });

        c.add(panel1);
        c.add(panel2);

        frame.setLayout(null);
        frame.setSize(1000,1000);
        frame.setVisible(true);

    }
}
