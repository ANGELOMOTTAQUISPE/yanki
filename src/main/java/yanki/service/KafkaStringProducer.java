package yanki.service;

import org.springframework.stereotype.Service;
import yanki.model.Client;

@Service
public class KafkaStringProducer {

    private final SavingClientEvent accountServiceEvents;

    public KafkaStringProducer(SavingClientEvent accountServiceEvents) {
        super();
        this.accountServiceEvents = accountServiceEvents;
    }

    public Client save(Client savingAccount) {
        System.out.println("Received " + savingAccount);
        this.accountServiceEvents.publish(savingAccount);
        return savingAccount;
    }

}