package com.kanghwi.study.Service;

import com.kanghwi.study.model.Role;
import com.kanghwi.study.model.User;
import com.kanghwi.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;



    public User save(User user){
        String encodePassword = passwordEncoder.encode(user.getPassword());     // 비밀번호 암호화
        user.setPassword(encodePassword);
        user.setEnabled(true);
        Role role = new Role();
        role.setId(1l);
        user.getRoles().add(role);
        return userRepository.save(user);
    }

}
