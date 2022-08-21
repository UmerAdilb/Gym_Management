package ui.Admin;

import services.MemberService;
import services.TrainerService;

import javax.swing.*;
import java.awt.*;

public class ManageMember {
    public ManageMember() {
        JFrame frame = new JFrame("MEMBERS PANEL");


        JPanel panelBtn = new JPanel();
        JPanel panelView = new JPanel();

        String column[]={"Id","Name","Gender","Age","Contact","Address","Status","Group ID"};
        String data[][] = MemberService.getAllMembersForJTable(column.length);


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

        JButton btnAddMember = new JButton();
        btnAddMember.setBounds(20,20,150,30);
        btnAddMember.setFocusable(false);
        btnAddMember.setText("Add");
        JButton btnEditMember = new JButton();
        btnEditMember.setBounds(40,20,150,30);
        btnEditMember.setFocusable(false);
        btnEditMember.setText("Edit");
        JButton btnDeleteMember = new JButton();
        btnDeleteMember.setBounds(60,20,150,30);
        btnDeleteMember.setFocusable(false);
        btnDeleteMember.setText("Delete");
        JButton btnBack = new JButton();
        btnBack.setBounds(80,20,150,30);
        btnBack.setFocusable(false);
        btnBack.setText("Back");

        panelBtn.add(btnAddMember);
        panelBtn.add(btnEditMember);
        panelBtn.add(btnDeleteMember);
        panelBtn.add(btnBack);

        btnEditMember.addActionListener(fl->{
            frame.dispose();
            new UpdateMemberAdmin();
        });

        btnAddMember.addActionListener(btn->{
            frame.dispose();
            new AddMemberAdmin();
        });

        btnBack.addActionListener(btn->{
            frame.dispose();
            new MainAdminUi();
        });
        btnDeleteMember.addActionListener(fl->{
            frame.dispose();
            new DeleteMemberAdmin();
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
