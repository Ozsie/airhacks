package com.airhacks.graphene;

import javax.enterprise.inject.Model;

/**
 *
 * @author airhacks.com
 */
@Model
public class Index {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object save() {
        System.out.println("name = " + name);
        return null;
    }

}
