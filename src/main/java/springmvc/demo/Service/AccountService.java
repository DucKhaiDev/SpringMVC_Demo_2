package springmvc.demo.Service;

import springmvc.demo.Model.Account;

import java.util.List;

public interface AccountService {
    void save(Account account);

    void delete(int account_id);

    Account getAccount(int account_id);

    List<Account> getAll();
}
