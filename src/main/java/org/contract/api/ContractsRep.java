package org.contract.api;

import org.contract.api.contracts.Contract;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;


/**
 * @author Maxim Suhochev
 */
public class ContractsRep {
    /**
     * array contracts
     */
    private Contract[] contracts = null;

    /**
     * Here is added a new contract
     *
     * @param contract
     */
    public void addContract(Contract contract) {
        if (contracts == null)
            contracts = Stream.of(contract).toArray(Contract[]::new);
        else {
            contracts = Stream.concat(Stream.of(contract), Arrays.stream(contracts))
                    .toArray(Contract[]::new);
        }
    }

    /**
     * Here is the search a contract
     *
     * @param id contract
     * @return contract info or error
     */
    public Contract getContractById(int id) {
        return Arrays.stream(contracts)
                .filter(Objects::nonNull)
                .filter(x -> x.getId() == id)
                .findFirst()
                .get();
    }


    /**
     * The contract is delete here
     *
     * @param id contact
     */
    public void deleteContract(int id) {
        contracts = Arrays.stream(contracts)
                .filter(x -> x.getId() != id)
                .toArray(Contract[]::new);
    }
}
