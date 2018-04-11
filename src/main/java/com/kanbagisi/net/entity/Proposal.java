package com.kanbagisi.net.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class Proposal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int proposalId;

    @NotNull
    @Column
    @Size(min = 10, max = 60)
    private String proposalEmail;

    @NotNull
    @Column
    private String proposalMessage;

    @ManyToOne
    @JoinColumn(name = "stateId")
    private State state;

    public Proposal() {
    }

    public Proposal(String proposalEmail, String proposalMessage, State state) {

        this.proposalEmail = proposalEmail;
        this.proposalMessage = proposalMessage;
        this.state = state;
    }

    public int getProposalId() {

        return proposalId;
    }

    public void setProposalId(int proposalId) {
        this.proposalId = proposalId;
    }

    public String getProposalEmail() {
        return proposalEmail;
    }

    public void setProposalEmail(String proposalEmail) {
        this.proposalEmail = proposalEmail;
    }

    public String getProposalMessage() {
        return proposalMessage;
    }

    public void setProposalMessage(String proposalMessage) {
        this.proposalMessage = proposalMessage;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
