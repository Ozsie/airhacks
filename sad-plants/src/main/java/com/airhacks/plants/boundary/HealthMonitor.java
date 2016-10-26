package com.airhacks.plants.boundary;

import com.airhacks.plants.control.MoistureSensor;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author airhacks.com
 */
@Stateless
public class HealthMonitor {

    @Inject
    MoistureSensor ms;

    public String state() {
        if (this.ms.sufficientWaterAvailable()) {
            return "dry will die soon";
        }
        return "still o.k.";

    }

}
