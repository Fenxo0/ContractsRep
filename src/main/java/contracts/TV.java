package contracts;

import java.time.LocalDate;

/**
 * @author Maxim Suhochev
 */
public class TV extends Contract {

    private static TV.Builder builder;
    /** package TV*/
    private String packageTV;

    /**
     * TV contact constructor
     * @param client
     * @param packageTV
     * @param id
     * @param startDate
     * @param endDate
     */
    private TV(Client client, int id, LocalDate startDate, LocalDate endDate, String packageTV) {
        this.client = client;
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.packageTV = packageTV;
    }


    @Override
    public String toString() {
        return "TV\n" +
                "client=" + client +
                "packageTV='" + packageTV + '\'' +
                ", id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate;
    }

    /**
     * This method get package TV
     * @return packageTV
     */
    public String getPackageTV() {
        return packageTV;
    }

    /**
     * This method set package TV
     */
    public void setPackageTV(String packageTV) {
        this.packageTV = packageTV;
    }

    /**
     * TV builder class*/
    public static class Builder {
        private Client client;
        private int id;
        private  LocalDate startDate;
        private LocalDate endDate;
        private String packageTV;

        public TV.Builder setClient(Client client) {
            this.client = client;
            return this;
        }

        public TV.Builder setId(int id) {
            this.id = id;
            return this;
        }

        public TV.Builder setStartDate(LocalDate date) {
            this.startDate = date;
            return this;
        }

        public TV.Builder setEndDate(LocalDate date) {
            this.endDate = date;
            return this;
        }

        public TV.Builder packageTV(String packageTV) {
            this.packageTV = packageTV;
            return this;
        }

        public TV build() {
            TV.setBuilder(this);
            return new TV(client, id, startDate, endDate, packageTV);
        }
    }

    public static TV.Builder builder() {
        return new TV.Builder();
    }

    private static void setBuilder(TV.Builder builder) {
        TV.builder = builder;
    }

    public TV.Builder toBuilder() {
        return builder;
    }
}
