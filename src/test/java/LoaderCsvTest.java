import com.opencsv.exceptions.CsvException;
import org.contract.api.csv.LoaderCsv;
import org.contract.api.repository.ContractsRep;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.junit.Assert.*;

/**
 * @author Maxim Suhochev
 */
public class LoaderCsvTest {

    ContractsRep contractsRep = new ContractsRep();
    LoaderCsv loaderCsv = new LoaderCsv();

    @Test
    void loadCsvFile() throws IOException, CsvException {
        loaderCsv.parsingFile(contractsRep);
        System.out.println(contractsRep);
        assertNotNull(contractsRep);
    }
}
