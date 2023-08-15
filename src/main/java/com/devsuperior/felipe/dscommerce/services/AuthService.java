package com.devsuperior.felipe.dscommerce.services;

import com.devsuperior.felipe.dscommerce.entities.User;
import com.devsuperior.felipe.dscommerce.services.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    private static final String ROLE_ADMIN = "ROLE_ADMIN";
    public void validateSelfOrAdmin(long userId) {
        User me = userService.authenticated();
        if (!me.hasRole(ROLE_ADMIN) && !me.getId().equals(userId)) {
            throw new ForbiddenException("Access Denied");
        }

    }

}
