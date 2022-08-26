package ui.User;

import domain.Member;
import domain.Payment;
import services.MemberService;
import services.PaymentService;

import javax.swing.*;
import java.awt.*;

public class AddPayment {
    public AddPayment(){
        JFrame frame = new JFrame("Add Payment");
        Container container = frame.getContentPane();

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        topPanel.setLayout(null);
        bottomPanel.setLayout(null);

        topPanel.setBackground(Color.GRAY);
        topPanel.setBounds(0, 0, 1000, 100);
        bottomPanel.setBackground(Color.lightGray);
        bottomPanel.setBounds(0, 100, 1000, 800);

        JLabel title = new JLabel("ADD PAYMENT");

        JLabel basicFees = new JLabel("Basic fees");
        JTextField basicFeesTf = new JTextField(10);

        JLabel feesPaid = new JLabel("Fees Paid");
        JTextField feesPaidTf = new JTextField(10);

        JLabel feesRemaining = new JLabel("Fees Remaining");
        JTextField feesRemainingTf = new JTextField(10);

        JLabel feesStatus = new JLabel("Fees Status");
        JTextField feesStatusTf = new JTextField(10);

        JLabel date = new JLabel("Date");
        JTextField dateTf = new JTextField(10);

        JLabel month = new JLabel("Month");
        JTextField monthTf = new JTextField(10);

        JLabel year = new JLabel("Year");
        JTextField yearTf = new JTextField(10);

        JLabel memberId = new JLabel("Member Id");
        JTextField memberIdTf = new JTextField(10);


        JButton Add = new JButton("Add");
        JButton generatereceipt = new JButton("Generate Receipt");
        JButton backButton = new JButton(">");



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
        Add.setBounds(400, 550, 150, 35);
        generatereceipt.setBounds(385,600,180,35);

        Add.addActionListener(btn->{
            Double _basicFees = Double.parseDouble(basicFeesTf.getText());
            Double _feesPaid = Double.parseDouble(feesPaidTf.getText());
            Double _feesRemaining = Double.parseDouble(feesRemainingTf.getText());
            String _feesStatus = feesStatusTf.getText();
            String _date = dateTf.getText();
            String _month = monthTf.getText();
            String _year = yearTf.getText();
            Long _memberId = Long.parseLong(memberIdTf.getText());
            Boolean addPay = PaymentService.addPayment(_basicFees,_feesPaid,_feesRemaining,_feesStatus,_date,_month,_year,_memberId);
            if (addPay){
                JOptionPane.showMessageDialog(frame,"Record Added Succesfully");
            }else {
                JOptionPane.showMessageDialog(frame,"Error! Record not added");
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
            Payment pay = PaymentService.ShowPaymentOfSpecificMember(_date,_month,_year,_memberId);
                new GeneratePaymentReceipt(pay);

        });

        backButton.addActionListener(btn->{
            frame.dispose();
            new PaymentReceipt();
        });

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
        bottomPanel.add(Add);
        bottomPanel.add(backButton);
        bottomPanel.add(generatereceipt);

        container.add(topPanel);
        container.add(bottomPanel);

        frame.setLayout(null);
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }


    }

