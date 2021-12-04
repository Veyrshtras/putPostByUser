package com.example.putpostbyuser.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.swing.*;

@Getter
@Setter
@Entity
public class Comment extends BaseEntity{

    @Column(columnDefinition = "text")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    private Blog blog;

}
