import contacts.Client;
import contacts.Contract;
import contacts.Internet;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

class ContractsRepTest {

    @Test
    void addCon() {
        ContractsRep contractsRep = new ContractsRep();
        Client client = new Client(1, "Сухочев Максим Юрьевич", LocalDate.of(2000, 8, 24), "Мужской", 2014, 7800311);
        Internet internet = new Internet(client, "100 MB", 1, LocalDate.of(2018, 8, 24),LocalDate.of(2020, 8, 24));
        contractsRep.addCon(internet);
        Contract[] contracts = new Contract[15];
        contracts[0] = internet;
        Assert.assertEquals(contracts[0], contractsRep.getCon(1));
    }

    @Test
    void getCon() {
        ContractsRep contractsRep = new ContractsRep();
        Client client = new Client(1, "Сухочев Максим Юрьевич", LocalDate.of(2000, 8, 24), "Мужской", 2014, 7800311);
        Internet internet = new Internet(client, "100 MB", 1, LocalDate.of(2018, 8, 24),LocalDate.of(2020, 8, 24));
        contractsRep.addCon(internet);
        Assert.assertNotNull(contractsRep.getCon(1));
    }

    @Test
    void deleteCom() {
        ContractsRep contractsRep = new ContractsRep();
        Client client = new Client(1, "Сухочев Максим Юрьевич", LocalDate.of(2000, 8, 24), "Мужской", 2014, 7800311);
        Internet internet = new Internet(client, "100 MB", 1, LocalDate.of(2018, 8, 24),LocalDate.of(2020, 8, 24));
        Internet internet1 = new Internet(client, "100 MB", 11, LocalDate.of(2018, 8, 24),LocalDate.of(2020, 8, 24));
        contractsRep.addCon(internet);
        contractsRep.addCon(internet1);
        contractsRep.deleteCom(1);
        Assert.assertEquals(contractsRep.getCon(1), 0);
    }

    @Test
    void getId(){
        Client client = new Client(1, "Сухочев Максим Юрьевич", LocalDate.of(2000, 8, 24), "Мужской", 2014, 7800311);
        Internet internet = new Internet(client, "100 MB", 1, LocalDate.of(2018, 8, 24),LocalDate.of(2020, 8, 24));
        Assert.assertEquals(internet.getId(), 1);
    }

    @Test
    void getAge(){
        Client client = new Client(1, "Сухочев Максим Юрьевич", LocalDate.of(2000, 8, 24), "Мужской", 2014, 7800311);
        Assert.assertEquals((Period.between(LocalDate.of(2000, 8, 24), LocalDate.now()).getYears()),
                client.getAge(LocalDate.of(2000, 8, 24)));
    }
}