package com.example.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchService {
    private final WatchRepository watchRepository;

    @Autowired
    public WatchService(WatchRepository watchRepository){
        this.watchRepository = watchRepository;
    }

    public  List<Watch> getAllWatches(){
        return watchRepository.getAllWatches();
    }

    public void addWatch(Watch newWatch){
        watchRepository.addWatch(newWatch);
    }
    public String deleteWatchById(Long id) {
        watchRepository.deleteWatchById(id);
        return "Record deleted";
    }
    public Mobile getWatchById(Long id){
        return watchRepository.getWatchById(id);
    }
    public void updateWatch(Watch updatedWatch) {
        watchRepository.updateWatch(updatedWatch);
    }
}
