package services;

import domain.ReportAnalytics;
import repository.ReportAnalyticsRepository;

public class ReportAnalyticService {

    public static ReportAnalytics reportData(){
        ReportAnalyticsRepository reportAnalyticrepo = new ReportAnalyticsRepository();
        Long totalMember = reportAnalyticrepo.gettotalMember();
        Double totalFee = reportAnalyticrepo.gettotalfees();
        Double paidFee = reportAnalyticrepo.getCollectedfees();
        Double feeRemain = reportAnalyticrepo.getRemainingfees();
        Long newMember = reportAnalyticrepo.getnewmembers();
        Long membersLeft = reportAnalyticrepo.getInactiveMember();
        Long membersActive = reportAnalyticrepo.getActiveMember();

        ReportAnalytics data = new ReportAnalytics(totalMember,paidFee,feeRemain,totalFee,newMember,membersLeft,membersActive);

        return  data;

    }
}
