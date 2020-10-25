import contacts.Client;
import contacts.Internet;

import java.time.LocalDate;

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
        Client client = new Client(1, "Сухочев Максим Юрьевич", LocalDate.of(2000, 8, 24), "Мужской", 2014, 7800311);
        Internet internet = new Internet(client, "100 MB", 1, LocalDate.of(2018, 8, 24),LocalDate.of(2020, 8, 24));
        Internet internet1 = new Internet(client, "100 MB", 11, LocalDate.of(2018, 8, 24),LocalDate.of(2020, 8, 24));
        Internet internet2 = new Internet(client, "100 MB", 11, LocalDate.of(2018, 8, 24),LocalDate.of(2020, 8, 24));
        Internet internet3 = new Internet(client, "100 MB", 11, LocalDate.of(2018, 8, 24),LocalDate.of(2020, 8, 24));
        Internet internet4 = new Internet(client, "100 MB", 11, LocalDate.of(2018, 8, 24),LocalDate.of(2020, 8, 24));
        Internet internet5 = new Internet(client, "100 MB", 11, LocalDate.of(2018, 8, 24),LocalDate.of(2020, 8, 24));
        contractsRep.addCon(internet);
        contractsRep.addCon(internet1);
        contractsRep.addCon(internet2);
        contractsRep.addCon(internet3);
        contractsRep.addCon(internet4);
        contractsRep.addCon(internet5);
        contractsRep.deleteCom(1);
        System.out.println(contractsRep.getCon(1));
        System.out.println(contractsRep.getCon(11));
    }
}
