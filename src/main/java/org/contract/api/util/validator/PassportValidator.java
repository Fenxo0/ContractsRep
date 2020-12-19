package org.contract.api.util.validator;

import org.contract.api.model.Contract;

/**
 *Validator for client's passport
 * @author Maxim Suhochev
 */
public class PassportValidator implements Validator {
    @Override
    public ValidatorBody validate(Contract contract) {
        if(contract.getClient().getNumPas() == contract.getClient().getSerPas()){
            return new ValidatorBody(Status.RED_RISK, "Wrong passport");
        }
        return new ValidatorBody(Status.OK);
    }
}
