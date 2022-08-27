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
public class Group {
    private Long id;
    private String name;
    private String timing;
    private String type;
    private Long trainerId;
    private String trainerName;

    public Group(Long id, String name, String timing, String type, Long trainerId) {
        this.id = id;
        this.name = name;
        this.timing = timing;
        this.type = type;
        this.trainerId = trainerId;
    }

    public Group(String name, String timing, String type, Long trainerId) {
        this.name = name;
        this.timing = timing;
        this.type = type;
        this.trainerId = trainerId;
    }

    public void populate(ResultSet rs) throws SQLException {

        this.setId(Long.parseLong(rs.getString("id")));
        this.setName(rs.getString("name"));
        this.setTiming(rs.getString("timing"));
        this.setType(rs.getString("type"));
        this.setTrainerId(Long.parseLong(rs.getString("trainer_id")));
    }
    public void populateForUser(ResultSet rs) throws SQLException {
        this.setName(rs.getString("name"));
        this.setTiming(rs.getString("timing"));
        this.setType(rs.getString("type"));
        this.setTrainerName(rs.getString("t.name"));

    }
}
