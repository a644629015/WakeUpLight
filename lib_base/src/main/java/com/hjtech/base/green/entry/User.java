package com.hjtech.base.green.entry;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 项目名:    GreenDaoDemo
 * 包  名:    com.hjtech.greendaodemo.gen
 * 文件名:    User
 * 时  间:    2017/12/1 on 10:35
 * 描  述:    TODO
 *
 * @author: zjb
 */
@Entity
public class User {

    @Id(autoincrement = true)
    long id;
    String name;
    String password;


    public User() {
    }

    @Generated(hash = 179890708)
    public User(long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
