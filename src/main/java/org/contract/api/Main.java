package org.contract.api;

import org.contract.api.comparators.IdComparator;
import org.contract.api.contracts.Mobile;

import java.time.LocalDate;

import static org.contract.api.ContractsPredicates.*;

/**
 * @author Maxim Suhochev
 */
public class Main {

    /**
     * This method is executive
     * @param args - command line
     */
    public static void main(String[] args) {
        ContractsRep contractsRep = new ContractsRep();
        Client client = new Client.Builder()
                .setId(1)
                .setBirthDate(LocalDate.of(2000, 8, 23))
                .setSNP("Сухочев Максим Юрьевич")
                .setSex("M")
                .setNumPas(2014)
                .setSerPas(234234)
                .build();
        Mobile mobile = new Mobile.Builder()
                .setId(1)
                .setClient(client)
                .setStartDate(LocalDate.of(2010, 8, 23))
                .setEndDate(LocalDate.of(2020, 8, 23))
                .setAmountInternet("100gb")
                .setAmountSMS(100)
                .setAmountCall(34)
                .build();
        Mobile mobile1 = new Mobile.Builder()
                .setId(10)
                .setClient(client)
                .setStartDate(LocalDate.of(2011, 8, 23))
                .setEndDate(LocalDate.of(2020, 8, 23))
                .setAmountInternet("100gb")
                .setAmountSMS(100)
                .setAmountCall(34)
                .build();
        Mobile mobile2 = new Mobile.Builder()
                .setId(7)
                .setClient(client)
                .setStartDate(LocalDate.of(2007, 8, 23))
                .setEndDate(LocalDate.of(2020, 8, 23))
                .setAmountInternet("100gb")
                .setAmountSMS(100)
                .setAmountCall(34)
                .build();
        contractsRep.addContract(mobile);
        contractsRep.addContract(mobile1);
        contractsRep.addContract(mobile2);
        contractsRep.bubbleSort(new IdComparator());
        System.out.println(contractsRep.getContract(isIdClient(1)));
    }
}
