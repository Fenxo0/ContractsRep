package org.contract.api.sortings;

import org.contract.api.model.Contract;

import java.util.Comparator;

public class InsertionSorting implements ISorter {
    @Override
    public void sort(Comparator<Contract> comparator, int count, Contract[] contracts) {
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
}
