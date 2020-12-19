package org.contract.api.util.validator;

import org.contract.api.model.Contract;

import java.util.List;

/**
 * Validation contract by all validator
 * @author Maxim Suhochev
 */
public class ValidatorExecution {

    public static void doValidation(List<Validator> validators, Contract contract){
        for (Validator validator:validators) {
            System.out.println(validator.validate(contract));
        }
    }
}
