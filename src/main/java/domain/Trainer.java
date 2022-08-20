package domain;

import lombok.*;

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


}
