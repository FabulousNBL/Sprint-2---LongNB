package com.project.repository;

import com.project.model.account.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IAppUserRepository extends JpaRepository<AppUser, Long> {

    @Query(value = " select au.is_deleted, " +
            " au.password, au.username from app_user au where au.username = :username and au.is_deleted = 0 ",
            nativeQuery = true)
    AppUser getAppUserByUsername(@Param("username") String username);
}
