package contacts;

import java.time.LocalDate;

/**
 * @author Maxim Suhochev
 */
public class TV extends Contract {

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
    public TV(Client client, int id, LocalDate startDate, LocalDate endDate, String packageTV) {
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

}
