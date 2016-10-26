package com.airhacks.plants.control;

import static org.hamcrest.CoreMatchers.containsString;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author airhacks.com
 */
public class MoistureSensorTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Rule
    public CustomRule custom = new CustomRule();

    private MoistureSensor cut;

    @Before
    public void init() {
        this.cut = new MoistureSensor();
    }

    @Test
    public void dangerous() {
        expected.expect(IllegalStateException.class);
        expected.expectMessage(containsString("friday"));
        this.cut.dangerous();
    }

}
