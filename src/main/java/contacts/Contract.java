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
    public int getId(){
        return id;
    }
}
