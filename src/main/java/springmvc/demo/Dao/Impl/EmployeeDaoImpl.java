package springmvc.demo.Dao.Impl;

import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springmvc.demo.Dao.EmployeeDao;
import springmvc.demo.Model.Employee;

import java.util.List;

@NoArgsConstructor
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private SessionFactory sessionFactory;

    @Autowired
    public EmployeeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public void delete(int employee_id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("DELETE FROM Employee WHERE employee_id=:employee_id", Employee.class);
        query.setParameter("employee_id", employee_id);
        query.executeUpdate();
    }

    @Override
    public Employee getEmployee(int employee_id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, employee_id);
    }

    @Override
    public List<Employee> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("FROM Employee", Employee.class);
        return query.getResultList();
    }
}
