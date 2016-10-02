package com.example.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface UserClientV1 {
    @RequestMapping(method = RequestMethod.GET, value = "/uaa/v1/me")
    User getAuthenticatedUser();
}
