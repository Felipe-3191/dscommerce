package com.devsuperior.felipe.dscommerce.services;

import com.devsuperior.felipe.dscommerce.dto.UserDTO;
import com.devsuperior.felipe.dscommerce.entities.Role;
import com.devsuperior.felipe.dscommerce.entities.User;
import com.devsuperior.felipe.dscommerce.projections.UserDetailsProjection;
import com.devsuperior.felipe.dscommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    protected User authenticated() {
        try {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Jwt jwtPrincipal = (Jwt) authentication.getPrincipal();
        String username = jwtPrincipal.getClaim("username");

        User user = respository.findByEmail(username).get();
        return user;
        } catch (Exception e) {
            throw new UsernameNotFoundException("Email not found");
        }
    }


    /*o user DTO tá sendo gerado no service aqui, teoricamente isso fere
      o modelo de arquitetura proposta por ele pois o service passa
      a conhecer o DTO, quando o ideal é apenas o controller conhecê-lo
      mas isso foi uma boa jogada para evitar o lazy exception que ocorreria
    */

    @Transactional(readOnly = true)

    public UserDTO getMe() {
        User user = authenticated();
        return new UserDTO(user);
    }

}
