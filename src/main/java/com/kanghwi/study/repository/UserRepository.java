package com.kanghwi.study.repository;

import com.kanghwi.study.model.Board;
import com.kanghwi.study.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
