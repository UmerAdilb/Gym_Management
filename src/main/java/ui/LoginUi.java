package ui;



import services.AuthenticateService;
import ui.Admin.MainAdminUi;
import ui.User.MainUserUi;

import javax.swing.*;
import java.awt.*;

public class LoginUi {
    public LoginUi(){

        JFrame frame = new JFrame("Login");

        JLabel username = new JLabel("NAME");
        JTextField usernameTf = new JTextField(10);

        JLabel password = new JLabel("PASSWORD");
        JTextField passwordTf = new JTextField(10);

        JLabel errorLabel = new JLabel();

        JButton login = new JButton();
        login.setBounds(200,300,150,30);
        login.setText("Login");

        JButton logout = new JButton();
        logout.setBounds(200,400,150,30);
        logout.setText("Close");

        login.addActionListener(btn->{
            String uname = usernameTf.getText();
            String pass = passwordTf.getText();
            if(AuthenticateService.authenticateAdmin(uname,pass)){
                new MainAdminUi();
                System.out.println("hello admin");
                frame.dispose();

                //for admin
            }else if (AuthenticateService.authenticateUser(uname,pass)){
                //for user

                new MainUserUi();
                System.out.println("hello user");
                frame.dispose();

            }
            else{
                errorLabel.setText("Your username or password is incorrect");
                errorLabel.setForeground(Color.RED);
            }        });



        logout.addActionListener(el->{
            frame.dispose();
        });


        frame.add(username);
        frame.add(usernameTf);
        frame.add(password);
        frame.add(passwordTf);
        frame.add(login);
        frame.add(logout);
        frame.add(errorLabel);

        frame.setLayout(new FlowLayout(FlowLayout.CENTER,120,25));

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

//        ImageIcon background=new ImageIcon("C:\\Users\\DELL\\Downloads\\backgroundimage");
//        Image img=background.getImage();
//        Image temp=img.getScaledInstance(500,500,Image.SCALE_SMOOTH);
//        background=new ImageIcon(temp);
//        JLabel back=new JLabel(background);
//        back.setLayout(null);
//        back.setBounds(0,0,500,500);



    }

  }
