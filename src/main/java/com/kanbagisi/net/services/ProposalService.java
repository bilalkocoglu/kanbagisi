package com.kanbagisi.net.services;

import com.kanbagisi.net.dao.General.impl.GeneralRepositoryImpl;
import com.kanbagisi.net.dao.State.impl.StateRepositoryImpl;
import com.kanbagisi.net.entity.Proposal;
import com.kanbagisi.net.entity.State;

public class ProposalService {
    GeneralRepositoryImpl generalRepository = new GeneralRepositoryImpl();
    StateRepositoryImpl stateRepository = new StateRepositoryImpl();
    public boolean addProposal(String email, String message, int stateId){
        State state1 = stateRepository.findStateById(stateId);
        if (state1!=null){
            Proposal proposal = new Proposal(email, message, state1);
            return generalRepository.save(proposal);
        }else
            return false;
    }
}
