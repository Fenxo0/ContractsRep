package org.contract.api.comparators;

import org.contract.api.contracts.Contract;

import java.util.Comparator;

/**
 * @author Maxim Suhochev
 */
public class IdClientsComparator implements Comparator<Contract> {

    /**
     * Here is the comparison by id client
     * @param o1 contract1
     * @param o2 contract2
     * @return comparison result by id client
     */
    @Override
    public int compare(Contract o1, Contract o2) {
        if(o1.getClient().getId() > o2.getClient().getId())
            return 1;
        else if(o1.getClient().getId() < o2.getClient().getId())
            return -1;
        else
            return 0;
    }
}
