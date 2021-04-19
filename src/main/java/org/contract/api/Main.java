package org.contract.api;

import org.contract.api.comparators.IdComparator;
import org.contract.api.model.Internet;
import org.contract.api.model.Mobile;
import org.contract.api.model.Client;
import org.contract.api.repository.ContractsRep;
import org.contract.api.util.di.AutoInject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.StringWriter;
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
        AutoInject.inject(contractsRep);
        contractsRep.sort(new IdComparator());
        /*LoaderCsv loaderCsv = new LoaderCsv();
        loaderCsv.parsingFile(contractsRep);*/
        JAXBContext context = JAXBContext.newInstance(Client.class);

        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        m.marshal(client, System.out);

        File outFile = new File("client.xml");
        m.marshal(client, outFile);

        System.err.println("Write to file: " + outFile.getAbsolutePath());
        System.out.println(contractsRep);
    }

}
