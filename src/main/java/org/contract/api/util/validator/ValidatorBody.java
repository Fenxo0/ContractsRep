package org.contract.api.util.validator;

/**
 * This class saves validator's status and comment
 * @author Maxim Suhochev
 */
public class ValidatorBody {

    /**Status validator*/
    private Status status;
    /**comment validator*/
    private String comment;

    public ValidatorBody(Status status) {
        this.status = status;
    }

    public ValidatorBody(Status status, String comment) {
        this.status = status;
        this.comment = comment;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "ValidatorBody{" +
                "status='" + status + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
