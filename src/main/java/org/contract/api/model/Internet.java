package org.contract.api.model;

import java.time.LocalDate;

/**
 * @author Maxim Suhochev
 */
public class Internet extends Contract {
    private int maxSpeed;
    private static Internet.Builder builder;


    /**
     * Internet contract constructor
     * @param client
     * @param maxSpeed
     * @param id
     * @param startDate
     * @param endDate
     */
    private Internet(Client client, int maxSpeed, int id, LocalDate startDate, LocalDate endDate) {
        this.client = client;
        this.maxSpeed = maxSpeed;
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "\nInternet\n" +
                "client=" + client +
                "maxSpeed='" + maxSpeed + "Mb" + '\'' +
                ", id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate + "\n";
    }

    /**
     * This method get max speed
     * @return maxSpeed
     */
    public int getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * This method set max speed
     */
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    /**
     * Internet builder class*/
    public static class Builder {
        private Client client;
        private int id;
        private  LocalDate startDate;
        private LocalDate endDate;
        private int maxSpeed;

        public Builder setClient(Client client) {
            this.client = client;
            return this;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setStartDate(LocalDate date) {
            this.startDate = date;
            return this;
        }

        public Builder setEndDate(LocalDate date) {
            this.endDate = date;
            return this;
        }

        public Builder setMaxSpeed(int speed) {
            this.maxSpeed = speed;
            return this;
        }

        public Internet build() {
            Internet.setBuilder(this);
            return new Internet(client, maxSpeed, id, startDate, endDate);
        }
    }

    public static Internet.Builder builder() {
        return new Internet.Builder();
    }

    private static void setBuilder(Internet.Builder builder) {
        Internet.builder = builder;
    }

    public Builder toBuilder() {
        return builder;
    }
}