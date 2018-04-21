package com.kanbagisi.net.web;

import com.kanbagisi.net.services.ProposalService;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "newProposal")
public class NewProposalController {
    private String email;
    private String message;
    private boolean state;

    public NewProposalController() {

    }

    public String sendProposal(){
        ProposalService service = new ProposalService();
        int stateId;
        if (state)
            stateId=1;
        else
            stateId=0;
        if(service.addProposal(email,message,stateId)) {
            System.out.println("Proposal başarıyla eklendi !");
            return null;
        } else {
            System.out.println("Proposal ekleme başarısız !");
            return "admin?faces-redirect=true";
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
