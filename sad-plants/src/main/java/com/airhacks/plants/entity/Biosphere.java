package com.airhacks.plants.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author airhacks.com
 */
@Entity
public class Biosphere {

    @Id
    @GeneratedValue
    private long id;
    private int temperature;
    private String state;

    public Biosphere(int temperature, String state) {
        this.temperature = temperature;
        this.state = state;
    }

    public Biosphere() {
    }

}
