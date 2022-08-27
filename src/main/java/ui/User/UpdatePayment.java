package ui.User;

import domain.Member;
import domain.Payment;
import services.MemberService;
import services.PaymentService;
import ui.Admin.EditMemberAdmin;
import ui.Admin.ManageMember;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.Month;

public class UpdatePayment {
    UpdatePayment(){
        JFrame frame = new JFrame("Update Payment");
        LocalDate currentdate = LocalDate.now();

        Month currentMonth = currentdate.getMonth();

        int currenY = currentdate.getYear();

        JLabel paymentidLb = new JLabel("Enter the Payment ID for Update");
        paymentidLb.setBounds(120,60,350,30);
        paymentidLb.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        JLabel payId = new JLabel("Payment ID");
        payId.setBounds(150,150,80,20);
        JTextField payIDtf = new JTextField();
        payIDtf.setBounds(250,150,150,20);


        JButton btnNext = new JButton();
        btnNext.setBounds(150,350,90,40);
        btnNext.setText("Next");

        JButton backBtn = new JButton();
        backBtn.setBounds(300,350,90,40);
        backBtn.setText("Back");

        frame.add(paymentidLb);
        frame.add(payIDtf);
        frame.add(payId);
        frame.add(btnNext);
        frame.add(backBtn);

        btnNext.addActionListener(btn->{

           frame.dispose();
           Payment payment = PaymentService.checkPaymentbyId(Long.parseLong(payIDtf.getText()));
            if (payment != null){
                frame.dispose();
                new EditPayment(payment);

            }else {
                JOptionPane.showMessageDialog(frame,"Wrong Input");
            }


        });

        backBtn.addActionListener(btn->{
            frame.dispose();
            new PaymentReceipt();
        });



        frame.setLayout(null);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new UpdatePayment();
    }
}
