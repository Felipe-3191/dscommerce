package com.devsuperior.felipe.dscommerce.services;

import com.devsuperior.felipe.dscommerce.entities.Role;
import com.devsuperior.felipe.dscommerce.entities.User;
import com.devsuperior.felipe.dscommerce.projections.UserDetailsProjection;
import com.devsuperior.felipe.dscommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository respository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetailsProjection> result = respository.searchUserAndRolesByEmail(username);
        if (result.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        User user = new User();
        user.setEmail(result.get(0).getUsername());
        user.setPassword(result.get(0).getPassword());
        result.forEach(r -> {
            user.addRole(new Role(r.getRoleId(),r.getAuthority()));
        });

        return user;
    }
}
