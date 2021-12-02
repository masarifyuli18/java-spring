package masarifyuli.co.id.javaspring.entity.employee;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    @Override
    public List<Employee> findAll();

    public Employee findByUsername(String username);
}
