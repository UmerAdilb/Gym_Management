package ui.User;

import domain.Payment;
import services.AttendanceService;

import javax.swing.*;
import java.awt.*;

public class GeneratePaymentReceipt {
    GeneratePaymentReceipt(Payment payment) {
        JFrame frame = new JFrame("Print Receipt");
        Container container = frame.getContentPane();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        panel1.setLayout(null);
        panel2.setLayout(null);

        panel1.setBackground(Color.GRAY);
        panel1.setBounds(0, 0, 200, 600);
        panel2.setBounds(200, 0, 400, 600);

        JLabel memid = new JLabel("Member ID:");
        memid.setBounds(10,10,150,100);
        JLabel mid = new JLabel();
        mid.setBounds(150,10,150,100);
        mid.setText(payment.getMember_id().toString());

        JLabel dates = new JLabel("Date:");
        dates.setBounds(10,50,150,100);
        JLabel date = new JLabel();
        date.setBounds(150,50,150,100);
        date.setText(payment.getDate());

        JLabel month = new JLabel("Month:");
        month.setBounds(10,90,150,100);
        JLabel mmonth = new JLabel();
        mmonth.setBounds(150,90,150,100);
        mmonth.setText(payment.getMonth());

        JLabel year = new JLabel("Year:");
        year.setBounds(10,130,150,100);
        JLabel myear = new JLabel();
        myear.setBounds(150,130,150,100);
        myear.setText(payment.getYear());

        JLabel tofees = new JLabel("Total Fees:");
        tofees.setBounds(10,170,150,100);
        JLabel tf = new JLabel();
        tf.setBounds(150,170,150,100);
        tf.setText(payment.getBasic_fees().toString());

        JLabel fp = new JLabel("Fees Paid:");
        fp.setBounds(10,210,150,100);
        JLabel fpl = new JLabel();
        fpl.setBounds(150,210,150,100);
        fpl.setText(payment.getFees_paid().toString());

        JLabel rf = new JLabel("Remaining Fees:");
        rf.setBounds(10,250,150,100);
        JLabel rfl = new JLabel();
        rfl.setBounds(150,250,150,100);
        rfl.setText(payment.getFees_remaining().toString());


        JButton print= new JButton("PRINT");
        print.setBounds(10,335,175,20);

        JButton back= new JButton("Back");
        back.setBounds(30,375,125,20);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(10,10,400,600);
        textArea.setFont(new Font("Calibri",Font.BOLD,15));
        textArea.setText("**********************\n");
        textArea.setText(textArea.getText()+"***PAYMENT RECEIPT***\n");
        textArea.setText(textArea.getText()+"**********************\n");
        textArea.setText(textArea.getText()+"\n");
        textArea.setText(textArea.getText()+"\n");
        textArea.setText(textArea.getText()+"        Member Id          :      "+payment.getMember_id().toString()+"\n");
        textArea.setText(textArea.getText()+"        Date               :      "+payment.getDate()+"\n");
        textArea.setText(textArea.getText()+"        Month              :      "+payment.getMonth()+"\n");
        textArea.setText(textArea.getText()+"        Year               :      "+payment.getYear()+"\n");
        textArea.setText(textArea.getText()+"        Total Fees         :      "+payment.getBasic_fees()+"\n");
        textArea.setText(textArea.getText()+"        Fees Paid          :      "+payment.getFees_paid()+"\n");
        textArea.setText(textArea.getText()+"        Remaining Fees     :      "+payment.getFees_remaining()+"\n");


        print.addActionListener(btn->{
            try{
                textArea.print();
            }catch (Exception e){
                System.out.println(e);
            }
        });

        back.addActionListener(btn->{
            frame.dispose();
            new AddPayment();
        });

        panel1.add(memid);
        panel1.add(mid);
        panel1.add(dates);
        panel1.add(date);
        panel1.add(month);
        panel1.add(mmonth);
        panel1.add(year);
        panel1.add(myear);
        panel1.add(tofees);
        panel1.add(tf);
        panel1.add(fp);
        panel1.add(fpl);
        panel1.add(rf);
        panel1.add(rfl);
        panel1.add(print);
        panel1.add(back);
        panel2.add(textArea);


        container.add(panel1);
        container.add(panel2);
        frame.setLayout(null);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
    }
}
