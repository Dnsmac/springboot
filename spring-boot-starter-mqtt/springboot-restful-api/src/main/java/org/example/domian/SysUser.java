package org.example.domian;

import java.util.Date;

@Data
public class SysUser {

    private  Integer id;
    private  String username;
    private  String nickname;
    private  String password;
    private Date RegistTime;
    private  Integer IsDelete;
}
