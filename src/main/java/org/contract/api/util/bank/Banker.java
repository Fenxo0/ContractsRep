package org.contract.api.util.bank;

public class Banker extends Thread{

    public void putCash(Bank bank, Client client){
        bank.setCash(bank.getCash() + client.getSum());
        System.out.println("Положили в банк " + client.getSum());
    }

    public void drawCash(Bank bank, Client client){
        if (bank.getCash() - client.getSum() > 0){
            bank.setCash(bank.getCash() - client.getSum());
            System.out.println("Произошло снятие о счета " + client.getSum());
        }
        else
            System.out.println("Недостаточно средств в кассе!");
    }

    @Override
    public void run() {
        super.run();
    }
}
