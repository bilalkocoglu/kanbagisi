package com.kanbagisi.net;

import com.kanbagisi.net.dao.City.impl.CityRepositoryImpl;

import java.util.Map;

public class TestCity {
    public static void main(String[]args){
        CityRepositoryImpl cityRepository = new CityRepositoryImpl();
        Map<String, Integer> allCity = cityRepository.getAllCity();
        System.out.println(allCity);
    }
}
