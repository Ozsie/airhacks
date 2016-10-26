/*
 */
package com.airhacks.log.boundary;

import static org.hamcrest.CoreMatchers.startsWith;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import static org.jboss.arquillian.graphene.Graphene.guardHttp;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author adam-bien.com
 */
@RunAsClient
@RunWith(Arquillian.class)
public class JSFWithoutDeploymentIT {

    private final String PAGE_URL = "http://localhost:8080/faces/index.xhtml";

    @Drone
    private WebDriver browser;

    @FindBy
    private WebElement name;
    @FindBy
    private WebElement output;
    @FindBy
    private WebElement save;

    @Test
    public void airhacksOpens() {
        browser.get(PAGE_URL);
        String title = browser.getTitle();
        assertThat(title, startsWith("HTML 5"));
        final String actual = "seems to work";
        name.sendKeys(actual);
        guardHttp(save).click();
        assertThat(output.getText(), is(actual));
    }

}
