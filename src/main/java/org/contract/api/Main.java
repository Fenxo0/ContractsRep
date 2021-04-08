package org.contract.api;

import org.contract.api.comparators.IdComparator;
import org.contract.api.model.Mobile;
import org.contract.api.model.Client;
import org.contract.api.repository.ContractsRep;
import org.contract.api.util.bank.Bank;
import org.contract.api.util.bank.Banker;
import org.contract.api.util.bank.bilder.BankerGenerator;
import org.contract.api.util.bank.bilder.ClientGenerator;
import org.contract.api.util.di.AutoInject;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Maxim Suhochev
 */
public class Main {

    private final static int N = 5;

    private final static int SERVICE_TIME = 9000;

    private final static int CLIENTS_PER_MINUTE = 3;

    /**
     * This method is executive
     * @param args - command line
     */
    public static void main(String[] args)  {
        System.out.println("Начинаем работу банка");
        Bank bank = new Bank(10000);
        List<Banker> bankers = BankerGenerator.generateBanker(bank);
        ClientGenerator clientGenerator = new ClientGenerator(bankers);
        clientGenerator.start();
    }

}
