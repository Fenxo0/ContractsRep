package org.contract.api.util.bank;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxim Suhochev
 */
public class Banker extends Thread{

    private static Bank bank;

    private static int serviceTime;

    private List<Client> clients = new ArrayList<>();

    /**
     * Put cash in the bank
     * @param bank
     * @param client
     * @throws InterruptedException
     */
    synchronized public void putCash(Bank bank, Client client) throws InterruptedException {
        bank.setCash(bank.getCash() + client.getSum());
        System.out.println("Касса банка " + bank.getCash());
    }

    /**
     * Draw money from the bank
     * @param bank
     * @param client
     * @throws InterruptedException
     */
    synchronized public void drawCash(Bank bank, Client client) throws InterruptedException {
        if (bank.getCash() - client.getSum() > 0){
            bank.setCash(bank.getCash() - client.getSum());
            System.out.println("Произошло снятие о счета " + client.getSum());
        }
        else
            System.out.println("Недостаточно средств в кассе!");
    }

    @Override
    public void run() {
        while (true) {
            while (!clients.isEmpty()) {
                Client client = clients.get(0);
                System.out.println("Операция клиента " + client.getType());
                if (client.getType() == TypeOfOperation.PUT) {
                    try {
                        putCash(bank, client);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if (client.getType() == TypeOfOperation.WITHDRAW) {
                    try {
                        drawCash(bank, client);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else
                    System.out.println("Не можем помочь");
                try {
                    Thread.sleep(serviceTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Банкир свободен");
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Client> getClients() {
        return clients;
    }

    public void addClient(Client client){
        clients.add(client);
    }

    public Bank getBank() {
        return bank;
    }

    public static void setBank(Bank bank) {
        Banker.bank = bank;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public static void setServiceTime(int serviceTime) {
        Banker.serviceTime = serviceTime;
    }
}
