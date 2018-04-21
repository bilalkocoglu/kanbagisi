package com.kanbagisi.net.services;

import com.kanbagisi.net.dao.BloodGroup.impl.BloodGroupRepositoryImpl;
import com.kanbagisi.net.dao.City.impl.CityRepositoryImpl;
import com.kanbagisi.net.entity.BloodGroup;
import com.kanbagisi.net.entity.City;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PagesLoadService {
    public static Map<String,Integer> allCityMap = getAllCityMap();

    public static Map<String,Integer> allBloodGroupMap = getAllBloodGroupMap();

    public static Map<String,Integer> getAllCityMap(){
        CityRepositoryImpl cityRepository = new CityRepositoryImpl();
        List allCityList = cityRepository.getAllCity();
        System.out.println(allCityList);
        Map<String,Integer> allCityMap = new LinkedHashMap<String,Integer>();
        for (int i=0;i<allCityList.size();i++){
            City city = (City) allCityList.get(i);
            allCityMap.put(city.getCityName(),city.getCityId());
        }
        return allCityMap;
    }

    public static Map<String,Integer> getAllBloodGroupMap(){
        BloodGroupRepositoryImpl bloodGroupRepository = new BloodGroupRepositoryImpl();
        List allBloodGroupList = bloodGroupRepository.getAllBloodGroup();
        System.out.println(allBloodGroupList);
        Map<String,Integer> allBloodGroupMap = new LinkedHashMap<String,Integer>();
        for (int i=0;i<allBloodGroupList.size();i++){
            BloodGroup bloodGroup = (BloodGroup) allBloodGroupList.get(i);
            allBloodGroupMap.put(bloodGroup.getBloodGroupName(), bloodGroup.getBloodGroupId());
        }
        return allBloodGroupMap;
    }
}
