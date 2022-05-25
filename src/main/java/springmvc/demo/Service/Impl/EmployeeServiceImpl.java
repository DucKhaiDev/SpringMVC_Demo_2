package springmvc.demo.Service.Impl;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmvc.demo.Dao.EmployeeDao;
import springmvc.demo.Model.Employee;
import springmvc.demo.Service.EmployeeService;

import java.util.List;

@NoArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public void delete(int employee_id) {
        employeeDao.delete(employee_id);
    }

    @Override
    public Employee getEmployee(int employee_id) {
        return employeeDao.getEmployee(employee_id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }
}
