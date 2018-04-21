package com.kanbagisi.net;

import com.kanbagisi.net.dao.General.impl.GeneralRepositoryImpl;
import com.kanbagisi.net.entity.*;

public class GeneralFind {
    public static void main(String[] args){
        GeneralRepositoryImpl generalRepository = new GeneralRepositoryImpl();
        User user = generalRepository.findById(User.class,1);
        City city = generalRepository.findById(City.class,1);
        BloodGroup bloodGroup = generalRepository.findById(BloodGroup.class,92);
        State state = generalRepository.findById(State.class,0);
        Donation donation = new Donation(user,city,bloodGroup,state);
        generalRepository.save(donation);
    }
}
