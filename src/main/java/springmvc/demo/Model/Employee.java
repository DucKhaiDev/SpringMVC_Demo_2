package springmvc.demo.Model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employee_id;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private int gender;

    @Column
    private Date date_of_birth;

    @Column
    private String phone;

    @Column
    private String address;

    @Column
    private String department_name;

    @Column
    private String remark;

    @OneToOne(mappedBy = "employee")
    private Account account;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employee_id, employee.employee_id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
