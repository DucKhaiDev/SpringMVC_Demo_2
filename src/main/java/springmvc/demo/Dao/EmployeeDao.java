package springmvc.demo.Dao;

import springmvc.demo.Model.Employee;

import java.util.List;

public interface EmployeeDao {
    void save(Employee employee);

    void delete(int employee_id);

    Employee getEmployee(int employee_id);

    List<Employee> getAll();
}
