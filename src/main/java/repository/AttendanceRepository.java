package repository;

import domain.Attendance;
import domain.Member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AttendanceRepository extends BaseConnection {

    public Boolean addAttendance(Attendance attendance) {
        try {
            if(con.isClosed()){
                openConnection();
            }
            PreparedStatement ps = con.prepareStatement(
                    "insert into attendance (date,month,year,member_id) values(?, ?, ?, ?);");
            ps.setString(1,attendance.getDate());
            ps.setString(2,attendance.getMonth());
            ps.setString(3,attendance.getYear());
            ps.setString(4,attendance.getMemberid().toString());


            int i=ps.executeUpdate();
            System.out.println(i+" records inserted");
            return true;

        }catch (Exception  e){
            System.out.println(e);
            return false; }
    }


}
