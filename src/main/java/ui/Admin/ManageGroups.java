package ui.Admin;

import services.GroupService;

import javax.swing.*;
import java.awt.*;

public class ManageGroups {
    public ManageGroups() {
        JFrame frame = new JFrame("GROUPS PANEL");


        JPanel panelBtn = new JPanel();
        JPanel panelView = new JPanel();

        String column[]={"Id","Name","Timing","Type","Trainer Id"};
        String data[][] = GroupService.getallgroups(column.length);


        JTable tbl=new JTable(data,column);


        panelView.setLayout(new BorderLayout());
        panelBtn.setBackground(Color.gray);
        frame.getContentPane().add(panelView);
        frame.getContentPane().add(panelBtn);

        JScrollPane sp1=new JScrollPane(tbl);
        panelView.add(sp1);
        panelView.add(sp1,BorderLayout.CENTER);
        panelView.setBounds(0,0,600,500);
        panelBtn.setBounds(20,550,500,100);

        JButton btnAddGroup = new JButton();
        btnAddGroup.setBounds(20,20,150,30);
        btnAddGroup.setFocusable(false);
        btnAddGroup.setText("Add");
        JButton btnEditGroup = new JButton();
        btnEditGroup.setBounds(40,20,150,30);
        btnEditGroup.setFocusable(false);
        btnEditGroup.setText("Edit");
        JButton btnDeleteGroup = new JButton();
        btnDeleteGroup.setBounds(60,20,150,30);
        btnDeleteGroup.setFocusable(false);
        btnDeleteGroup.setText("Delete");
        JButton btnBack = new JButton();
        btnBack.setBounds(80,20,150,30);
        btnBack.setFocusable(false);
        btnBack.setText("Back");

        panelBtn.add(btnAddGroup);
        panelBtn.add(btnEditGroup);
        panelBtn.add(btnDeleteGroup);
        panelBtn.add(btnBack);

        btnEditGroup.addActionListener(fl->{
            frame.dispose();
            new UpdateGroupAdmin();
        });

        btnAddGroup.addActionListener(btn->{
            frame.dispose();
            new AddGroupAdmin();
        });

        btnBack.addActionListener(btn->{
            frame.dispose();
            new MainAdminUi();
        });
        btnDeleteGroup.addActionListener(fl->{
            frame.dispose();
            new DeleteGroupAdmin();
        });

        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

        panelBtn.setVisible(true);
        panelView.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
