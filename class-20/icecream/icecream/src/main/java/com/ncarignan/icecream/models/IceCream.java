package com.ncarignan.icecream.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class IceCream {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public String flavor;

    public IceCream(){};
    public IceCream(String flavor){
        this.flavor = flavor;
    }
}
