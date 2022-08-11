package com.tcv.hwelectrocasnice.repository;


import com.tcv.hwelectrocasnice.model.Appliance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ApplianceRepository extends JpaRepository<Appliance, Integer> {
    List<Appliance> findAll();

    @Modifying
    @Transactional
    @Query("UPDATE Appliance t set t.deleted = true WHERE t.id = :applianceId")
    void softDelete(Integer applianceId);
    @Modifying
    @Transactional
    @Query("UPDATE Appliance t set t.stock = t.stock+1 WHERE t.id = :applianceId")
    void incrementStock(Integer applianceId);
    @Modifying
    @Transactional
    @Query("UPDATE Appliance t set t.stock = t.stock-1 WHERE t.id = :applianceId")
    void decrementStock(Integer applianceId);
}
