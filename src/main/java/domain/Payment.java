package domain;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter

public class Payment {
    private Long id;
    private Double basic_fees;
    private Double fees_paid;
    private Double fees_remaining;
    private String fees_status;
    private String date;
    private String month;
    private String year;
    private Long member_id;

    public void populate(ResultSet rs) throws SQLException {
        this.setId(Long.parseLong(rs.getString("id")));
        this.setBasic_fees(Double.parseDouble(rs.getString("basic_fees")));
        this.setFees_paid(Double.parseDouble(rs.getString("fees_paid")));
        this.setFees_remaining(Double.parseDouble(rs.getString("fees_remaining")));
        this.setFees_status(rs.getString("fees_status"));
        this.setDate(rs.getString("date"));
        this.setMonth(rs.getString("month"));
        this.setYear(rs.getString("year"));
        this.setMember_id(Long.parseLong(rs.getString("member_id")));

    }
}
