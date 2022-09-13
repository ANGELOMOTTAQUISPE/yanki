package yanki.repository;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import yanki.model.Account;
import yanki.model.Client;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.UUID;
@Repository
public class SavingAccountRepository implements RedisRepoAccount{
    private static final String KEY = "account";
    private RedisTemplate<String, Account> redisTemplate;
    private HashOperations hashOperations;

    public SavingAccountRepository(RedisTemplate<String, Account> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<String, Account> findAll() {
        return hashOperations.entries(KEY);
    }


    public Account findById(String id) {
        return (Account) hashOperations.get(KEY, id);
    }


    public void save(Account savingAccount) {
        hashOperations.put(KEY, UUID.randomUUID().toString(), savingAccount);
    }


    public void delete(String id) {
        hashOperations.delete(KEY, id);
    }
}
