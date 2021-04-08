package org.contract.api;

import org.contract.api.comparators.IdComparator;
import org.contract.api.model.Mobile;
import org.contract.api.model.Client;
import org.contract.api.repository.ContractsRep;
import org.contract.api.util.bank.Bank;
import org.contract.api.util.di.AutoInject;

import java.time.LocalDate;

/**
 * @author Maxim Suhochev
 */
public class Main {

    /**
     * This method is executive
     * @param args - command line
     */
    public static void main(String[] args) throws Exception {
        while (true){
            Bank bank = new Bank(50000);
        }
    }

}
