package com.airhacks.plants.control;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 *
 * @author airhacks.com
 */
public class CustomRule implements TestRule {

    @Override
    public Statement apply(Statement stmnt, Description d) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                System.out.println("Before kits test " + d.getTestClass());
                stmnt.evaluate();
            }
        };
    }

}
