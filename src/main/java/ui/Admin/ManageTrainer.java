package ui.Admin;

import services.TrainerService;

import javax.swing.*;
import java.awt.*;

public class ManageTrainer {
ManageTrainer(){
    JFrame frame = new JFrame("TRAINER");


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
