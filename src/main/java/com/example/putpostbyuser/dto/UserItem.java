package com.example.putpostbyuser.dto;

import com.example.putpostbyuser.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class UserItem {

    private String email;

    private String password;

    private String fullName;

    private boolean confirmed;

    private UserRole role;

    public static UserItem fromUser(User user){

        UserItem userItem=new UserItem();
        userItem.setEmail(user.getEmail());
        userItem.setFullName(user.getFullName());
        userItem.setPassword(user.getPassword());
        userItem.setRole(user.getRole());
        userItem.setConfirmed(user.isConfirmed());
        return userItem;
    }

}
