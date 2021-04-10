package org.contract.api;

import org.contract.api.comparators.IdComparator;
import org.contract.api.model.Mobile;
import org.contract.api.model.Client;
import org.contract.api.repository.ContractsRep;
import org.contract.api.util.di.AutoInject;
import org.contract.api.util.jdbc.JdbcUtil;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Maxim Suhochev
 */
public class Main {

    /**
     * This method is executive
     * @param args - command line
     */
    public static void main(String[] args) throws Exception {
        ContractsRep contractsRep = new ContractsRep();
        Client client = new Client.Builder()
                .setBirthDate(LocalDate.of(2000, 8, 23))
                .setSNP("Сухочев Максим Юрьевич")
                .setSex("M")
                .setNumPas(2014)
                .setSerPas(234234)
                .build();
        Mobile mobile = new Mobile.Builder()
                .setId(1)
                .setStartDate(LocalDate.of(2010, 8, 23))
                .setEndDate(LocalDate.of(2020, 8, 23))
                .setClient(client)
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
        AutoInject.inject(contractsRep);
        contractsRep.sort(new IdComparator());
        client.setBirthDate(LocalDate.now());
        JdbcUtil jdbcUtil = new JdbcUtil();
        List<Mobile> mobiles = jdbcUtil.selectMobiles();
        for (Mobile mobile3 : mobiles)
            System.out.println(mobile3);
    }

}
