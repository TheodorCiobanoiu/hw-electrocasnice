package com.tcv.hwelectrocasnice.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appliance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotNull
    String name;
    ApplianceType applianceType;
    Integer stock;
    boolean deleted;
}

/*
    {\"name\":\"Aragaz\", \"applianceType\":\"ELB\", \"stock\":\"10\"}

 */