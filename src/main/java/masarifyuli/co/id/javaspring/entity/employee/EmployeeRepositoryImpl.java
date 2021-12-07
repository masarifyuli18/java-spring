package masarifyuli.co.id.javaspring.entity.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
