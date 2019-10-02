package com.example.everything.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = 4730781238580300320L;
    private Integer id;
    private String userName;
    private String passWord;
    private Integer enable;

}
