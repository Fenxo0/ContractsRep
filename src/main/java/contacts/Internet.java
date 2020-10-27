package contacts;

import java.time.LocalDate;

/**
 * @author Maxim Suhochev
 */
public class Internet extends Contract {
    private String maxSpeed;


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

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
