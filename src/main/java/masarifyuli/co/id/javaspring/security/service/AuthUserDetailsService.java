package masarifyuli.co.id.javaspring.security.service;

import masarifyuli.co.id.javaspring.entity.employee.Employee;
import masarifyuli.co.id.javaspring.entity.employee.EmployeeRepository;
import masarifyuli.co.id.javaspring.security.model.AuthUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
public class AuthUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername");
        AuthUserDetails ud = null;
        Employee e = employeeRepository.findByUsername(username);
        if (e == null) {
            throw new UsernameNotFoundException("Wrong username or password");
        }
        List<String> roles = new ArrayList();
        ud = e.toAuthUserDetails(roles);
        new AccountStatusUserDetailsChecker().check(ud);
        return ud;
    }

}
