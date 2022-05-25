package springmvc.demo.Dao;

import springmvc.demo.Model.Account;

import java.util.List;

public interface AccountDao {
    void save(Account account);

    void delete(int account_id);

    Account getAccount(int account_id);

    Account getAccount(String account);

    List<Account> getAll();
}
