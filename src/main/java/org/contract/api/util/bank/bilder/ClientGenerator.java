package org.contract.api.util.bank.bilder;

import org.contract.api.util.bank.Banker;
import org.contract.api.util.bank.Client;
import org.contract.api.util.bank.TypeOfOperation;

import java.util.List;
import java.util.Random;

/**
 * @author Maxim Suhochev
 */

/**Class for generate clients and add in queue*/
public class ClientGenerator extends Thread {

    private List<Banker> bankers;

    private final static int CLIENTS_PER_MINUTE = 15;

    private Random rnd = new Random();

    public ClientGenerator(List<Banker> bankers) {
        this.bankers = bankers;
    }

    /**
     * Put client in queue
     * @param client
     */
    public void createQueue(Client client){
        Banker firstBanker = bankers.get(0);
        for (Banker banker : bankers){
            if (banker.getClients().size() > firstBanker.getClients().size()){
                firstBanker = banker;
            }
        }
        firstBanker.addClient(client);
    }

    @Override
    public void run() {
        while (true){
            for (int i = 0; i < CLIENTS_PER_MINUTE; i++) {
                Client client = generateClient(generateType());
                createQueue(client);
            }
            System.out.println("Ждём новыйх клиентов");
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Generate type clients operation
     * @return type
     */
    public TypeOfOperation generateType(){
        int type = rnd.nextInt(3);
        switch (type){
            case 1:
                return TypeOfOperation.PUT;
            case 2:
                return TypeOfOperation.WITHDRAW;
        }
        return TypeOfOperation.PUT;
    }

    /**
     * Clients generator
     * @param type operation
     * @return client
     */
    public Client generateClient(TypeOfOperation type){
        Client client = new Client();
        client.setSum(rnd.nextInt(1000) + 1000);
        client.setType(type);
        System.out.println("Новый клиент");
        return client;
    }
}
