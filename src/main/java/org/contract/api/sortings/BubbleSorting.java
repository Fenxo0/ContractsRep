package org.contract.api.sortings;

import org.contract.api.model.Contract;

import java.util.Comparator;

public class BubbleSorting implements ISorter {
    @Override
    public void sort(Comparator<Contract> comparator, int count, Contract[] contracts){
        for(int j = count-1; j >= 1; j--){
            for (int i = 0; i < j; i++) {
                if(comparator.compare(contracts[i], contracts[i+1]) == 1) {
                    Contract temp = contracts[i];
                    contracts[i] = contracts[i+1];
                    contracts[i+1] = temp;
                }
            }
        }
    }
}
