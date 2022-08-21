package domain;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Trainer {
    private Long id;
    private String name;
    private String gender;
    private Integer age;
    private String contact;
    private String address;

    public Trainer(String name, String gender, Integer age, String contact, String address) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.contact = contact;
        this.address = address;
    }

    public void populate(ResultSet rs) throws SQLException {

        this.setId(Long.parseLong(rs.getString("id")));
        this.setName(rs.getString("name"));
        this.setGender(rs.getString("gender"));
        this.setAge(Integer.parseInt(rs.getString("age")));
        this.setContact(rs.getString("contact"));
        this.setAddress(rs.getString("address"));
    }
}
