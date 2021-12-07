package masarifyuli.co.id.javaspring;


import masarifyuli.co.id.javaspring.entity.employee.Employee;
import masarifyuli.co.id.javaspring.entity.employee.EmployeeRepository;
import masarifyuli.co.id.javaspring.security.entity.OauthClientDetails;
import masarifyuli.co.id.javaspring.security.entity.OauthClientDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AfterSpringStart {

    @Autowired
    private OauthClientDetailsRepository oauthClientDetailsRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void afterAppReady() {
        defaultOauthClient();
        defaultUserAdmin();
    }

    private void defaultOauthClient() {
        Optional<OauthClientDetails> oauth = oauthClientDetailsRepository.findById("client");
        if (oauth.isEmpty()) {
            oauthClientDetailsRepository.save(
                    new OauthClientDetails(
                            "masarifyuli-client",
                            "masarifyuli-psw",
                            "masarifyuli-resource",
                            "read,web",
                            "password,refresh_token,client_credentials",
                            "",
                            "USER,WEB",
                            900,
                            3600 * 24 * 7,
                            "{}",
                            ""
                    )
            );
        }
    }

    private void defaultUserAdmin() {
        Optional<Employee> e = employeeRepository.findById(1);
        if (e.isEmpty()) {
            Employee newEmp = new Employee("masarifyuli", "Masarifyuli",
                    "masarifyuli", "Sleman, Indonesia", Employee.Gender.MALE);
            newEmp.setEmail("hi.masarifyuli@gmail.com");
            newEmp.setMobileNo("085156809248");
            employeeRepository.save(newEmp);
        }
    }


}
