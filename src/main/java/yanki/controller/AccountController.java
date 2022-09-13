package yanki.controller;

import org.springframework.web.bind.annotation.*;
import yanki.model.Account;
import yanki.model.Client;
import yanki.repository.SavingAccountRepository;

import java.util.Map;

@RestController
public class AccountController {
    private SavingAccountRepository savingRepository;

    public AccountController(SavingAccountRepository savingRepository) {
        this.savingRepository = savingRepository;
    }

    @GetMapping("/savings")
    public Map<String, Account> findAll() {
        return savingRepository.findAll();
    }

    @GetMapping("/savings/{id}")
    public Account findById(@PathVariable String id) {
        return savingRepository.findById(id);
    }

    @PostMapping("/savings")
    public void createStudent(@RequestBody Account account) {
        savingRepository.save(account);
    }

    @DeleteMapping("/savings/{id}")
    public void deleteStudent(@PathVariable String id) {
        savingRepository.delete(id);
    }
}
