package com.airhacks.plants.control;

import javax.ejb.Stateless;

/**
 *
 * @author airhacks.com
 */
@Stateless
public class MoistureSensor {

    public boolean sufficientWaterAvailable() {
        return false;
    }

    public void dangerous() {
        throw new IllegalStateException("its not friday");
    }

}
