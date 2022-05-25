package springmvc.demo.Service.Impl;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmvc.demo.Dao.AccountDao;
import springmvc.demo.Model.Account;
import springmvc.demo.Service.AccountService;

import java.util.List;

@NoArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    @Autowired
    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void save(Account account) {
        accountDao.save(account);
    }

    @Override
    public void delete(int account_id) {
        accountDao.delete(account_id);
    }

    @Override
    public Account getAccount(int account_id) {
        return accountDao.getAccount(account_id);
    }

    @Override
    public List<Account> getAll() {
        return accountDao.getAll();
    }
}
