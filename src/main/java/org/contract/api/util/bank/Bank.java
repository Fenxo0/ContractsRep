package org.contract.api.util.bank;

/**
 * @author Maxim Suhochev
 */
public class Bank {

    private int cash;

    public Bank(int cash) {
        this.cash = cash;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
}
