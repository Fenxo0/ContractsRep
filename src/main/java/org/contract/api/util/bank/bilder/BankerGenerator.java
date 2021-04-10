package org.contract.api.util.bank.bilder;

import org.contract.api.util.bank.Bank;
import org.contract.api.util.bank.Banker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxim Suhochev
 */

/** Class for generate bankers*/
public class BankerGenerator {

    private final static int N = 3;

    private final static int SERVICE_TIME = 9000;

    /**
     * Generate banker
     * @param bank class
     * @return banker
     */
    public static List<Banker> generateBanker(Bank bank){
        List<Banker> bankers = new ArrayList<>();
        Banker.setServiceTime(SERVICE_TIME);
        Banker.setBank(bank);
        for (int i = 0; i < N; i++){
            Banker banker = new Banker();
            bankers.add(banker);
            bankers.get(i).start();
        }
        return bankers;
    }
}
