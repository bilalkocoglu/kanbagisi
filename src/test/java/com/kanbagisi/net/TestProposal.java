package com.kanbagisi.net;

import com.kanbagisi.net.dao.General.impl.GeneralRepositoryImpl;
import com.kanbagisi.net.dao.State.impl.StateRepositoryImpl;
import com.kanbagisi.net.entity.Proposal;
import com.kanbagisi.net.entity.State;

public class TestProposal {
    public static void main(String [] args){
        StateRepositoryImpl stateRepository = new StateRepositoryImpl();
        GeneralRepositoryImpl generalRepository = new GeneralRepositoryImpl();

        State state = stateRepository.findStateById(1);

        Proposal proposal = new Proposal("bilal.kocoglu@gmail.com", "selam ağam", state);

        System.out.println(generalRepository.save(proposal));

    }
}
