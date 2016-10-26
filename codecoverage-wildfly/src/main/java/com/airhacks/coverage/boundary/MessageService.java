package com.airhacks.coverage.boundary;

import com.airhacks.coverage.control.Greeter;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author airhacks.com
 */
@Stateless
public class MessageService {

    @Inject
    Greeter greeter;

    public String goodMorning() {
        return greeter.greet();
    }

    public void untestedMethod() {
        System.out.println("Noone ever called me...");
    }

}
