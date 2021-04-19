package org.contract.api.model;

import org.contract.api.model.Client;

import javax.xml.bind.annotation.XmlElement;
import java.time.LocalDate;

/**
 * @author Maxim Suhochev
 */
public abstract class Contract {

    /** client*/
    protected Client client;
    /** id contract*/
    protected int id;
    /** start contract*/
    protected LocalDate startDate;
    /** start contract*/
    protected LocalDate endDate;

    /**
     * This method get Client
     * @return client
     */
    public Client getClient() {
        return client;
    }

    /**
     * This method set Client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * This method get id contract
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * This method set id contract
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This method get start date
     * @return startDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * This method set start date
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * This method get end date
     * @return endDate
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * This method set end date
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;}


}
