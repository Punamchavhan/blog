
package com.example.blog;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.User;

@Repository

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUserName(string username);
}


