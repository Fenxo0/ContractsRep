package org.contract.api;

import org.contract.api.contracts.Contract;

import java.time.LocalDate;
import java.util.function.Predicate;

/**
 * @author Maxim Suhochev
 */
public class ContractsPredicates {

    /***
     *
     * @param id contract
     * @return predicate id
     */
    public static Predicate<Contract> isId(int id){
        return p -> p.getId() == id;
    }

    /**
     *
     * @param id client
     * @return predicate id client
     */
    public static Predicate<Contract> isIdClient(int id){
        return p -> p.getClient().getId() == id;
    }

    /**
     *
     * @param localDate start date contract
     * @return predicate star date
     */
    public static Predicate<Contract> istStartDate(LocalDate localDate){
        return p -> p.getStartDate() == localDate;
    }

    /**
     *
     * @param localDate end date contract
     * @return predicate end date
     */
    public static Predicate<Contract> isEndDate(LocalDate localDate){
        return p -> p.getEndDate() == localDate;
    }
}
