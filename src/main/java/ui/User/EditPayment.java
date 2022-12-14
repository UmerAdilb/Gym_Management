package ui.User;

import domain.Payment;
import services.MemberService;
import services.PaymentService;

import javax.swing.*;
import java.awt.*;

public class EditPayment {
    EditPayment(Payment payment){
        JFrame frame = new JFrame("Edit Payment");
        Container container = frame.getContentPane();

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        topPanel.setLayout(null);
        bottomPanel.setLayout(null);

        topPanel.setBackground(Color.GRAY);
        topPanel.setBounds(0, 0, 1000, 100);
        bottomPanel.setBackground(Color.lightGray);
        bottomPanel.setBounds(0, 100, 1000, 800);

        JLabel title = new JLabel("Edit PAYMENT");

        JLabel basicFees = new JLabel("Basic fees");
        JTextField basicFeesTf = new JTextField(10);
basicFeesTf.setText(payment.getBasic_fees().toString());
        JLabel feesPaid = new JLabel("Fees Paid");
        JTextField feesPaidTf = new JTextField(10);
feesPaidTf.setText(payment.getFees_paid().toString());
        JLabel feesRemaining = new JLabel("Fees Remaining");
        JTextField feesRemainingTf = new JTextField(10);
feesRemainingTf.setText(payment.getFees_remaining().toString());
        JLabel feesStatus = new JLabel("Fees Status");
        JTextField feesStatusTf = new JTextField(10);
feesStatusTf.setText(payment.getFees_status());

        JLabel date = new JLabel("Date");
        JTextField dateTf = new JTextField(10);
dateTf.setText(payment.getDate());
        JLabel month = new JLabel("Month");
        JTextField monthTf = new JTextField(10);
monthTf.setText(payment.getMonth());
        JLabel year = new JLabel("Year");
        JTextField yearTf = new JTextField(10);
yearTf.setText(payment.getYear());
        JLabel memberId = new JLabel("Member Id");
        JTextField memberIdTf = new JTextField(10);
memberIdTf.setText(payment.getMember_id().toString());

        JButton update = new JButton("Update");
        JButton backButton = new JButton(">");
        JButton generatereceipt = new JButton("Generate Receipt");



        basicFees.setBounds(250, 50, 150, 35);
        basicFeesTf.setBounds(400, 50, 150, 35);

        feesPaid.setBounds(250,100,150,35);
        feesPaidTf.setBounds(400,100,150,35);

        feesRemaining.setBounds(250, 150, 150, 35);
        feesRemainingTf.setBounds(400, 150, 150, 35);

        feesStatus.setBounds(250, 200, 150, 35);
        feesStatusTf.setBounds(400, 200, 150, 35);

        date.setBounds(250, 250, 150, 35);
        dateTf.setBounds(400, 250, 150, 35);

        month.setBounds(250, 300, 150, 35);
        monthTf.setBounds(400, 300, 150, 35);

        year.setBounds(250, 350, 150, 35);
        yearTf.setBounds(400, 350, 150, 35);

        memberId.setBounds(250, 400, 150, 35);
        memberIdTf.setBounds(400, 400, 150, 35);


        backButton.setBounds(900,5,50,50);
        update.setBounds(400, 550, 150, 35);
        generatereceipt.setBounds(385,600,180,35);

        update.addActionListener(btn->{
            Double _basicFees = Double.parseDouble(basicFeesTf.getText());
            Double _feesRemaining = Double.parseDouble(feesPaidTf.getText());
            Double _feesPaid = Double.parseDouble(feesRemainingTf.getText());
            String _feesStatus = feesStatusTf.getText();
            String _date = dateTf.getText();
            String _month = monthTf.getText();
            String _year = yearTf.getText();
            Long _memberId = Long.parseLong(memberIdTf.getText());
            Boolean updatePay = PaymentService.updatePayment(payment.getId(),_basicFees,_feesPaid,_feesRemaining,_feesStatus,_date,_month,_year,_memberId);
            if (updatePay){
                JOptionPane.showMessageDialog(frame,"Record Update Succesfully");
            }else {
                JOptionPane.showMessageDialog(frame,"Error! Record not Updated");
            }


        });

        generatereceipt.addActionListener(btn->{
//            Double _basicFees = Double.parseDouble(basicFeesTf.getText());
//            Double _feesRemaining = Double.parseDouble(feesPaidTf.getText());
//            Double _feesPaid = Double.parseDouble(feesRemainingTf.getText());
//            String _feesStatus = feesStatusTf.getText();
            String _date = dateTf.getText();
            String _month = monthTf.getText();
            String _year = yearTf.getText();
            Long _memberId = Long.parseLong(memberIdTf.getText());
            if (_memberId == null)
            {
                JOptionPane.showMessageDialog(frame,"Record Added Succesfully");
            }

            Payment pay = PaymentService.ShowPaymentOfSpecificMember(_date,_month,_year,_memberId);
            new GeneratePaymentReceipt(pay);

        });

        backButton.addActionListener(btn->{
            frame.dispose();
            new PaymentReceipt();
        });
bottomPanel.add(generatereceipt);
        topPanel.add(title);
        bottomPanel.add(basicFees);
        bottomPanel.add(basicFeesTf);
        bottomPanel.add(feesPaid);
        bottomPanel.add(feesPaidTf);
        bottomPanel.add(feesRemaining);
        bottomPanel.add(feesRemainingTf);
        bottomPanel.add(feesStatus);
        bottomPanel.add(feesStatusTf);
        bottomPanel.add(date);
        bottomPanel.add(dateTf);
        bottomPanel.add(month);
        bottomPanel.add(monthTf);
        bottomPanel.add(year);
        bottomPanel.add(yearTf);
        bottomPanel.add(memberId);
        bottomPanel.add(memberIdTf);
        bottomPanel.add(update);
        bottomPanel.add(backButton);

        container.add(topPanel);
        container.add(bottomPanel);

        frame.setLayout(null);
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    }

