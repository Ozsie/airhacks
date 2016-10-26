/*
 */
package com.airhacks.log.boundary;

import static org.hamcrest.CoreMatchers.startsWith;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertThat;

/**
 *
 * @author adam-bien.com
 */
@RunAsClient
@RunWith(Arquillian.class)
public class AirhacksPageIT {

    @Drone
    private WebDriver browser;

    private final String PAGE_URL = "http://airhacks.com";

    @Test
    public void airhacksOpens() {
        browser.get(PAGE_URL);
        String title = browser.getTitle();
        assertThat(title, startsWith("Java EE"));
    }

}
