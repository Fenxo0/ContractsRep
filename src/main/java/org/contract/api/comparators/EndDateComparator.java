package org.contract.api.comparators;

import org.contract.api.model.Contract;

import java.util.Comparator;

/**
 * @author Maxim Suhochev
 */
public class EndDateComparator implements Comparator<Contract> {

    /**
     * Here is the comparison by end date contract
     * @param o1 contract1
     * @param o2 contract2
     * @return comparison result by end date contract
     */
    @Override
    public int compare(Contract o1, Contract o2) {
        if(o1.getEndDate().isAfter(o2.getEndDate()))
            return 1;
        else if(!o1.getEndDate().isAfter(o2.getEndDate()))
            return -1;
        else
            return 0;
    }
}
