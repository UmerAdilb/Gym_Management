package ui.Admin;

import services.TrainerService;

import javax.swing.*;
import java.awt.*;

public class AddTrainer {
    public AddTrainer() {
        JFrame frame = new JFrame("Add Trainer");
        Container container = frame.getContentPane();

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        topPanel.setLayout(null);
        bottomPanel.setLayout(null);

        topPanel.setBackground(Color.GRAY);
        topPanel.setBounds(0, 0, 1000, 100);
        bottomPanel.setBackground(Color.lightGray);
        bottomPanel.setBounds(0, 100, 1000, 800);

        JLabel title = new JLabel("ADD Trainer");

        JLabel trainerN = new JLabel("Trainer Name");
        JTextField trainerName = new JTextField(10);

        JLabel gender = new JLabel("Gender");
        JTextField genderTf = new JTextField(10);

        JLabel age = new JLabel("Age");
        JTextField ageTf = new JTextField(10);

        JLabel contact = new JLabel("Contact");
        JTextField contactTf = new JTextField(10);

        JLabel address = new JLabel("Address");
        JTextField addressTf = new JTextField(10);



        JButton Add = new JButton("Add");

        JButton backButton = new JButton("Back");



        trainerN.setBounds(250, 50, 150, 35);
        trainerName.setBounds(400, 50, 150, 35);

        gender.setBounds(250,100,150,35);
        genderTf.setBounds(400,100,150,35);

        age.setBounds(250, 150, 150, 35);
        ageTf.setBounds(400, 150, 150, 35);

        contact.setBounds(250, 200, 150, 35);
        contactTf.setBounds(400, 200, 150, 35);

        address.setBounds(250, 250, 150, 35);
        addressTf.setBounds(400, 250, 150, 35);


        backButton.setBounds(900,5,50,50);
        Add.setBounds(400, 350, 150, 35);

        Add.addActionListener(btn->{
            String _name = trainerName.getText();
            String _gender = genderTf.getText();
            Integer _age = Integer.valueOf(ageTf.getText());
            String _contact = contactTf.getText();
            String _address = addressTf.getText();

            Boolean addtrainer =  TrainerService.addTrainer(_name,_gender,_age,_contact,_address);

            if(addtrainer){
                JOptionPane.showMessageDialog(frame,"Trainer Added Succesfully");
            }else {
                JOptionPane.showMessageDialog(frame,"Trainer Name Already Exists");
            }
        });

        backButton.addActionListener(btn->{
            frame.dispose();
            new ManageTrainer();
        });

        topPanel.add(title);
        bottomPanel.add(trainerN);
        bottomPanel.add(trainerName);
        bottomPanel.add(gender);
        bottomPanel.add(genderTf);
        bottomPanel.add(age);
        bottomPanel.add(ageTf);
        bottomPanel.add(contact);
        bottomPanel.add(contactTf);
        bottomPanel.add(address);
        bottomPanel.add(addressTf);
        bottomPanel.add(Add);
        bottomPanel.add(backButton);

        container.add(topPanel);
        container.add(bottomPanel);

        frame.setLayout(null);
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
