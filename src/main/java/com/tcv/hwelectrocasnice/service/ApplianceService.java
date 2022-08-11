package com.tcv.hwelectrocasnice.service;

import com.tcv.hwelectrocasnice.model.Appliance;
import com.tcv.hwelectrocasnice.repository.ApplianceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplianceService {

    private final ApplianceRepository applianceRepository;

    public Appliance saveAppliance(Appliance appliance) {
        return applianceRepository.save(appliance);
    }

    public Appliance softDelete(Integer applianceId) {
        applianceRepository.softDelete(applianceId);
        if (applianceRepository.findById(applianceId).isPresent()) {
            return applianceRepository.findById(applianceId).get();
        }
        return null;
    }

    public List<Appliance> getAllAppliances() {
        return applianceRepository.findAll();
    }

    public List<Appliance> getAllExistentAppliances() {
        return applianceRepository.findAll().stream()
                .filter(appliance -> !appliance.isDeleted())
                .collect(Collectors.toList());
    }

    public Appliance sellAppliance(Integer applianceId) {
        Optional<Appliance> applianceOptional = applianceRepository.findById(applianceId);
        if (!applianceOptional.isPresent()) {
            return null;
        }
        if (applianceOptional.get().getStock() == 0) {
            return applianceOptional.get();
        } else {
            applianceRepository.decrementStock(applianceId);
            Integer stock = applianceOptional.get().getStock() - 1;
            applianceOptional.get().setStock(stock);
            return applianceOptional.get();
        }
    }

    //    This is a 2 in 1 method. It adds a new appliance, or it updates the stock for a new appliance.
//    The difference is only in the path used and the Json body given.
    public Appliance addStock(Integer id) {
        Optional<Appliance> applianceOptional = applianceRepository.findById(id);
        Integer stock = applianceOptional.get().getStock() + 1;
        applianceRepository.incrementStock(id);
        applianceOptional.get().setStock(stock);
        return applianceOptional.get();
    }


}
