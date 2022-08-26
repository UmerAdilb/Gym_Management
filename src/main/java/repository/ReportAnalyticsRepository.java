package repository;

import domain.Member;
import domain.Payment;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class ReportAnalyticsRepository extends BaseConnection {


    public Double gettotalfees() {
      Double  totalfee =0.0;

        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(" SELECT SUM(basic_fees) totalfeesofmembers FROM payment");

            while (rs.next()){
                totalfee = Double.parseDouble(rs.getString("totalfeesofmembers"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return totalfee;

    }
    public Double getRemainingfees() {
        Double  remainFees =0.0;

        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(" SELECT SUM(fees_remaining) totalfeesremainingofmembers FROM payment;");

            while (rs.next()){
                remainFees = Double.parseDouble(rs.getString("totalfeesremainingofmembers"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return remainFees;

    }


    public Double getCollectedfees() {
        Double  collectedfee =0.0;

        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(fees_paid) totalfeespaidbymembers FROM payment;");

            while (rs.next()){
                collectedfee = Double.parseDouble(rs.getString("totalfeespaidbymembers"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return collectedfee;

    }

    public Long gettotalMember() {
        Long totalnum =0L;

        try{
            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT COUNT(id) as totalmembers FROM member");
            ResultSet rs = st.executeQuery("SELECT COUNT(id) as totalmembers FROM member;");

            while (rs.next()){
                totalnum = Long.parseLong(rs.getString("totalmembers"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return totalnum;

    }

    public Long getActiveMember() {
        Long activemembers =0L;

        try{
            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT COUNT(id) as totalmembers FROM member");
            ResultSet rs = st.executeQuery("SELECT COUNT(id) as ActiveMembers FROM member where status='ACTIVE';");

            while (rs.next()){
                activemembers = Long.parseLong(rs.getString("ActiveMembers"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return activemembers;

    }

    public Long getInactiveMember() {
        Long inactivemembers =0L;

        try{
            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT COUNT(id) as totalmembers FROM member");
            ResultSet rs = st.executeQuery("SELECT COUNT(id) as InactiveMembers FROM member where status='inactive';");

            while (rs.next()){
                inactivemembers = Long.parseLong(rs.getString("InactiveMembers"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return inactivemembers;

    }

    public  Long getnewmembers(){
        Long newmembers =0L;
        LocalDate currentdate = LocalDate.now();

        Month currentMonth = currentdate.getMonth();
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(id) as countofcurrentmonth FROM payment where month='"+currentMonth+"' ");
            while (rs.next()){
                newmembers = Long.parseLong(rs.getString("countofcurrentmonth"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return newmembers;
    }


    public static void main(String[] args) {
        ReportAnalyticsRepository a = new ReportAnalyticsRepository();

    }
}
