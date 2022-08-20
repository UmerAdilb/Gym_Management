package domain;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private Long id;
    private String name;
    private String gender;
    private Integer age;
    private String contact;
    private String address;
    private String status = "ACTIVE";
    private Long groupId;

}
