package ui.User;

import domain.Member;
import domain.Payment;
import services.MemberService;
import services.PaymentService;
import ui.Admin.EditMemberAdmin;
import ui.Admin.ManageMember;

import javax.swing.*;

public class UpdatePayment {
    UpdatePayment(){
        JFrame frame = new JFrame("Update Payment");

        JLabel paymentidLb = new JLabel("Enter the Payment id to update");
        paymentidLb.setBounds(180,60,250,120);
        JTextField paymentidTf = new JTextField();
        paymentidTf.setBounds(200,150,150,20);

        JButton btnNext = new JButton();
        btnNext.setBounds(190,300,90,40);
        btnNext.setText("Next");

        JButton backBtn = new JButton();
        backBtn.setBounds(290,300,90,40);
        backBtn.setText("Back");


        frame.add(paymentidLb);
        frame.add(paymentidTf);

        frame.add(btnNext);
        frame.add(backBtn);

        btnNext.addActionListener(btn->{

            frame.dispose();
            Payment payment = PaymentService.checkPaymentbyId(Long.parseLong(paymentidTf.getText()));
            if (payment != null){
                frame.dispose();
                new EditPayment(payment);

            }else {
                JOptionPane.showMessageDialog(frame,"Error!");
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
