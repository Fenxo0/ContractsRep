package org.contract.api.validator;

import org.contract.api.model.Contract;

/**
 * Validator for client's sex
 * @author Maxim Suhochev
 */
public class SexValidator implements Validator {
    @Override
    public ValidatorBody validate(Contract contract) {
        if(contract.getClient().getSex().equals("Оно")){
            return new ValidatorBody(Status.ERROR, "This sex of a person not found!");
        }
        return new ValidatorBody(Status.OK);
    }
}
