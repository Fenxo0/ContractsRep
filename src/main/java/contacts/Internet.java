package contacts;

import java.time.LocalDate;

/**
 * @author Maxim Suhochev
 */
public class Internet implements Contract {
    private final Client client;
    private final String maxSpeed;
    private final int id;
    /** start internet contract*/
    private LocalDate startDate;
    /** start internet contract*/
    private LocalDate endDate;

    /**
     * Internet contract constructor
     * @param client
     * @param maxSpeed
     * @param id
     * @param startDate
     * @param endDate
     */
    public Internet(Client client, String maxSpeed, int id, LocalDate startDate, LocalDate endDate) {
        this.client = client;
        this.maxSpeed = maxSpeed;
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Internet\n" +
                "client=" + client +
                "maxSpeed='" + maxSpeed + '\'' +
                ", id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate ;
    }

    @Override
    public int getId() {
        return id;
    }
}
