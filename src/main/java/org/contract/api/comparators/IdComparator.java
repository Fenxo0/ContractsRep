package org.contract.api.comparators;

import org.contract.api.contracts.Contract;

import java.util.Comparator;

/**
 * @author Maxim Suhochev
 */
public class IdComparator implements Comparator<Contract> {

    /**
     * Here is the comparison by id
     * @param o1 contract1
     * @param o2 contract2
     * @return comparison result by id
     */
    @Override
    public int compare(Contract o1, Contract o2) {
        if(o1.getId() > o2.getId())
            return 1;
        else if(o1.getId() < o2.getId())
            return -1;
        else
            return 0;
    }
}

