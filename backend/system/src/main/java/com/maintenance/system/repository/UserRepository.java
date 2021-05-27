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
public interface UserRepository  extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM USER_PROFILE u where u.USER_STATUS = 'Y'", nativeQuery = true)
    public User getLoggedInUser();

}
