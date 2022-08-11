package com.tcv.hwelectrocasnice.controller;

import com.tcv.hwelectrocasnice.model.Appliance;
import com.tcv.hwelectrocasnice.service.ApplianceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("appliance")
public class ApplianceController {

    private final ApplianceService applianceService;

    @GetMapping("all")
    public List<Appliance> getAllAppliances(){
        return applianceService.getAllExistentAppliances();
    }
    @GetMapping("absoluteAll")
    public List<Appliance> getAbsoluteAllAppliances(){
        return applianceService.getAllAppliances();
    }

    @PostMapping("save")
    public Appliance saveAppliance(@RequestBody Appliance appliance){
        return applianceService.saveAppliance(appliance);
    }

    @PostMapping("update-stock/{id}")
    public Appliance updateAppliance(@PathVariable Integer id){
        return applianceService.addStock(id);
    }

    @PostMapping("sell/{id}")
    public Appliance addAppliance(@PathVariable Integer id){
        return applianceService.sellAppliance(id);
    }

    @DeleteMapping("delete/{id}")
    public Appliance deleteAppliance(@PathVariable Integer id){
        return applianceService.softDelete(id);
    }

}
