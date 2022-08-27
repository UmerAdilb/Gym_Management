package repository;


import domain.Payment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepository extends BaseConnection{
    public List<Payment> getAllPayments(String month, String year, String memID) {
List<Payment> paylist = new ArrayList<>();

        try{
            String query = generateQuery(month,year,memID);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                Payment py  = new Payment();
                py.populate(rs);
                paylist.add(py);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return paylist;
    }

    private String generateQuery(String month, String year,String id) {
        String query = "select * from payment";
        if(!month.equalsIgnoreCase("Month") && !year.equalsIgnoreCase("Year") && !id.equalsIgnoreCase("Member Id")){
            query = query + " where month = '"+month+"' and year='"+year+"' and member_id = "+id+" " ;
        }else if(!month.equalsIgnoreCase("Month") && year.equalsIgnoreCase("Year") && id.equalsIgnoreCase("Member Id")){
            query=query + " where month = '"+month+"'";
        }else if (!year.equalsIgnoreCase("Year") && month.equalsIgnoreCase("Month") && id.equalsIgnoreCase("Member Id")){
            query = query +" where year = '"+year+"'";
        }else if (!id.equalsIgnoreCase("Member Id") && month.equalsIgnoreCase("Month") && year.equalsIgnoreCase("Year")){
            query = query +" where member_id = '"+id+"'";
        }else if(!month.equalsIgnoreCase("Month") && !year.equalsIgnoreCase("Year")){
            query = query +" where year = '"+year+"' and month = '"+month+"'";
        }else if (!month.equalsIgnoreCase("Month") && !id.equalsIgnoreCase("Member Id"))
        { query = query +" where member_id = "+id+" and month = '"+month+"'";}
        else if (!year.equalsIgnoreCase("Year") && !id.equalsIgnoreCase("Member Id")){
            query = query +" where member_id = "+id+" and year = '"+year+"'";}

        return query;


    }

    public Boolean AddPaymentinDB(Double basicFees, Double feesPaid, Double feesRemaining, String feesStatus, String date, String month, String year, Long memberId) {
        try {
            if(con.isClosed()){
                openConnection();
            }
            PreparedStatement ps = con.prepareStatement(
                    "insert into payment (basic_fees,fees_paid,fees_remaining,fees_status,date,month,year,member_id) values(?, ?, ?, ?, ?, ?, ?, ?);");
            ps.setString(1,basicFees.toString());
            ps.setString(2,feesPaid.toString());
            ps.setString(3,feesRemaining.toString());
            ps.setString(4,feesStatus);
            ps.setString(5,date);
            ps.setString(6,month);
            ps.setString(7,year);
            ps.setString(8,memberId.toString());


            int i=ps.executeUpdate();
            System.out.println(i+" records inserted");
            return true;

        }catch (Exception  e){
            System.out.println(e);
            return false; }

    }

    public Payment getspecificPayments( String date, String month, String year, Long memberId) {

           Payment pay = new Payment();
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from payment where member_id ="+memberId+" and date='"+date+"' and month='"+month+"' and year='"+year+"' ;");
            while (rs.next()){
                pay.populate(rs);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return pay;
    }

    public Payment getPaymentbyId(Long id) {
        Payment payment = new Payment();

        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from payment where id= "+id+" ");

            while (rs.next()){
                payment.populate(rs);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return payment;
    }

    public boolean updatePaymentId(Long id,Double basicFees, Double feesPaid, Double feesRemaining, String feesStatus, String date, String month, String year, Long memberId){
        try{
            if(con.isClosed()){
                openConnection();
            }
            Statement st = con.createStatement();

            st.executeUpdate("update payment set basic_fees = '"+basicFees+"', fees_paid = '"+feesPaid+"', fees_remaining = "+feesRemaining+"" +
                    ", fees_status = '"+feesStatus+"', date = '"+date+"', month = '"+month+"', year = "+year+" where member_id = "+memberId+" ");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;}
    }

    public Payment checkPayentthroughContactMonthYr(String contact, String month, String year) {
       Payment pay = new Payment();

        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(
                    "select p.id,p.basic_fees,p.fees_paid,p.fees_remaining,p.fees_status,p.date,p.month,p.year,p.member_id from payment p inner join member m on p.member_id = m.id where m.contact='"+contact+"' and p.month= '"+month+"' and p.year='"+year+"' ");

            while (rs.next()){
                pay.populate(rs);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return pay;

    }
}

