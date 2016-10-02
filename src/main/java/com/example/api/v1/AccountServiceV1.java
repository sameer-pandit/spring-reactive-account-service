package com.example.api.v1;

import java.util.ArrayList;



import com.example.account.Account;
import com.example.account.AccountRepository;
import com.example.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.web.client.reactive.ClientWebRequestBuilders.get;
import static org.springframework.web.client.reactive.ClientWebRequestBuilders.post;
import static org.springframework.web.client.reactive.ResponseExtractors.body;
import static org.springframework.web.client.reactive.ResponseExtractors.bodyStream;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.client.reactive.ResponseExtractors;
import org.springframework.web.client.reactive.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class AccountServiceV1 {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceV1(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Flux<Account> getUserAccounts() {
        /*WebClient webClient = new WebClient(new ReactorClientHttpConnector());
        List<Account> account=null;
        String userUrl = "http://user-service/uaa/v1/me";
        Mono<User> user = webClient
                .perform(get(userUrl).accept(MediaType.APPLICATION_JSON))
                .extract(body(User.class));
        if (user != null) {
            account = accountRepository.findAccountsByUserId(user.block().getUsername());
        }

        // Mask credit card numbers
        if (account != null) {
            account.forEach(acct -> acct.getCreditCards()
                    .forEach(card ->
                            card.setNumber(card.getNumber()
                                    .replaceAll("([\\d]{4})(?!$)", "****-"))));
        }*/
        List<Account> account = new ArrayList<>();
        account.add(new Account("3","2322323"));
        accountRepository.save(account);
        return Flux.fromIterable(accountRepository.findAccountsByUserId("3"));
    }
}
