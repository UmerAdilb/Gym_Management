package ui.Admin;

import services.TrainerService;

import javax.swing.*;
import java.awt.*;

public class DeleteTrainer {
//    public DeleteTrainer(){
//        JFrame frame = new JFrame("DELETE Trainer");
//        Container container = frame.getContentPane();
//
//        JPanel topPanel = new JPanel();
//        JPanel bottomPanel = new JPanel();
//
//        topPanel.setLayout(null);
//        bottomPanel.setLayout(null);
//
//        topPanel.setBackground(Color.GRAY);
//        topPanel.setBounds(0, 0, 1000, 100);
//        bottomPanel.setBackground(Color.lightGray);
//        bottomPanel.setBounds(0, 100, 1000, 800);
//
//        JLabel title = new JLabel("Delete Trainer");
//
//        JLabel memberN = new JLabel("Trainer Name");
//        JTextField memberName = new JTextField(10);
//
//        JLabel gender = new JLabel("Gender");
//        JTextField genderTf = new JTextField(10);
//
//        JLabel age = new JLabel("Age");
//        JTextField ageTf = new JTextField(10);
//
//        JLabel contact = new JLabel("Contact");
//        JTextField contactTf = new JTextField(10);
//
//        JLabel address = new JLabel("Adress");
//        JTextField addressTf = new JTextField(10);
//
//
//        JButton Delete = new JButton("Delete");
//
//        JButton backButton = new JButton("<");
//
//
//
//        memberN.setBounds(250, 50, 150, 35);
//        memberName.setBounds(400, 50, 150, 35);
//
//        gender.setBounds(250,100,150,35);
//        genderTf.setBounds(400,100,150,35);
//
//        age.setBounds(250, 150, 150, 35);
//        ageTf.setBounds(400, 150, 150, 35);
//
//        contact.setBounds(250, 200, 150, 35);
//        contactTf.setBounds(400, 200, 150, 35);
//
//        address.setBounds(250, 250, 150, 35);
//        addressTf.setBounds(400, 250, 150, 35);
//
//
//        backButton.setBounds(900,5,50,50);
//        Delete.setBounds(400, 350, 150, 35);
//
//        Delete.addActionListener(btn->{
//
//        });
//
//        backButton.addActionListener(btn->{
//            frame.dispose();
//            new ManageMember();
//        });
//
//        topPanel.add(title);
//        bottomPanel.add(memberN);
//        bottomPanel.add(memberName);
//        bottomPanel.add(gender);
//        bottomPanel.add(genderTf);
//        bottomPanel.add(age);
//        bottomPanel.add(ageTf);
//        bottomPanel.add(contact);
//        bottomPanel.add(contactTf);
//        bottomPanel.add(address);
//        bottomPanel.add(addressTf);
//        bottomPanel.add(Delete);
//        bottomPanel.add(backButton);
//
//        container.add(topPanel);
//        container.add(bottomPanel);
//
//        frame.setLayout(null);
//        frame.setSize(1000,1000);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//
//    }
DeleteTrainer(){

    JFrame frame = new JFrame("Remove Trainer");

    JLabel traineridLb = new JLabel("Enter the Trainer ID to be Deleted ");
    traineridLb.setBounds(180,60,250,120);
    JTextField traineridTF = new JTextField();
    traineridTF.setBounds(200,150,150,20);



    JButton btnDelete = new JButton();
    btnDelete.setBounds(190,300,90,40);
    btnDelete.setText("Delete");

    JButton backBtn = new JButton();
    backBtn.setBounds(290,300,90,40);
    backBtn.setText("Back");


    frame.add(traineridLb);
    frame.add(traineridTF);

    frame.add(btnDelete);
    frame.add(backBtn);

    btnDelete.addActionListener(btn->{
        Long id =Long.parseLong(traineridTF.getText()) ;
        Boolean fl = TrainerService.DeleteTrainer(id);
        if (fl){
            JOptionPane.showMessageDialog(frame,"Trainer Deleted");

        }else{
            JOptionPane.showMessageDialog(frame,"Invalid Trainer ID given");

        }
    });

    backBtn.addActionListener(btn->{
        frame.dispose();
        new ManageTrainer();
    });


    //     frame.setLayout(new FlowLayout(FlowLayout.CENTER,120,25));
    frame.setLayout(null);
    frame.setSize(600, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
}
}
