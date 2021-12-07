package masarifyuli.co.id.javaspring.entity.employee;

import masarifyuli.co.id.javaspring.exception.RequiredValidation;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class EmployeeValidator implements Validator {

    public boolean supports(Class clazz) {
        return Employee.class.equals(clazz);
    }

    public void validate(Object obj, Errors err) {
        Employee o = (Employee) obj;
        new RequiredValidation("Username", o.getUsername());
        new RequiredValidation("Name", o.getName());
        new RequiredValidation("Password", o.getPassword());
        new RequiredValidation("Address", o.getAddress());
    }


}
