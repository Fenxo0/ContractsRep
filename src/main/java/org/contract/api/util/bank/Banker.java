package org.contract.api.util.bank;

import java.util.ArrayList;
import java.util.List;

public class Banker extends Thread{

    private Bank bank;

    private static int serviceTime;

    private List<Client> clients = new ArrayList<>();

    public Banker(Bank bank) {
        this.bank = bank;
    }

    public void putCash(Bank bank, Client client) throws InterruptedException {
        sleep(client.getTimeService() * 1000 * 60);
        bank.setCash(bank.getCash() + client.getSum());
        System.out.println("Положили в банк " + client.getSum());
    }

    public void drawCash(Bank bank, Client client) throws InterruptedException {
        if (bank.getCash() - client.getSum() > 0){
            sleep(client.getTimeService() * 1000 * 60);
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
                } else {
                    try {
                        drawCash(bank, client);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(serviceTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Банкир свободен");
        }
    }

    public List<Client> getClients() {
        return clients;
    }

    public void addClient(Client client){
        clients.add(client);
    }
}
