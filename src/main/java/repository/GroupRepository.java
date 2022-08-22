package repository;

import domain.Group;
import domain.Member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GroupRepository extends BaseConnection {

    public List<Group> getAllGroups(){
        List<Group> group = new ArrayList<>();
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from member_groups");

            while (rs.next()){
                Group gr = new Group();
                gr.populate(rs);
                group.add(gr);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return group;
    }

    public Group getGroupbyId(Long id) {
        Group gr = new Group();

        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from member_groups where id= "+id+" ");

            while (rs.next()){
                gr.populate(rs);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return gr;
    }

    public boolean updateGroupbyId(Long id, String name, String timing, String type, Long trainerid){
        try{
            if(con.isClosed()){
                openConnection();
            }
            Statement st = con.createStatement();

            st.executeUpdate("update member_groups set name = '"+name+"', timing = '"+timing+"', type = '"+type+"', trainer_id = "+trainerid+" where id = "+id+" ");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;}
    }

    public Boolean addGroup(Group group) {
        try {
            if(con.isClosed()){
                openConnection();
            }
            PreparedStatement ps = con.prepareStatement(
                    "insert into member_groups (name,timing,type,trainer_id) values(?, ?, ?, ?);");
            ps.setString(1,group.getName());
            ps.setString(2,group.getTiming());
            ps.setString(3,group.getType());
            ps.setString(4,group.getTrainerId().toString());


            int i=ps.executeUpdate();
            System.out.println(i+" records inserted");
            return true;

        }catch (Exception  e){
            System.out.println(e);
            return false; }
    }

    public boolean deleteGroupbyId(long id) {

        try{
            if(con.isClosed()){
                openConnection();
            }
            Statement st = con.createStatement();

            st.executeUpdate("delete from member_groups where id ="+id+"" );

            return true;
        }catch (Exception e){
            e.printStackTrace();}
        return false; }
}
