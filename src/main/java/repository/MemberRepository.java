package repository;

import domain.Member;
import domain.Trainer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository extends BaseConnection{

    public List<Member> getAllMembers(){
      List<Member> members = new ArrayList<>();
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from member");

            while (rs.next()){
                Member mem = new Member();
                mem.populate(rs);
                members.add(mem);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return members;
    }

    public Boolean addMember(Member member) {
        try {
            if(con.isClosed()){
                openConnection();
            }
            PreparedStatement ps = con.prepareStatement(
                    "insert into member (name,gender,age,contact,address,status,group_id) values(?, ?, ?, ?, ?, ?, ?);");
            ps.setString(1,member.getName());
            ps.setString(2,member.getGender());
            ps.setString(3,member.getAge().toString());
            ps.setString(4,member.getContact());
            ps.setString(5,member.getAddress());
            ps.setString(6,member.getStatus());
            ps.setString(7,member.getGroupId().toString());


            int i=ps.executeUpdate();
            System.out.println(i+" records inserted");
            return true;

        }catch (Exception  e){
            System.out.println(e);
            return false; }
    }


    public Member getMemberbyId(Long id) {
        Member mem = new Member();

        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from member where id= "+id+" ");

            while (rs.next()){
                mem.populate(rs);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return mem;
    }

    public boolean updateMemberbyId(Long id, String name, String gender, Integer age, String contact, String address, String status, Long groupid){
        try{
            if(con.isClosed()){
                openConnection();
            }
            Statement st = con.createStatement();

            st.executeUpdate("update member set name = '"+name+"', gender = '"+gender+"', age = "+age+"" +
                    ", contact = '"+contact+"', address = '"+address+"',status = '"+status+"', group_id = "+groupid+" where id = "+id+" ");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;}
    }

    public boolean deleteMemberbyId(long id) {

        try{
            if(con.isClosed()){
                openConnection();
            }
            Statement st = con.createStatement();

            st.executeUpdate("delete from member where id ="+id+"" );

            return true;
        }catch (Exception e){
            e.printStackTrace();}
        return false; }

}




