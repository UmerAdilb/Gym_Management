package repository;

import domain.Trainer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TrainerRepository extends BaseConnection {
    public List<Trainer> GetAllTrainers(){
        List<Trainer> trainerlist = new ArrayList<>();
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from trainer");

            while (rs.next()){
                Trainer trainer = new Trainer();
                trainer.populate(rs);
                trainerlist.add(trainer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return trainerlist;
    }

    public void addTrainer(Trainer trainer) {
        try {
            if(con.isClosed()){
                openConnection();
            }
            PreparedStatement ps = con.prepareStatement(
                    "insert into trainer (name,gender,age,contact,address) values(?, ?, ?, ?, ?);");
            ps.setString(1,trainer.getName());
            ps.setString(2,trainer.getGender());
            ps.setString(3,trainer.getAge().toString());
            ps.setString(4,trainer.getContact());
            ps.setString(5,trainer.getAddress());
            int i=ps.executeUpdate();
            System.out.println(i+" records inserted");

        }catch (Exception  e){
            System.out.println(e);
        }
    }

    public Boolean deleteTrainerThroughID(Long id) {
        try{
            if(con.isClosed()){
                openConnection();
            }
            Statement st = con.createStatement();

            st.executeUpdate("delete from trainer where id ="+id+"" );

            return true;
        }catch (Exception e){
            e.printStackTrace();}
        return false; }

    public Trainer getTrainersthroughName(Long id){

        Trainer train = new Trainer();
        try{
            if(con.isClosed()){
                openConnection();
            }
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from trainer where id = '"+id+"'");

            while (rs.next()){

                train.populate(rs);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return train;
    }

    public Boolean UpdateTrainer(String name, String gender, Integer age, String contact, String address, Long id){

        try{
            if(con.isClosed()){
                openConnection();
            }
            Statement st = con.createStatement();
            st.executeUpdate("update trainer set name = '"+name+"', gender = '"+gender+"', age = '"+age+"', contact = '"+contact+"', address = '"+address+"' where id="+id+" ");

            return true;
        }catch (Exception e){
            e.printStackTrace();}
        return false; }
}
