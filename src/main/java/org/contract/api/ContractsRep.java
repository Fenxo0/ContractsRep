package org.contract.api;

import org.contract.api.contracts.Contract;

import java.util.Arrays;


/**
 * @author Maxim Suhochev
 */
public class ContractsRep {

    /**arrays size*/
    private int n = 15;
    /**count*/
    private int count = 0;
    /**array contracts*/
    private Contract[] contracts = new Contract[n];

    /**
     *Here is added a new contract
     * @param contract
     */
    public void addContract(Contract contract){
        if (contracts.length <= count - 1) {
            contracts = (Contract[]) arrayCopy(contracts);
            contracts[count] = contract;
        } else {
            contracts[count] = contract;
        }
        count++;
    }

    /**
     * Here is the search a contract
     * @param id contract
     * @return contract info or error
     */
    public Contract getContractById(int id){
        Contract contract = null;
        for (int i = 0; i < count; i++) {
            if (id == contracts[i].getId()) {
                contract = contracts[i];
                break;
            }
        }
        return contract;
    }


    /**
     * The contract is delete here
     * @param id contact
     */
    public void deleteContract(int id){
        int i;
        for (i = 0; i < contracts.length; i++) {
            if(id == contracts[i].getId()){
                break;
            }
        }
        for(int j = i; j < contracts.length-1; j++){
            contracts[j] = contracts[j+1];
        }
        count--;
    }

    /**
     * This method copy old array in new array
     * @param con - array contact
     * @return new array
     */
    private Object[] arrayCopy(Contract[] con){
        return Arrays.copyOf(con, con.length + 10);
    }
}