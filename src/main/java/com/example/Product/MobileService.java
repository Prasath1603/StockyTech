package com.example.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MobileService {
    private final MobileRepository mobileRepository;

    @Autowired
    public MobileService(MobileRepository mobileRepository){
        this.mobileRepository = mobileRepository;
    }

    public List<Mobile> getAllMobiles(){
        return mobileRepository.getAllMobiles();
    }

    public void addMobile(Mobile newMobile){
        mobileRepository.addMobile(newMobile);
    }
    public String deleteMobileById(Long id) {
        mobileRepository.deleteMobileById(id);
        return "Record deleted";
    }
    public void updateMobile(Mobile updatedMobile) {
        mobileRepository.updateMobile(updatedMobile);
    }

//    public void updateMobile(Mobile mobile) {
//        mobileRepository.updateMobile(mobile);
//    }

    public Mobile getMobileById(Long id){
        return mobileRepository.getMobileById(id);
    }
}
