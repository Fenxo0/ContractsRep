import org.contract.api.Client;
import org.contract.api.contracts.Contract;
import org.contract.api.ContractsRep;
import org.contract.api.contracts.Mobile;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

import static org.junit.Assert.assertNotNull;

class ContractsRepTest {

    @Test
    void addCon() {
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
        contractsRep.addContract(mobile);
        Contract[] contracts = new Contract[15];
        contracts[0] = mobile;
        Assert.assertEquals(contracts[0], contractsRep.getContractById(1));
    }

    @Test
    void getCon() {
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
        contractsRep.addContract(mobile);
        assertNotNull(contractsRep.getContractById(1));
    }

    @Test
    void deleteCom() {
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
                .setId(2)
                .setClient(client)
                .setStartDate(LocalDate.of(2010, 8, 23))
                .setEndDate(LocalDate.of(2020, 8, 23))
                .setAmountInternet("100gb")
                .setAmountSMS(100)
                .setAmountCall(34)
                .build();
        contractsRep.addContract(mobile);
        contractsRep.addContract(mobile1);
        contractsRep.deleteContract(1);
    }

    @Test
    void getId(){
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
        Assert.assertEquals(mobile.getId(), 1);
    }

    @Test
    void getAge(){
        Client client = new Client.Builder()
                .setId(1)
                .setBirthDate(LocalDate.of(2000, 8, 23))
                .setSNP("Сухочев Максим Юрьевич")
                .setSex("M")
                .setNumPas(2014)
                .setSerPas(234234)
                .build();
        Assert.assertEquals((Period.between(LocalDate.of(2000, 8, 24), LocalDate.now()).getYears()),
                client.getAge(LocalDate.of(2000, 8, 24)));
    }
}