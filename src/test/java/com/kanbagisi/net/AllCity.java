package com.kanbagisi.net;

import com.kanbagisi.net.dao.City.impl.CityRepositoryImpl;
import com.kanbagisi.net.entity.City;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllCity {
    public static void main(String[]args){
        CityRepositoryImpl cityRepository = new CityRepositoryImpl();
        List allCityList = cityRepository.getAllCity();
        System.out.println(allCityList);
        Map<String,Integer> allCityMap = new HashMap<>();
        for (int i=0;i<allCityList.size();i++){
            com.kanbagisi.net.entity.City city = (com.kanbagisi.net.entity.City) allCityList.get(i);
            allCityMap.put(city.getCityName(),city.getCityId());
        }
        System.out.println(allCityMap);
        System.out.println(allCityMap.size());

    }
}
