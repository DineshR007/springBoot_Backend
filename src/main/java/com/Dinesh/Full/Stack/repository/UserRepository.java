package com.Dinesh.Full.Stack.repository;

import com.Dinesh.Full.Stack.module.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
}
