package com.extts.TransitApp.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.extts.TransitApp.model.Bus;
import com.extts.TransitApp.model.BusRequest;
import com.extts.TransitApp.model.Location;
import com.extts.TransitApp.service.TransitService;

@Controller
public class TransitController {
    @Autowired
    private TransitService apiService;
	
    @GetMapping("/buses")
    public String getBusesPage(Model model){
        model.addAttribute("request", new BusRequest());
        return "index";
    }
	
    @PostMapping("/buses")
    public String getNearbyBuses(BusRequest request, Model model) {
        List<Bus> buses = apiService.getNearbyBuses(request);
        model.addAttribute("buses", buses);
        model.addAttribute("request", request);
        Location personLocation = apiService.getPersonLocation(request); 
        model.addAttribute("personLocation", personLocation);
        return "index";
    }
}