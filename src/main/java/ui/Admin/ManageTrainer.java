package ui.Admin;

import services.TrainerService;

import javax.swing.*;
import java.awt.*;

public class ManageTrainer {
//    public ManageTrainer() {
//        JFrame frame = new JFrame("TRAINERS'S");
//        Container c=frame.getContentPane();
//
//        JPanel panel1 = new JPanel();
//        JPanel panel2 = new JPanel();
//
//        panel1.setLayout(null);
//        panel2.setLayout(null);
//
//        panel1.setBackground(Color.cyan);
//        panel1.setBounds(0, 5, 985, 100);
//        panel2.setBounds(10, 250, 900, 700);
//
//        String column[]={"Id","Name","Capacity","Airline"};
//        String data[][] = TrainerService.getAllTrainersForJTable(column.length);
//
//
//        JTable tbl=new JTable(data,column);
//
//
//        JButton btnAdd=new JButton("ADD");
//        btnAdd.setBounds(75, 30, 130, 30);
//
//        JButton btnUpdate = new JButton("UPDATE");
//        btnUpdate.setBounds(275, 30, 130, 30);
//
//        JButton btnDelete = new JButton("DELETE");
//        btnDelete.setBounds(475, 30, 130, 30);
//
//        JButton back = new JButton("Back");
//        back.setBounds(675, 30, 130, 30);
//
//        btnUpdate.addActionListener(bk->{
//            frame.dispose();
//            new UpdateTrainer();
//        });
//
//
//        panel1.add(btnAdd);
//        panel1.add(btnUpdate);
//        panel1.add(btnDelete);
//        panel1.add(back);
//
//        back.addActionListener(bk -> {
//            frame.dispose();
//            new MainAdminUi();
//        });
//        btnAdd.addActionListener(bk->{
//            frame.dispose();
//            new AddTrainer();
//        });
//        btnDelete.addActionListener(bk->{
//            frame.dispose();
//            new DeleteTrainer();
//        });
//
//        c.add(panel1);
//        c.add(panel2);
//
//        frame.setLayout(null);
//        frame.setSize(1000,1000);
//        frame.setVisible(true);
//
//    }
ManageTrainer(){
    JFrame frame = new JFrame("All Planes Panel");


    JPanel panelBtn = new JPanel();
    JPanel panelView = new JPanel();

    String column[]={"Id","Name","Gender","Age","Contact","Address"};
    String data[][] = TrainerService.getAllTrainersForJTable(column.length);


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

    JButton btnAddTrainer = new JButton();
    btnAddTrainer.setBounds(20,20,150,30);
    btnAddTrainer.setFocusable(false);
    btnAddTrainer.setText("Add");
    JButton btnEdittrainer = new JButton();
    btnEdittrainer.setBounds(40,20,150,30);
    btnEdittrainer.setFocusable(false);
    btnEdittrainer.setText("Edit");
    JButton btnDeletetrainer = new JButton();
    btnDeletetrainer.setBounds(60,20,150,30);
    btnDeletetrainer.setFocusable(false);
    btnDeletetrainer.setText("Delete");
    JButton btnBackPlane = new JButton();
    btnBackPlane.setBounds(80,20,150,30);
    btnBackPlane.setFocusable(false);
    btnBackPlane.setText("Back");

    panelBtn.add(btnAddTrainer);
    panelBtn.add(btnEdittrainer);
    panelBtn.add(btnDeletetrainer);
    panelBtn.add(btnBackPlane);

    btnEdittrainer.addActionListener(fl->{
        frame.dispose();
        new UpdateTrainer();
    });

    btnAddTrainer.addActionListener(btn->{
        frame.dispose();
        new AddTrainer();
    });

    btnBackPlane.addActionListener(btn->{
        frame.dispose();
        new MainAdminUi();
    });
    btnDeletetrainer.addActionListener(fl->{
        frame.dispose();
        new DeleteTrainer();
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
