package contacts;

import java.time.LocalDate;

/**
 * @author Maxim Suhochev
 */
public class Contract {

    /** client*/
    protected Client client;
    /** id contract*/
    protected int id;
    /** start contract*/
    protected LocalDate startDate;
    /** start contract*/
    protected LocalDate endDate;


    /**
     * This method get id contract
     * @return id
     */
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
