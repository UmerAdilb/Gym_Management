package services;

import domain.Member;
import domain.Payment;
import repository.MemberRepository;
import repository.PaymentRepository;

import java.util.List;

public class PaymentService {
    public static String[][] getAllPaymentsForJTable(int length, String month, String year, String memID) {
        PaymentRepository paymentRepository = new PaymentRepository();
        List<Payment> payments = paymentRepository.getAllPayments(month,year,memID);
        String[][] data  = new String[payments.size()][length];
        for(int row = 0 ; row < payments.size() ; row++){
            data[row][0] = payments.get(row).getId().toString();
            data[row][1] = payments.get(row).getBasic_fees().toString();
            data[row][2] = payments.get(row).getFees_paid().toString();
            data[row][3] = payments.get(row).getFees_remaining().toString();
            data[row][4] = payments.get(row).getFees_status();
            data[row][5] = payments.get(row).getDate();
            data[row][6] = payments.get(row).getMonth();
            data[row][7] = payments.get(row).getYear();
            data[row][8] = payments.get(row).getMember_id().toString();
        }
        return data;
    }

    public static Boolean addPayment(Double basicFees, Double feesPaid, Double feesRemaining, String feesStatus, String date, String month, String year, Long memberId) {
   PaymentRepository paymentRepository = new PaymentRepository();
   Boolean addpay = paymentRepository.AddPaymentinDB(basicFees,feesPaid,feesRemaining,feesStatus,date,month,year,memberId);
   if (addpay){return true;}else {
       return false;
   }
    }


    public static Payment ShowPaymentOfSpecificMember( String date, String month, String year, Long memberId) {
        PaymentRepository paymentRepository = new PaymentRepository();
        Payment pay = paymentRepository.getspecificPayments(date,month,year,memberId);
        return pay;
    }

    public static Payment checkPaymentbyId(Long id) {
        PaymentRepository paymentRepository = new PaymentRepository();
        Payment payment = paymentRepository.getPaymentbyId(id);
        return payment;
    }

    public static Boolean updatePayment(Long id,Double basicFees, Double feesPaid, Double feesRemaining, String feesStatus, String date, String month, String year, Long memberId) {
        PaymentRepository paymentRepository = new PaymentRepository();
        Boolean update = paymentRepository.updatePaymentId(id,basicFees,feesPaid,feesRemaining,feesStatus,date,month,year,memberId);
        return update;
    }



    public static Payment getPaymentbycontact(String contact, String month, String year) {
        PaymentRepository paymentRepository = new PaymentRepository();
       Payment pay = paymentRepository.checkPayentthroughContactMonthYr(contact,month,year);
      return pay;
    }
}
