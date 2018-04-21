package com.kanbagisi.net;

import com.kanbagisi.net.entity.BloodGroup;
import com.kanbagisi.net.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BloodGroupSave {
    public static void main(String [] args){
        List<BloodGroup> bloodGroupList = new LinkedList<>();
        bloodGroupList.add(new BloodGroup("AB Rh +"));
        bloodGroupList.add(new BloodGroup("AB Rh -"));
        bloodGroupList.add(new BloodGroup("B  Rh +"));
        bloodGroupList.add(new BloodGroup("B  Rh -"));
        bloodGroupList.add(new BloodGroup("A  Rh +"));
        bloodGroupList.add(new BloodGroup("A  Rh -"));
        bloodGroupList.add(new BloodGroup("0  Rh +"));
        bloodGroupList.add(new BloodGroup("0  Rh -"));

        Iterator<BloodGroup> bloodGroupIterator = bloodGroupList.iterator();
        try{
            EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
            em.getTransaction().begin();

            while (bloodGroupIterator.hasNext()){
                BloodGroup bloodGroup = bloodGroupIterator.next();
                em.persist(bloodGroup);
            }
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
