package com.kanbagisi.net.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @NotNull
    @Size(min = 5, max = 30)
    @Column
    private String userName;

    @NotNull
    @Size(min = 5, max = 30)
    @Column
    private String userSurname;

    @NotNull
    @Size(min = 11, max = 11)
    @Column
    private String userTel;

    @ManyToOne
    @JoinColumn(name = "cityId")
    private City city;

    public User() {
    }

    public User(String userName, String userSurname, String userTel, City city) {

        this.userName = userName;
        this.userSurname = userSurname;
        this.userTel = userTel;
        this.city = city;
    }

    public int getUserId() {

        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
