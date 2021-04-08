package org.contract.api.util.bank;

public class Client {

    private TypeOfOperation type;

    private int sum;

    private long timeService;

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

    public long getTimeService() {
        return timeService;
    }

    public void setTimeService(int timeService) {
        this.timeService = timeService;
    }
}
