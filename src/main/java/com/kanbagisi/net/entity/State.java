package com.kanbagisi.net.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class State {
    @Id
    private int stateId;
    @Column

    private String stateName;
    @Override
    public String toString() {
        return "State{" +
                "stateId=" + stateId +
                ", stateName='" + stateName + '\'' +
                '}';
    }

    public State() {
    }

    public State(int stateId, String stateName) {

        this.stateId = stateId;
        this.stateName = stateName;
    }

    public int getStateId() {

        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

}
