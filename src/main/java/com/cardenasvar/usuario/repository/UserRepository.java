package com.cardenasvar.usuario.repository;

import com.cardenasvar.usuario.model.User;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "select * from Users u where u.email = :#{#vEmail}", nativeQuery = true)
    public User findByEmail(
            @Param("vEmail") String vEmail);

    List<User> findAll();

    @Modifying
    @Query(value = "update Users u set u.token = :#{#vToken}, u.last_login = :#{#vLastLogin}, u.modified = :#{#vModified} WHERE u.email = :#{#vEmail}", nativeQuery = true)
    int updateUser(
            @Param("vEmail") String vEmail,
            @Param("vToken") String vToken,
            @Param("vLastLogin") String vLastLogin,
            @Param("vModified") String vModified);
}