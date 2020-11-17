package org.contract.api;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.contract.api.contracts.Internet;
import org.contract.api.contracts.Mobile;
import org.contract.api.contracts.TV;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * Parsing csv file
 * @author Maxim Suhochev
 */
public class LoaderCsv {
    /**csv file*/
    private final String CSVFILE = "./src/main/resources/InfoContracts.csv";
    /**mobile contract*/
    private Mobile mobile;
    /**internet contract*/
    private Internet internet;
    /**tv contract*/
    private TV tv;
    /**client*/
    private Client client;

    public void parsingFile(ContractsRep contractsRep) throws IOException, CsvException {
        int index = 0;
        FileReader filereader = new FileReader(CSVFILE);
        CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
        CSVReader csvReader = new CSVReaderBuilder(filereader)
                .withCSVParser(parser)
                .build();
        List<String[]> allData = csvReader.readAll();
        for (String[] row : allData) {
            for (String cell : row) {
                if(index == 0){
                    client = parsClient(row, index);
                    index++;
                }
                if ("mobile".equals(cell)) {
                    mobile = parsMobile(row, 0, client);
                    contractsRep.addContract(mobile);
                    break;
                }
                else if ("internet".equals(cell)) {
                    internet = parsInternet(row, 0, client);
                    contractsRep.addContract(internet);
                    break;
                }
                else if ("tv".equals(cell)) {
                    tv = parsTV(row, 0, client);
                    contractsRep.addContract(tv);
                    break;
                }
            }
            index = 0;
        }
    }

    /**
     * Parsing client of csv file
     * @param allData client info
     * @param index data
     * @return client
     */
    private Client parsClient(String[] allData, int index){
        Client client = new Client.Builder().build();
        for(String cell : allData) {
            if (index % 10 == 0) {
                client.setId(Integer.parseInt(cell));
            } else if (index % 10 == 1) {
                client.setSNP(cell);
            } else if (index % 10 == 2) {
                client.setSex(cell);
            } else if (index % 10 == 3) {
                client.setBirthDate(LocalDate.parse(cell));
            } else if (index % 10 == 4) {
                client.setNumPas(Integer.parseInt(cell));
            } else if (index % 10 == 5) {
                client.setSerPas(Integer.parseInt(cell));
                break;
            }
            index++;
        }
        return client;
    }

    /**
     * Parsing mobile contract of csv file
     * @param allData contract info
     * @param index data
     * @return mobile contract
     */
    private Mobile parsMobile(String[] allData, int index, Client client){
        Mobile mobile = new Mobile.Builder().build();
        for (String cell : allData) {
            if (index < 11) {
                if (index % 10 == 7) {
                    mobile.setId(Integer.parseInt(cell));
                }
                else if(index % 10 == 8){
                    mobile.setStartDate(LocalDate.parse(cell));
                }
                else if(index % 10 == 9){
                    mobile.setEndDate((LocalDate.parse(cell)));
                }
                else if(index % 10 == 0 && index != 0){
                    mobile.setClient(client);
                    String delimeter = "-";
                    String[] subStr = cell.split(delimeter);
                    for (int i = 0; i < subStr.length; i++) {
                        if(i == 1)
                            mobile.setAmountCall(Integer.parseInt(subStr[i]));
                        if(i == 2)
                            mobile.setAmountSMS(Integer.parseInt(subStr[i]));
                        else
                            mobile.setAmountInternet(subStr[i]);
                    }
                }
                index++;
            }
        }
        return mobile;
    }

    /**
     * Parsing internet contract of csv file
     * @param allData contract info
     * @param index data
     * @return internet contract
     */
    private Internet parsInternet(String[] allData, int index, Client client){
        Internet internet = new Internet.Builder().build();
        for (String cell : allData) {
            if (index < 11) {
                if (index % 10 == 7) {
                    internet.setId(Integer.parseInt(cell));
                }
                else if(index % 10 == 8){
                    internet.setStartDate(LocalDate.parse(cell));
                }
                else if(index % 10 == 9){
                    internet.setEndDate((LocalDate.parse(cell)));
                }
                else if(index % 10 == 0 && index != 0){
                    internet.setClient(client);
                    internet.setMaxSpeed(Integer.parseInt(cell));
                }
                index++;
            }
        }
        return internet;
    }

    /**
     * Parsing tv contract of csv file
     * @param allData contract info
     * @param index data
     * @return tv contract
     */
    private TV parsTV(String[] allData, int index, Client client){
        TV tv = new TV.Builder().build();
        for (String cell : allData) {
            if (index < 11) {
                if (index % 10 == 7) {
                    tv.setId(Integer.parseInt(cell));
                }
                else if(index % 10 == 8){
                    tv.setStartDate(LocalDate.parse(cell));
                }
                else if(index % 10 == 9){
                    tv.setEndDate((LocalDate.parse(cell)));
                }
                else if(index % 10 == 0 && index != 0){
                    tv.setClient(client);
                    tv.setPackageTV(cell);
                }
                index++;
            }
        }
        return tv;
    }
}
