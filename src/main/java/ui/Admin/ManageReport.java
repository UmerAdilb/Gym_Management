package ui.Admin;

import domain.ReportAnalytics;

import javax.swing.*;
import java.awt.*;

public class ManageReport {
    public ManageReport(ReportAnalytics repo){

        JFrame frame = new JFrame("Member Report");
        Container container = frame.getContentPane();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        panel1.setLayout(null);
        panel2.setLayout(null);

        panel1.setBackground(Color.GRAY);
        panel1.setBounds(0, 0, 200, 600);
        panel2.setBounds(200, 0, 400, 600);

        JLabel totalmem = new JLabel("Total Members:");
        totalmem.setBounds(10,10,150,100);
        JLabel totalmemid = new JLabel();
        totalmemid.setBounds(150,10,150,100);
        totalmemid.setText(repo.getTotalMember().toString());

        JLabel cf = new JLabel("Collected Fees:");
        cf.setBounds(10,50,150,100);
        JLabel cfi = new JLabel();
        cfi.setBounds(150,50,150,100);
        cfi.setText(repo.getFeesCollected().toString());

        JLabel rf = new JLabel("Remaining Fees:");
        rf.setBounds(10,90,150,100);
        JLabel rfi = new JLabel();
        rfi.setBounds(150,90,150,100);
        rfi.setText(repo.getFessRemaining().toString());

        JLabel tf = new JLabel("Total Fees:");
        tf.setBounds(10,130,150,100);
        JLabel tfi = new JLabel();
        tfi.setBounds(150,130,150,100);
        tfi.setText(repo.getTotalfees().toString());

        JLabel nm = new JLabel("New Members:");
        nm.setBounds(10,170,150,100);
        JLabel nmi = new JLabel();
        nmi.setBounds(150,170,150,100);
        nmi.setText(repo.getNewmembers().toString());

        JLabel im = new JLabel("InActive Members:");
        im.setBounds(10,210,150,100);
        JLabel imi = new JLabel();
        imi.setBounds(150,210,150,100);
        imi.setText(repo.getMembersLeft().toString());

        JLabel am = new JLabel("Active Members:");
        am.setBounds(10,250,150,100);
        JLabel ami = new JLabel();
        ami.setBounds(150,250,150,100);
        ami.setText(repo.getActiveMembers().toString());


        JButton print= new JButton("PRINT");
        print.setBounds(10,335,175,20);

        JButton back= new JButton("Back");
        back.setBounds(30,375,125,20);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(10,10,400,600);
        textArea.setFont(new Font("Calibri",Font.BOLD,15));
        textArea.setText("*********************\n");
        textArea.setText(textArea.getText()+"********Report********\n");
        textArea.setText(textArea.getText()+"*********************\n");
        textArea.setText(textArea.getText()+"\n");
        textArea.setText(textArea.getText()+"\n");
        textArea.setText(textArea.getText()+"        Total Members      :      "+repo.getTotalMember().toString()+"\n");
        textArea.setText(textArea.getText()+"        Active Member      :      "+repo.getActiveMembers()+"\n");
        textArea.setText(textArea.getText()+"        New Member         :      "+repo.getNewmembers()+"\n");
        textArea.setText(textArea.getText()+"        Members Left       :      "+repo.getMembersLeft()+"\n");
        textArea.setText(textArea.getText()+"        Total Amount       :      "+repo.getTotalfees()+"\n");
        textArea.setText(textArea.getText()+"        Total Revenue      :      "+repo.getFeesCollected()+"\n");
        textArea.setText(textArea.getText()+"        Amount Remains     :      "+repo.getFessRemaining()+"\n");





//        title.setForeground(Color.DARK_GRAY);
//        title.setFont(new Font("Serif",Font.BOLD,45));
//        printBill.setFont(new Font("Serif",Font.BOLD,14));
//
//
//
//
//        title.setBounds(40,60,400,60);
//
//        printBill.setBounds(80,300,350,50);



        print.addActionListener(btn->{
            try{
                textArea.print();
            }catch (Exception e){
                System.out.println(e);
            }
        });












        panel1.add(totalmem);
        panel1.add(totalmemid);
        panel1.add(cf);
        panel1.add(cfi);
        panel1.add(rf);
        panel1.add(rfi);
        panel1.add(tf);
        panel1.add(tfi);
        panel1.add(nm);
        panel1.add(nmi);
        panel1.add(im);
        panel1.add(imi);
        panel1.add(am);
        panel1.add(ami);
        panel1.add(print);
        panel1.add(back);
        panel2.add(textArea);
//
//        print.addActionListener(btn->{
//
//        });
//
//        back.addActionListener(btn->{
//            frame.dispose();
//            new AddPayment();
//        });

        container.add(panel1);
        container.add(panel2);
        frame.setLayout(null);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    }


