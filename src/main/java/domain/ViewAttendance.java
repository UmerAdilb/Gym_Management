package domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ViewAttendance {
    private String member_id;
    private String day;
    private String month;
    private  String year;
    private String present;

}
