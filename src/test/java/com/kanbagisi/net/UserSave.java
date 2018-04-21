package com.kanbagisi.net;

import com.kanbagisi.net.dao.City.impl.CityRepositoryImpl;
import com.kanbagisi.net.dao.General.impl.GeneralRepositoryImpl;
import com.kanbagisi.net.entity.City;
import com.kanbagisi.net.entity.User;
import com.kanbagisi.net.dao.User.Impl.UserRepositoryImpl;

public class UserSave {
    public static void main(String [] args){
        GeneralRepositoryImpl generalRepository = new GeneralRepositoryImpl();

        City city = generalRepository.findById(City.class,34);

        System.out.println(city.toString());

        System.out.println(generalRepository.save(new User("bilal", "kocoglu", "02125565656", "admin","admin" , city)));
    }
}
