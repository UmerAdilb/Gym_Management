package domain;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Attendance {
    private Long id;
    private String date;
    private String month;
    private String year;
    private Long memberid;

    public Attendance(String date, String month, String year, Long memberid) {
        this.date = date;
        this.month = month;
        this.year = year;
        this.memberid = memberid;
    }

    public void populate(ResultSet rs) throws SQLException{
        this.setId(Long.parseLong(rs.getString("id")));
        this.setDate(rs.getString("date"));
        this.setMonth(rs.getString("month"));
        this.setYear(rs.getString("year"));
        this.setMemberid(Long.parseLong(rs.getString("member_id")));
    }
}
