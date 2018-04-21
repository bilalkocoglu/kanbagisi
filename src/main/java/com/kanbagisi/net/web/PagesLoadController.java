package com.kanbagisi.net.web;

import com.kanbagisi.net.services.PagesLoadService;

import javax.faces.bean.ManagedBean;
import java.util.Map;

@ManagedBean(name = "load")
public class PagesLoadController {

    private String selectedCityId;

    private Map<String,Integer> allCityMap = PagesLoadService.allCityMap;

    private String selectedBloodGroupId;

    private Map<String, Integer> allBloodGroupMap = PagesLoadService.allBloodGroupMap;

    public void filtrele(){
        System.out.println(getSelectedCityId());
        System.out.println(getSelectedBloodGroupId());
    }

    public String getSelectedCityId() {
        return selectedCityId;
    }

    public void setSelectedCityId(String selectedCityId) {
        this.selectedCityId = selectedCityId;
    }

    public Map<String, Integer> getAllCityMap() {
        return allCityMap;
    }

    public void setAllCityMap(Map<String, Integer> allCityMap) {
        this.allCityMap = allCityMap;
    }

    public String getSelectedBloodGroupId() {
        return selectedBloodGroupId;
    }

    public void setSelectedBloodGroupId(String selectedBloodGroupId) {
        this.selectedBloodGroupId = selectedBloodGroupId;
    }

    public Map<String, Integer> getAllBloodGroupMap() {
        return allBloodGroupMap;
    }

    public void setAllBloodGroupMap(Map<String, Integer> allBloodGroupMap) {
        this.allBloodGroupMap = allBloodGroupMap;
    }
}
