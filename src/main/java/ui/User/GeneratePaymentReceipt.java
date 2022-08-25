package ui.User;

import domain.Payment;
import services.AttendanceService;

import javax.swing.*;

public class GeneratePaymentReceipt {
    GeneratePaymentReceipt(Payment payment) {
        JFrame frame = new JFrame("SHOW Member");

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
        print.setBounds(120,450,175,20);

        JButton back= new JButton("Back");
        back.setBounds(350,450,125,20);

        frame.add(memid);
        frame.add(mid);
        frame.add(dates);
        frame.add(date);
        frame.add(month);
        frame.add(mmonth);
        frame.add(year);
        frame.add(myear);
        frame.add(tofees);
        frame.add(tf);
        frame.add(fp);
        frame.add(fpl);
        frame.add(rf);
        frame.add(rfl);
        frame.add(print);
        frame.add(back);

        print.addActionListener(btn->{

        });

        back.addActionListener(btn->{
            frame.dispose();
            new AddPayment();
        });


        frame.setLayout(null);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


}
