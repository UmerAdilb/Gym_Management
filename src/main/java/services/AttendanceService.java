package services;

import domain.Attendance;
import domain.Member;
import domain.Payment;
import domain.ViewAttendance;
import repository.AttendanceRepository;
import repository.MemberRepository;
import repository.PaymentRepository;


import javax.swing.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class AttendanceService {

    public static boolean AddAttendance(String date, String month, String year,Long memberid){

        AttendanceRepository attendanceRepository = new AttendanceRepository();
        Attendance attendance = new Attendance(date,month,year,memberid);

        if (attendanceRepository.addAttendance(attendance)){

            return true;
        }
        return false;
    }


    private static Integer getCalenderMonth(String month){
        switch (month){
            case  "january":
                return 0;
            case "february":
                return 1;
            case  "march":
                return 2;
            case "april":
                return 3;
            case  "may":
                return 4;
            case "june":
                return 5;
            case  "july":
                return 6;
            case "august":
                return 7;
                case  "september":
                return 8;
            case "october":
                return 9;
            case  "november":
                return 10;
            case "december":
                return 11;
        }

        return -1;

    }

    public static String[][] getAllAttendanceForJTable(int length, String month, String year, String memberid) {
        AttendanceRepository attendanceRepository = new AttendanceRepository();
        List<Attendance> attendance = attendanceRepository.getAllAttendance(month,year,memberid);
        // ViewAttendenceData
        // mid date ispresent isabsent status
        List<ViewAttendance> memberAttendeceList = new ArrayList<>();
        //getCalenderMonth
        Integer getCalenderMonth= getCalenderMonth(month);
        Calendar calendar = new GregorianCalendar(2022,getCalenderMonth,1);
        int numDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for(Integer i=1;i<=numDays;i++){
            String _date = i.toString();
            boolean check = attendance.stream().anyMatch(a->a.getDate().equalsIgnoreCase(_date) && a.getMonth().equalsIgnoreCase(month) &&
                    a.getYear().equalsIgnoreCase(year));
            if(check){
                memberAttendeceList.add(new ViewAttendance(memberid,_date,month,year,"TRUE"));
            }else{
              memberAttendeceList.add(new ViewAttendance(memberid,_date,month,year,"FALSE"));
            }
        }
        String[][] data  = new String[memberAttendeceList.size()][length];
        for(int row = 0 ; row < memberAttendeceList.size() ; row++){
            data[row][0] = memberAttendeceList.get(row).getMember_id();
            data[row][1] = memberAttendeceList.get(row).getDay();
            data[row][2] = memberAttendeceList.get(row).getMonth();
            data[row][3] = memberAttendeceList.get(row).getYear();
            data[row][4] = memberAttendeceList.get(row).getPresent();
        }
        return data;

    }
public static String[][] getAbsentTable(int length){
    Date date = new Date();
    LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    Integer today   = localDate.getDayOfMonth();
    Integer yesterday = today-1;
    Integer dayBeforeyes = today-2;
    MemberRepository memberRepository = new MemberRepository();
    List<Member> members = memberRepository.getAllAbsentMembers(today,yesterday,dayBeforeyes);

    String[][] data = new String[members.size()][length];
    for (int row = 0; row < members.size(); row++) {
        data[row][0] = members.get(row).getId().toString();
        data[row][1] = members.get(row).getName();
        data[row][2] = members.get(row).getGender();
        data[row][3] = members.get(row).getAge().toString();
        data[row][4] = members.get(row).getContact();
        data[row][5] = members.get(row).getAddress();
        data[row][6] = members.get(row).getStatus();
        data[row][7] = members.get(row).getGroupId().toString();


    }
    return data;
    }


    public static Boolean toInactivateMembers(String memberId) {
        MemberRepository memberRepository = new MemberRepository();

        if (memberRepository.updateMemberStatus(memberId,"INACTIVE")){

            return true;
        }
        return false;
    }

}
