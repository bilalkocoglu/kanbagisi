package com.kanbagisi.net.services;

import com.kanbagisi.net.dao.General.impl.GeneralRepositoryImpl;
import com.kanbagisi.net.entity.City;
import com.kanbagisi.net.entity.User;

public class NewUserService {
    GeneralRepositoryImpl generalRepository;
    public NewUserService() {
        generalRepository = new GeneralRepositoryImpl();
    }

    public boolean createNewUser(User user, int cityId){
        City city = generalRepository.findById(City.class,cityId);
        if (city != null){
            user.setCity(city);
            return generalRepository.save(user);
        }else
            return false;
    }
}
