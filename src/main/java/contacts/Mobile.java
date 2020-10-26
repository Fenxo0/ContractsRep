package contacts;

import java.time.LocalDate;

/**
 * @author Maxim Suhochev
 */
public class Mobile extends Contract {
    /** amount internet in this contract*/
    private String amountInternet;
    /** amount call in this contract*/
    private int amountCall;
    /** amount sms in this contract*/
    private int amountSMS;

    /**
     * Mobile contract constructor
     * @param client
     * @param amountInternet
     * @param amountCall
     * @param amountSMS
     * @param id
     * @param startDate
     * @param endDate
     */
    public Mobile(Client client, String amountInternet, int amountCall, int amountSMS, int id, LocalDate startDate, LocalDate endDate) {
        this.client = client;
        this.amountInternet = amountInternet;
        this.amountCall = amountCall;
        this.amountSMS = amountSMS;
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Mobile\n" +
                "client=" + client +
                "amountInternet='" + amountInternet + '\'' +
                ", amountCall=" + amountCall +
                ", amountSMS=" + amountSMS +
                ", id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate ;
    }
}
