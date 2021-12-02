package masarifyuli.co.id.javaspring.exception;

import java.util.LinkedHashMap;
import java.util.Map;

abstract class HandledExceptionValidation {

    HandledExceptionValidation(String subject, String value, String message, Boolean valid) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", message);
        body.put("subject", subject);
        body.put("value", value);

        if (!valid) {
            HandleException ex = new HandleException(message);
            ex.setMap(body);
            throw ex;
        }

    }

}
