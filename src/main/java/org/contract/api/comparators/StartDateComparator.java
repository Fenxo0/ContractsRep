package org.contract.api.comparators;

import org.contract.api.model.Contract;

import java.util.Comparator;

/**
 * @author Maxim Suhochev
 */
public class StartDateComparator implements Comparator<Contract> {

    /**
     * Here is the comparison by start date contract
     * @param o1 contract1
     * @param o2 contract2
     * @return comparison result by start date contract
     */
    @Override
    public int compare(Contract o1, Contract o2) {
        if(o1.getStartDate().isAfter(o2.getStartDate()))
            return 1;
        else if(!o1.getStartDate().isAfter(o2.getStartDate()))
            return -1;
        else
            return 0;
    }
}
