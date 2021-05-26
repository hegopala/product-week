package com.maintenance.system.repository;

import com.maintenance.system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * This is UserRepository interface
 *
 * @author Sunil Hansda
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from userprofile where user_status = 'Y'", nativeQuery = true)
    public User getLoggedInUser();

}
