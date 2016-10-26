package com.airhacks.plants.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 *
 * @author airhacks.com
 */
@NamedQuery(name = "findByTemp", query = "SELECT b from Biosphere b where b.temperature = :temperature")
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

    public long getId() {
        return id;
    }

    public int getTemperature() {
        return temperature;
    }

    public String getState() {
        return state;
    }

}
