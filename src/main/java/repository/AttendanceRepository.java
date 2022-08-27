package repository;

import domain.Attendance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AttendanceRepository extends BaseConnection {

    public void addAttendance(Attendance attendance) {
        try {
            if (con.isClosed()) {
                openConnection();
            }
            PreparedStatement ps = con.prepareStatement(
                    "insert into attendance (date,month,year,member_id) values(?, ?, ?, ?);");
            ps.setString(1, attendance.getDate());
            ps.setString(2, attendance.getMonth());
            ps.setString(3, attendance.getYear());
            ps.setString(4, attendance.getMemberid().toString());


            int i = ps.executeUpdate();
            System.out.println(i + " records inserted");


        } catch (Exception e) {
            System.out.println(e);

        }
    }


    public List<Attendance> getAllAttendance( String month, String year, String memberid) {
        List<Attendance> attendances = new ArrayList<>();

        try {
            String query = "select * from attendance where month='"+month+"' and year = '"+year+"' and member_id ="+memberid+"";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Attendance at = new Attendance();
                at.populate(rs);
                attendances.add(at);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return attendances;

    }


    public Attendance checkAttendance(String date, String month, String year, String memberid) {

        Attendance  attend = new Attendance();
        try {

            Statement st = con.createStatement() ;
            ResultSet rs = st.executeQuery("select * from attendance where date='"+date+"' and month='"+month+"' and year = '"+year+"' and member_id ="+memberid+" ");

            while (rs.next()) {

                attend.populate(rs);

            }
            return attend;

        } catch (Exception e) {
            e.printStackTrace();
        }

    return null;}
}