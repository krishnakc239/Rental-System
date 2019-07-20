package com.mum.edu.repository;

import com.mum.edu.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public User findDistinctByUsernameAndPassword(String user_name,String password);
}
