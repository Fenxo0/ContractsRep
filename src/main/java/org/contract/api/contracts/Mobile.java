package org.contract.api.contracts;

import org.contract.api.Client;

import java.time.LocalDate;

/**
 * @author Maxim Suhochev
 */
public class Mobile extends Contract {
    private static Mobile.Builder builder;
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
    private Mobile(Client client, String amountInternet, int amountCall, int amountSMS, int id, LocalDate startDate, LocalDate endDate) {
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
        return "\nMobile\n" +
                "client=" + client +
                "amountInternet='" + amountInternet + '\'' +
                ", amountCall=" + amountCall +
                ", amountSMS=" + amountSMS +
                ", id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate + "\n" ;
    }

    /**
     * This method get internet amount
     * @return amountInternet
     */
    public String getAmountInternet() {
        return amountInternet;
    }

    /**
     * This method set internet amount
     */
    public void setAmountInternet(String amountInternet) {
        this.amountInternet = amountInternet;
    }

    /**
     * This method get call amount
     * @return amountCall
     */
    public int getAmountCall() {
        return amountCall;
    }

    /**
     * This method set call amount
     */
    public void setAmountCall(int amountCall) {
        this.amountCall = amountCall;
    }

    /**
     * This method get sms amount
     * @return amountSMS
     */
    public int getAmountSMS() {
        return amountSMS;
    }

    /**
     * This method set sms amount
     */
    public void setAmountSMS(int amountSMS) {
        this.amountSMS = amountSMS;
    }

    /**
     * Mobile builder class*/
    public static class Builder {
        private Client client;
        private int id;
        private  LocalDate startDate;
        private LocalDate endDate;
        private String amountInternet;
        private int amountCall;
        private int amountSMS;

        public Mobile.Builder setClient(Client client) {
            this.client = client;
            return this;
        }

        public Mobile.Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Mobile.Builder setStartDate(LocalDate date) {
            this.startDate = date;
            return this;
        }

        public Mobile.Builder setEndDate(LocalDate date) {
            this.endDate = date;
            return this;
        }

        public Mobile.Builder setAmountInternet(String amountInternet) {
            this.amountInternet = amountInternet;
            return this;
        }

        public Mobile.Builder setAmountCall(int amountCall) {
            this.amountCall = amountCall;
            return this;
        }

        public Mobile.Builder setAmountSMS(int amountSMS) {
            this.amountSMS = amountSMS;
            return this;
        }

        public Mobile build() {
            Mobile.setBuilder(this);
            return new Mobile(client, amountInternet, amountSMS, amountCall, id, startDate, endDate);
        }
    }

    public static Mobile.Builder builder() {
        return new Mobile.Builder();
    }

    private static void setBuilder(Mobile.Builder builder) {
        Mobile.builder = builder;
    }

    public Mobile.Builder toBuilder() {
        return builder;
    }
}
