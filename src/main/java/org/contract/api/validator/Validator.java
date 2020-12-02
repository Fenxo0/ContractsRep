package org.contract.api.validator;

import org.contract.api.model.Contract;

/**
 * Interface for validators
 * @author Maxim Suhochev
 */
public interface Validator {

    public ValidatorBody validate(Contract contract);

}
