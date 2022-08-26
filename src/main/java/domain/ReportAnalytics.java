package domain;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReportAnalytics {
    private Long totalMember;
    private Double feesCollected;
    private Double fessRemaining;
    private Double totalfees;
    private Long newmembers;
    private Long membersLeft;
    private Long activeMembers;
}
