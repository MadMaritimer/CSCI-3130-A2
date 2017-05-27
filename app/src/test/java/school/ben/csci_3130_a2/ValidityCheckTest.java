package school.ben.csci_3130_a2;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Created by Ben on 2017-05-27.
 * Assignment 2 - Software Engineering
 */
public class ValidityCheckTest {
    private MainActivity test = new MainActivity();
    @Test
    public void notPassword() throws Exception {
        assertFalse(test.notPassword("password"));
        assertFalse(test.notPassword("PASSWORD"));
        assertFalse(test.notPassword("PaSsWoRd"));
        assertTrue(test.notPassword("Chicken"));
    }
    @Test
    public void longEnough() throws Exception{
        assertFalse(test.longEnough("a"));
        assertFalse(test.longEnough("1234567"));
        assertTrue(test.longEnough("12345678"));
    }
}
