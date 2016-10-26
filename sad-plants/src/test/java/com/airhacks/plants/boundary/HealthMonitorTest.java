package com.airhacks.plants.boundary;

import com.airhacks.plants.control.MoistureSensor;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author airhacks.com
 */
public class HealthMonitorTest {

    private HealthMonitor cut;

    @Before
    public void init() {
        this.cut = new HealthMonitor();
        this.cut.ms = mock(MoistureSensor.class);
    }

    @Test
    public void healthy() {
        when(this.cut.ms.sufficientWaterAvailable()).thenReturn(true);
        String state = this.cut.state();
        assertThat(state, containsString("o.k."));
    }

    @Test
    public void unhealthy() {
        when(this.cut.ms.sufficientWaterAvailable()).thenReturn(false);
        String state = this.cut.state();
        assertThat(state, not(containsString("o.k.")));
    }

}
