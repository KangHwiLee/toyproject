package com.kanghwi.study.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String password;
    private boolean enabled;


    @ManyToMany             //CASCADE 옵션 가능, 유저테이블 값 추가하면 뭐 값 같이 등록 그런 외래키같은 거였던거같은데..
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),        // inner join user u on u.id = user_role.user_id 랑 같음
            inverseJoinColumns = @JoinColumn(name = "role_id"))         // 조인하면 어떤값을 가져올 것인지? -> user_id값을 조회하면 role_id를 가져옴


    private List<Role> roles = new ArrayList<>();
}


