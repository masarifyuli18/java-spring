package masarifyuli.co.id.javaspring.exception;

public class RequiredValidation extends HandledExceptionValidation {

    public RequiredValidation(String subject, String value) {
        super(subject, value, subject + " is required.", !value.isBlank());
    }

}
