package org.contract.api.util.bank;

/**
 * @author Maxim Suhochev
 */
public class Client {

    private TypeOfOperation type;

    private int sum;

    public TypeOfOperation getType() {
        return type;
    }

    public void setType(TypeOfOperation type) {
        this.type = type;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
