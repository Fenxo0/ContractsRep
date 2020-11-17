package org.contract.api;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import org.contract.api.comparators.IdComparator;
import org.contract.api.contracts.Contract;
import org.contract.api.contracts.Internet;
import org.contract.api.contracts.Mobile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.contract.api.ContractsPredicates.*;

/**
 * @author Maxim Suhochev
 */
public class Main {

    private static Mobile mobile;
    private static Client client;
    /**
     * This method is executive
     * @param args - command line
     */
    public static void main(String[] args) throws IOException, CsvException {
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
        contractsRep.bubbleSort(new IdComparator());
        LoaderCsv loaderCsv = new LoaderCsv();
        loaderCsv.parsingFile(contractsRep);
        System.out.println(contractsRep);
    }
}
