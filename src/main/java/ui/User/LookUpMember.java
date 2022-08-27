package ui.User;

import services.MemberService;
import ui.Admin.AddMemberAdmin;
import ui.Admin.DeleteMemberAdmin;
import ui.Admin.MainAdminUi;
import ui.Admin.UpdateMemberAdmin;

import javax.swing.*;
import java.awt.*;

public class LookUpMember {
    public LookUpMember(){
    JFrame frame = new JFrame("MEMBERS PANEL");


    JPanel panelBtn = new JPanel();
    JPanel panelView = new JPanel();

        JButton btnSearch = new JButton();
        btnSearch.setBounds(670,20,100,30);

        btnSearch.setText("Search");
        JTextField searchtf = new JTextField();
        searchtf.setBounds(550,20,100,30);
        searchtf.setText("Contact");



    JButton btnAddMember = new JButton();
        btnAddMember.setBounds(10,20,80,30);
        btnAddMember.setText("Add");
    JButton btnEditMember = new JButton();
        btnEditMember.setBounds(110,20,80,30);

        btnEditMember.setText("Edit");
    JButton btnDeleteMember = new JButton();
        btnDeleteMember.setBounds(210,20,80,30);
        btnDeleteMember.setText("Delete");
    JButton btnBack = new JButton();
        btnBack.setBounds(310,20,80,30);
        btnBack.setText("Back");



panelBtn.add(btnSearch);
panelBtn.add(searchtf);
        panelBtn.add(btnAddMember);
        panelBtn.add(btnEditMember);
        panelBtn.add(btnDeleteMember);
        panelBtn.add(btnBack);
        String _contact = searchtf.getText();

        btnSearch.addActionListener(l->{
            String column[]={"ID","Name","Gender","Age","Contact","Address","Status"};
            String data[][] = MemberService.getAllMembersForLookUpMember(column.length,searchtf.getText());
            JTable tbl=new JTable(data,column);
            JTable jt=new JTable(data,column);
            JScrollPane sp=new JScrollPane(jt);
            sp.setBounds(0,0,780,400);
            panelView.add(sp);
        });
        btnEditMember.addActionListener(fl->{
        frame.dispose();
        new UpdateMember();
    });

        btnAddMember.addActionListener(btn->{
        frame.dispose();
        new AddMember();
    });

        btnBack.addActionListener(btn->{
        frame.dispose();
        new MainUserUi();
    });
        btnDeleteMember.addActionListener(fl->{
        frame.dispose();
        new DeleteMember();
    });
        frame.getContentPane().add(panelView);
        frame.getContentPane().add(panelBtn);
        //Searchpanel.setBounds(0,0,600,100);
        panelView.setBounds(5,120,780,400);
        panelBtn.setBounds(0,0,800,100);
        panelBtn.setLayout(null);
        panelView.setLayout(new BorderLayout());
        panelBtn.setBackground(Color.gray);


        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

        panelBtn.setVisible(true);
        panelView.setVisible(true);
        frame.setLocationRelativeTo(null);
        btnSearch.doClick();
}

    public static void main(String[] args) {
        new LookUpMember();
    }
}
