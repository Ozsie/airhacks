package com.airhacks;

import javax.inject.Inject;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author airhacks.com
 */
@RunWith(CdiRunner.class)
public class InjectEmAllIT {

    @Inject
    Boundary boundary;

    @Test
    public void injection() {
        assertNotNull(boundary);
        assertThat(boundary.greeting(), is("perfect day"));
    }
}
