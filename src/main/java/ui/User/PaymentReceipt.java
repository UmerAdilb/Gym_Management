package ui.User;

import services.MemberService;
import services.PaymentService;
import ui.Admin.AddMemberAdmin;

import javax.swing.*;
import java.awt.*;

public class PaymentReceipt {

    PaymentReceipt(){
        JFrame f=new JFrame("Payment");
        Container c = f.getContentPane();

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        panel1.setLayout(null);
        panel2.setLayout(null);
        panel3.setLayout(null);


        panel1.setBackground(Color.lightGray);
        panel1.setBounds(0,0,1000,100);
        panel2.setBounds(0,105,1000,400);
        panel3.setBounds(0,405,1000,700);



        JTextField monthTF = new JTextField(10);
        monthTF.setText("Month");
        monthTF.setBounds(15,10,120,30);

        JTextField yearTF = new JTextField(10);
        yearTF.setText("Year");
        yearTF.setBounds(150,10,120,30);

        JTextField memIdTF = new JTextField(10);
        memIdTF.setText("Member Id");
        memIdTF.setBounds(300,10,120,30);

        JButton search = new JButton("Search");
        search.setBounds(450,10,120,30);

        JButton back = new JButton("Back");
        back.setBounds(600,10,120,30);


        back.addActionListener(btn->{
            f.dispose();
            new MainUserUi();
        });
        JButton addPayment = new JButton("Add Payment");
        addPayment.setBounds(50,120,150,30);

        JButton updatePayment = new JButton("Update Payment");
        updatePayment.setBounds(250,120,150,30);

        addPayment.addActionListener(fl->{
            f.dispose();
            new AddPayment();
        });

        updatePayment.addActionListener(btn->{
            f.dispose();
            new UpdatePayment();
        });


        panel1.add(monthTF);
        panel1.add(yearTF);
        panel1.add(search);
        panel1.add(back);
        panel1.add(memIdTF);
        search.addActionListener(btn->{
            String column[]={"Id","Basic Fees","Fees Paid","Fees Remaining","Fees Status","Date","Month","Year","Member ID"};
            String data[][] = PaymentService.getAllPaymentsForJTable(column.length,monthTF.getText(),yearTF.getText(),memIdTF.getText());

            JTable jt=new JTable(data,column);
            JScrollPane sp=new JScrollPane(jt);
            sp.setBounds(0,0,1000,400);
            panel2.add(sp);
        });






panel3.add(addPayment);
panel3.add(updatePayment);


        c.add(panel1);
        c.add(panel2);
        c.add(panel3);
        f.setLayout(null);
        f.setSize(1000,860);
        f.setVisible(true);;
        f.setLocationRelativeTo(null);

        search.doClick();
    }

    public static void main(String[] args) {
        new PaymentReceipt();
    }

}

