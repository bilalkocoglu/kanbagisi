package com.kanbagisi.net.entity;

import javax.persistence.*;

@Entity
@Table
public class BloodGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int bloodGroupId;

    @Column
    private String bloodGroupName;

    public BloodGroup(String bloodGroupName) {
        this.bloodGroupName = bloodGroupName;
    }

    public BloodGroup() {

    }

    public int getBloodGroupId() {

        return bloodGroupId;
    }

    public void setBloodGroupId(int bloodGroupId) {
        this.bloodGroupId = bloodGroupId;
    }

    public String getBloodGroupName() {
        return bloodGroupName;
    }

    public void setBloodGroupName(String bloodGroupName) {
        this.bloodGroupName = bloodGroupName;
    }

}
