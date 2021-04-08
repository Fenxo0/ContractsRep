package org.contract.api.util.bilder;

import org.contract.api.util.bank.Client;
import org.contract.api.util.bank.TypeOfOperation;

import java.util.Random;

public class ClientGenerator {

    public Client generateClient(){
        Random rnd = new Random();
        Client client = new Client();
        client.setSum(rnd.nextInt(10000) + 1000);
        client.setTimeService(rnd.nextInt(5));
        int type = rnd.nextInt(2);
        if (type == 1)
            client.setType(TypeOfOperation.PUT);
        else
            client.setType(TypeOfOperation.WITHDRAW);
        System.out.println("Новый клиент");
        return client;
    }
}
