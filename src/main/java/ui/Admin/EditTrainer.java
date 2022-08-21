package ui.Admin;

import domain.Trainer;
import services.TrainerService;

import javax.swing.*;
import java.awt.*;

public class EditTrainer {
    EditTrainer(Trainer trainer) {
        JFrame frame = new JFrame("Trainer");

        JLabel trainerLb = new JLabel("name");
        trainerLb.setBounds(200, 10, 150, 100);
        JTextField trainerNameTf = new JTextField();
        trainerNameTf.setBounds(270, 50, 150, 20);
        trainerNameTf.setText(trainer.getName());

        JLabel genderLb = new JLabel("gender");
        genderLb.setBounds(200, 60, 150, 100);
        JTextField genderTf = new JTextField();
        genderTf.setBounds(270, 100, 150, 20);
        genderTf.setText(trainer.getGender());

        JLabel ageLb = new JLabel("age");
        ageLb.setBounds(200, 110, 150, 100);
        JTextField ageTf = new JTextField();
        ageTf.setBounds(270, 150, 150, 20);
        ageTf.setText(trainer.getAge().toString());

        JLabel contactLb = new JLabel("contact");
        contactLb.setBounds(200, 160, 150, 100);
        JTextField contactTf = new JTextField();
        contactTf.setBounds(270, 200, 150, 20);
        contactTf.setText(trainer.getContact());

        JLabel addressgLb = new JLabel("Address");
        addressgLb.setBounds(200, 210, 150, 100);
        JTextField addressTf = new JTextField();
        addressTf.setBounds(270, 250, 150, 20);
        addressTf.setText(trainer.getAddress());

        JButton btnupdatemember = new JButton();
        btnupdatemember.setBounds(200, 300, 100, 50);
        btnupdatemember.setText("Update");

        JButton backBtn = new JButton();
        backBtn.setBounds(300, 300, 100, 50);
        backBtn.setText("Back");


        frame.add(trainerLb);
        frame.add(trainerNameTf);
        frame.add(genderLb);
        frame.add(genderTf);
        frame.add(ageLb);
        frame.add(ageTf);
        frame.add(contactLb);
        frame.add(contactTf);
        frame.add(addressgLb);
        frame.add(addressTf);
        frame.add(btnupdatemember);
        frame.add(backBtn);

        btnupdatemember.addActionListener(btn -> {
            String _name = trainerNameTf.getText();
            String _gender = genderTf.getText();
            Integer _age = Integer.valueOf(ageTf.getText());
            String _contact = contactTf.getText();
            String _address = addressTf.getText();
            Boolean edit=  TrainerService.TrainerEdit(_name,_gender,_age,_contact,_address,trainer.getId());

            if (edit){ JOptionPane.showMessageDialog(frame,"Trainer Edited");
            }else {
                JOptionPane.showMessageDialog(frame,"Trainer Not Edited");
//
            }
            frame.dispose();

        });

        backBtn.addActionListener(btn -> {
            frame.dispose();
            new ManageTrainer();
        });


        frame.setLayout(new FlowLayout(FlowLayout.CENTER,120,25));
        frame.setLayout(null);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
