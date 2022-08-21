package repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseConnection {

    Connection con;

    BaseConnection(){
        openConnection();

    }

    public void openConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/gym_management","root","root");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
