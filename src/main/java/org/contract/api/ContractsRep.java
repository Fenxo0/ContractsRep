package org.contract.api;

import org.contract.api.contracts.Contract;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * @author Maxim Suhochev
 */
public class ContractsRep {
    /**arrays size*/
    private int n = 15;
    /**count*/
    private int count = 0;
    /**
     * array contracts
     */
    private Contract[] contracts = new Contract[n];

    /**
     * Here is added a new contract
     *
     * @param contract
     */
    public void addContract(Contract contract) {
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
     *
     * @param predicate contract
     * @return list contracts
     */
    public List<Contract> getContract(Predicate<Contract> predicate) {
        return Arrays.stream(contracts)
                .filter(Objects::nonNull)
                .filter(predicate)
                .collect(Collectors.<Contract>toList());
    }

    /**
     * This method sorts bubble sorting by comparator
     */
    public void bubbleSort(Comparator<Contract> comparator){
        for(int j = count-1; j >= 1; j--){
            for (int i = 0; i < j; i++) {
                if(comparator.compare(contracts[i], contracts[i+1]) == 1) {
                    toSwap(i, i+1);
                }
            }
        }

    }

    /**
     * This method sorts insertion sorting by comparator
     */
    public void insertionSort(Comparator<Contract> comparator){
        for (int i = 1; i <= count; i++) {
            Contract current = contracts[i];
            int j = i - 1;
            while(j >= 0 && comparator.compare(contracts[j], current) == 1) {
                contracts[j + 1] = contracts[j];
                j--;
            }
            contracts[j+1] = current;
        }
    }

    /**
     * The contract is delete here
     *
     * @param id contact
     */
    public void deleteContract(int id) {
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

    /**
     * Here contracts are reversed
     * @param first number contract
     * @param second number contract
     */
    private void toSwap(int first, int second){
        Contract temp = contracts[first];
        contracts[first] = contracts[second];
        contracts[second] = temp;
    }

    @Override
    public String toString() {
        return "ContractsRep{" +
                "contracts=" + Arrays.toString(contracts) +
                '}';
    }
}