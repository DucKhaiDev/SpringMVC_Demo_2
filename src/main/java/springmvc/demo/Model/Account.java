package springmvc.demo.Model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int account_id;

    @Column
    private String account;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private int status;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Account account = (Account) o;
        return Objects.equals(account_id, account.account_id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
