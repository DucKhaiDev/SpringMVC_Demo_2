package springmvc.demo.Dao.Impl;

import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springmvc.demo.Dao.AccountDao;
import springmvc.demo.Model.Account;

import java.util.List;

@NoArgsConstructor
@Repository
public class AccountDaoImpl implements AccountDao {
    private SessionFactory sessionFactory;

    @Autowired
    public AccountDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(account);
    }

    @Override
    public void delete(int account_id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Account> query = session.createQuery("DELETE FROM Account WHERE account_id=:account_id", Account.class);
        query.setParameter("account_id", account_id);
        query.executeUpdate();
    }

    @Override
    public Account getAccount(int account_id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Account.class, account_id);
    }

    @Override
    public Account getAccount(String account) {
        Session session = sessionFactory.getCurrentSession();
        Query<Account> query = session.createQuery("FROM Account WHERE account=:account", Account.class);
        query.setParameter("account", account);
        return query.getSingleResult();
    }

    @Override
    public List<Account> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<Account> query = session.createQuery("FROM Account", Account.class);
        return query.getResultList();
    }
}
