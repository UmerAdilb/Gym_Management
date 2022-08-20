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
public class User {
    private Long id;
    private String userName;
    private String password;
    private String type;

    public void populate(ResultSet rs)throws SQLException {
        this.setId(Long.parseLong(rs.getString("id")));
        this.setUserName(rs.getString("username"));
        this.setPassword(rs.getString("password"));
        this.setType(rs.getString("type"));
    }
}
