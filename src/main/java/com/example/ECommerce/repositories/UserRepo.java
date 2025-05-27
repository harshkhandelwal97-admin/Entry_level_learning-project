package com.example.ECommerce.repositories;

import com.example.ECommerce.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<User,Long> {

}
