package org.contract.api.validator;

import org.contract.api.model.Contract;

/**
 * Validator for client's SNP
 * @author Maxim Suhochev
 */
public class SNPValidator implements Validator{
    @Override
    public ValidatorBody validate(Contract contract) {
        if(contract.getClient().getSNP().equals("Иванов Иван Иванович")){
            return new ValidatorBody(Status.ERROR, "This name is banal");
        }
        return new ValidatorBody(Status.OK);
    }
}
