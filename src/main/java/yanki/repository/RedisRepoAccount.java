package yanki.repository;

import yanki.model.Account;

import java.util.Map;

public interface RedisRepoAccount {
    Map<String, Account> findAll();
    Account findById(String id);
    void save(Account student);
    void delete(String id);
}
