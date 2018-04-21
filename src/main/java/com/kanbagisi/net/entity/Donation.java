package com.kanbagisi.net.entity;

import javax.persistence.*;

@Entity
@Table
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int donationId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "cityId")
    private City city;

    @ManyToOne
    @JoinColumn(name = "bloodGroupId")
    private BloodGroup bloodGroup;

    @ManyToOne
    @JoinColumn(name = "stateId")
    private State state;

    public Donation() {
    }

    public Donation(User user, City city, BloodGroup bloodGroup, State state) {

        this.user = user;
        this.city = city;
        this.bloodGroup = bloodGroup;
        this.state = state;
    }

    public int getDonationId() {

        return donationId;
    }

    public void setDonationId(int donationId) {
        this.donationId = donationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
