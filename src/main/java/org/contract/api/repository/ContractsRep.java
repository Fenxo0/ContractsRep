package org.contract.api.repository;

import org.contract.api.util.di.Autowired;
import org.contract.api.model.Contract;
import org.contract.api.sortings.ISorter;

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
    /**array contracts*/
    private Contract[] contracts = new Contract[n];
    /**interface sorter*/
    @Autowired
    private ISorter sorter;

    public ContractsRep() {
    }

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

    /**This method sorts by comparator
     *
     * @param comparator fields
     */
    public void sort(Comparator<Contract> comparator){
        sorter.sort(comparator, count, contracts);
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

    @Override
    public String toString() {
        return "ContractsRep{" +
                "contracts=" + Arrays.toString(contracts) +
                '}';
    }
}