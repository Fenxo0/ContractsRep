package contacts;

import java.time.LocalDate;

/**
 * @author Maxim Suhochev
 */
public class TV implements Contract {

    /** Client*/
    private Client client;
    /** package TV*/
    private String packageTV;
    /** id contract TV*/
    private int id;
    /** start TV contract*/
    private LocalDate startDate;
    /** start TV contract*/
    private LocalDate endDate;

    /**
     * TV contact constructor
     * @param client
     * @param packageTV
     * @param id
     * @param startDate
     * @param endDate
     */
    public TV(Client client, String packageTV, int id, LocalDate startDate, LocalDate endDate) {
        this.client = client;
        this.packageTV = packageTV;
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
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

    @Override
    public int getId() {
        return id;
    }
}
