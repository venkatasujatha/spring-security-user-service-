package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.User2;
@Repository
public interface UserRepository extends JpaRepository<User2, Integer>{

}
