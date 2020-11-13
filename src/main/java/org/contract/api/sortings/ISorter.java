package org.contract.api.sortings;

import org.contract.api.contracts.Contract;

import java.util.Comparator;

public interface ISorter {
    public void sort(Comparator<Contract> comparator, int count, Contract[] contracts);
}
