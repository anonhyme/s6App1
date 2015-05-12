package org.anonhyme.client;

import com.google.gwt.junit.client.GWTTestCase;

public class SandboxGwtTest extends GWTTestCase {
    @Override
    public String getModuleName() {
        return "org.anonhyme.Project";
    }

    public void testSandbox() {
        assertTrue(true);
    }
}
