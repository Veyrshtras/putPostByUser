package com.example.putpostbyuser.entity;

import com.example.putpostbyuser.dto.UserRole;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Setter
@Getter
@Entity(name = "my_user")
public class User extends BaseEntity{

    @Column(unique = true)
    private String email;

    private String password;

    private String fullName;

    @Column(nullable = false)
    @ColumnDefault("false")
    private boolean confirmed=false;

    @Enumerated(EnumType.STRING)
    private UserRole role=UserRole.USER;

}
