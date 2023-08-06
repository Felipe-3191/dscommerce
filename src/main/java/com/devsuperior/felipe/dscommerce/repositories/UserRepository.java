package com.devsuperior.felipe.dscommerce.repositories;

import com.devsuperior.felipe.dscommerce.entities.User;
import com.devsuperior.felipe.dscommerce.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    @Query(nativeQuery = true, value = "select tb_user.email as username, tb_user.password as password," +
            " tb_role.id as roleId, tb_role.authority as authority" +
            " FROM tb_user " +
            " JOIN tb_user_role ON tb_user.id = tb_user_role.user_id" +
            " JOIN tb_role ON tb_role.id = tb_user_role.role_id" +
            " WHERE tb_user.email = :email")
    public List<UserDetailsProjection> searchUserAndRolesByEmail (String email);

}
