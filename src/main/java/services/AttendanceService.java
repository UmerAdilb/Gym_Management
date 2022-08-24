package services;

import domain.Attendance;
import domain.Member;
import repository.AttendanceRepository;
import repository.MemberRepository;


import java.util.List;

public class AttendanceService {

    public static boolean AddAttendance(String date, String month, String year,Long memberid){

        AttendanceRepository attendanceRepository = new AttendanceRepository();
        Attendance attendance = new Attendance(date,month,year,memberid);

        if (attendanceRepository.addAttendance(attendance)){

            return true;
        }
        return false;
    }

}
