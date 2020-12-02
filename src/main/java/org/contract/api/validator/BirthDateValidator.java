package org.contract.api.validator;

import org.contract.api.model.Contract;

import java.time.Year;
import java.util.Calendar;

/**
 * Validator for client's birthdate
 * @author Maxim Suhochev
 */
public class BirthDateValidator implements Validator {
    @Override
    public ValidatorBody validate(Contract contract) {
        int year = contract.getClient().getBirthDate().getYear();
        int yearNow = Year.now().getValue();
        if(year == yearNow){
            return new ValidatorBody(Status.RED_RISK, "This client is baby");
        }
        return new ValidatorBody(Status.OK);
    }
}
