package ui.User;

import services.AttendanceService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class DeActivateMembers {


    public DeActivateMembers() {

        JFrame f = new JFrame("DEACTIVATE ATTENDANCE");
        Container c = f.getContentPane();
        final int[] Row = new int[1];
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        panel1.setLayout(null);
        panel2.setLayout(null);

        panel1.setBackground(Color.lightGray);
        panel2.setBackground(Color.lightGray);
        panel1.setBounds(0, 0, 800, 400);
        panel2.setBounds(0, 400, 800, 400);


        JLabel title = new JLabel("INACTIVE MEMBERS" );
        title.setBounds(275,15 ,250,20);
        title.setFont(new Font("Serif", Font.BOLD, 20));

        String column[]={"Id","Name","Gender","Age","Contact","Address","Status","Group ID"};
        String data[][] = AttendanceService.getAbsentTable(column.length);
        JTable jt=new JTable(data,column);
        JScrollPane sp=new JScrollPane(jt);
        sp.setBounds(15,50,750,300);
        panel1.add(sp);
        ListSelectionModel app_model = jt.getSelectionModel();
        app_model.addListSelectionListener(e->{
            String selectedId =jt.getModel().getValueAt(Row[0],0).toString();
            Boolean status = AttendanceService.toInactivateMembers(selectedId);
            if (status){JOptionPane.showMessageDialog(f,"Status changed Succesfully");
            }else {JOptionPane.showMessageDialog(f,"Error! Status Not Changed");}
new DeActivateMembers();
            f.dispose();

//            if (!app_model.isSelectionEmpty()){
//                int selectedRow = app_model.getMinSelectionIndex();
//               System.out.println(selectedRow);
//                Row[0] = selectedRow;
//                System.out.println(Row[0]);
//            }
//            String[] options = new String[] {"Yes", "No", "Maybe", "Cancel"};
//
//            int response = JOptionPane.showOptionDialog(null, "Message", "Title",
//                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
//                    null, btn,JOptionPane.getDesktopPaneForComponent(null));
        });
//
//        JButton inActive = new JButton("INACTIVATE");
//        inActive.setBounds(300,50,150,40);
        JButton btnBack = new JButton("BACK");
        btnBack.setBounds(300,150,150,40);
//
//        JTextField memberId = new JTextField();
//        memberId.setBounds(20,50,150,40)
//        ;memberId.setText("Member ID");

//        inActive.addActionListener(el->{
//            if (memberId.getText().equalsIgnoreCase("Member ID")){
//                JOptionPane.showMessageDialog(f,"Please enter the member id");
//            }else {
//            Boolean status = AttendanceService.toInactivateMembers(memberId.getText());
//            if (status){JOptionPane.showMessageDialog(f,"Status changed Succesfully");
//            }else {JOptionPane.showMessageDialog(f,"Error! Status Not Changed");}
//
//        }});
        btnBack.addActionListener(el->{
            f.dispose();
            new ManageAttendance();
        });



//        panel2.add(inActive);
//        panel2.add(memberId);
panel2.add(btnBack);
panel1.add(title);
        c.add(panel1);
        c.add(panel2);
        f.setLayout(null);
        f.setSize(800, 800);
        f.setVisible(true);
        f.setLocationRelativeTo(null);


    }

    public static void main(String[] args) {
        new DeActivateMembers();
    }
}