package ui.Admin;

import domain.Trainer;
import services.TrainerService;

import javax.swing.*;

public class UpdateTrainer {
    UpdateTrainer(){
        JFrame frame = new JFrame("Update Trainer");

        JLabel TraineridLb = new JLabel("Enter the Trainer id to update");
        TraineridLb.setBounds(180,60,250,120);
        JTextField traineridTf = new JTextField();
        traineridTf.setBounds(200,150,150,20);



        JButton btnNext = new JButton();
        btnNext.setBounds(190,300,90,40);
        btnNext.setText("Next");

        JButton backBtn = new JButton();
        backBtn.setBounds(290,300,90,40);
        backBtn.setText("Back");


        frame.add(TraineridLb);
        frame.add(traineridTf);

        frame.add(btnNext);
        frame.add(backBtn);

        btnNext.addActionListener(btn->{
            Long id =Long.parseLong(traineridTf.getText()) ;

            Trainer train = TrainerService.searchTrainer(id);
            if (train != null){
                EditTrainer editTrainer= new EditTrainer(train);
                frame.dispose();
            }else{

                JOptionPane.showMessageDialog(frame,"No Trainer Exists with this id");

            }
//            frame.dispose();
//            new EditTrainer();

        });

        backBtn.addActionListener(btn->{
            frame.dispose();
            new ManageTrainer();
        });



        frame.setLayout(null);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
