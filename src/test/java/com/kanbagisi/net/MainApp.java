package com.kanbagisi.net;

import com.kanbagisi.net.dao.City.impl.CityRepositoryImpl;
import com.kanbagisi.net.entity.City;
import com.kanbagisi.net.entity.User;
import com.kanbagisi.net.dao.User.Impl.UserRepositoryImpl;

public class MainApp {
    public static void main(String [] args){
        UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();
        CityRepositoryImpl cityRepository = new CityRepositoryImpl();
        City city = cityRepository.findCity(34);

        System.out.println(city.toString());

        System.out.println(userRepositoryImpl.save(new User("bilal", "kocoglu", "02125565656", city)));
    }
}
