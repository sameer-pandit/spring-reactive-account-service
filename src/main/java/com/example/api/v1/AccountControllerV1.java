package com.example.api.v1;

import com.example.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import reactor.core.publisher.*;
import java.util.Optional;

@RestController
@RequestMapping(path = "/v1")
public class AccountControllerV1 {

    private AccountServiceV1 accountService;

    @Autowired
    public AccountControllerV1(AccountServiceV1 accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(path = "/accounts")
    public Flux<Account> getUserAccount() throws Exception {
        return accountService.getUserAccounts();
    }
}
