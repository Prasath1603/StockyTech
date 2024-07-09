package com.example.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("mobile")
public class MobileController {
    private final MobileService mobileService;
    private final WatchService watchService;

    @Autowired
    public MobileController(MobileService mobileService,WatchService watchService){
        this.mobileService = mobileService;
        this.watchService=watchService;

    }

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/home")
    public String getHome(){
        return "home";
    }
    @GetMapping("/about")
    public String getAbout(){
        return "about";
    }
    @GetMapping("/contact")
    public String getContact(){
        return "contact";
    }
    @GetMapping
    public String getAll(Model model){
        List<Mobile> mobiles = mobileService.getAllMobiles();
        model.addAttribute("mobiles", mobiles);
        return "listmobiles";
    }

    @PostMapping
    public String addMobile(@ModelAttribute("newMobile") Mobile newMobile){
        mobileService.addMobile(newMobile);
        return "redirect:/mobile";
    }
    @PostMapping("/{id}")
    public String deleteMobile(@PathVariable("id") Long id) {
        mobileService.deleteMobileById(id);
        return "redirect:/mobile";
    }
    @GetMapping("{id}")
    public String getMobileDetails(@PathVariable("id") Long id, Model model){
        Mobile mobile = mobileService.getMobileById(id);
        System.out.println(mobileService.getMobileById(id));
        model.addAttribute("mobile", mobile);
        return "mobiledetails";
    }
    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Mobile mobile = mobileService.getMobileById(id);
        model.addAttribute("mobile", mobile);
        return "updatemobile"; // This should be the name of your HTML file for updating mobile details
    }

    @PostMapping("/{id}/update")
    public String updateMobile(@ModelAttribute("mobile") Mobile updatedMobile, @PathVariable("id") Long id) {
        updatedMobile.setId(id); // Make sure to set the ID of the updated mobile
        mobileService.updateMobile(updatedMobile);
        return "redirect:/mobile"; // Redirect to the details page of the updated mobile
    }
//    @PostMapping("/update/{id}")
//    public String updateMobile(@ModelAttribute("updatedMobile") Mobile updatedMobile,@PathVariable("id") Long id) {
//
//        mobileService.updateMobile(updatedMobile(id));
//        return "update";
//    }

    //Watch Details
    @GetMapping("/lwatch")
    public String getAllWatches(Model model){
        List<Watch> watches = watchService.getAllWatches();
        model.addAttribute("watches", watches);
        return "listwatches";
    }
    @PostMapping("/lwatch")
    public String addWatch(@ModelAttribute("newWatch") Watch newWatch){
        watchService.addWatch(newWatch);
        return "redirect:/mobile/lwatch";}

    @PostMapping("/lwatch/{id}")
    public String deleteWatch(@PathVariable("id") Long wid) {
        watchService.deleteWatchById(wid);
        return "redirect:/mobile/lwatch";
    }
    @GetMapping("/lwatch/{id}")
    public String getWatchDetails(@PathVariable("id") Long wid, Model model){
        Watch watch = (Watch) watchService.getWatchById(wid);
        System.out.println(watchService.getWatchById(wid));
        model.addAttribute("watch", watch);
        return "watchdetails";
    }
    @GetMapping("/lwatch/{id}/edit")
    public String showWatchUpdateForm(@PathVariable("id") Long id, Model model) {
        Watch watch = (Watch) watchService.getWatchById(id);
        model.addAttribute("watch", watch);
        return "updatewatch"; // This should be the name of your HTML file for updating watch details
    }

    @PostMapping("/lwatch/{id}/update")
    public String updateWatch(@ModelAttribute("watch") Watch updatedWatch, @PathVariable("id") Long id) {
        updatedWatch.setWid(id); // Make sure to set the ID of the updated watch
        watchService.updateWatch(updatedWatch);
        return "redirect:/mobile/lwatch"; // Redirect to the details page of the updated watch
    }

}
