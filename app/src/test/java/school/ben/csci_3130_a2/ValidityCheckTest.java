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
    @Test
    public void hasSpecChar() throws Exception{
        assertFalse(test.hasSpecChar("abcdefgh"));
        assertTrue(test.hasSpecChar("@bc"));
    }
    @Test
    public void hasMixedCase() throws Exception{
        assertFalse(test.hasMixedCase("ABCD"));
        assertFalse(test.hasMixedCase("abcd"));
        assertTrue(test.hasMixedCase("aBc"));
    }
    @Test
    public void isNotCommon() throws Exception{
        String[] notOK = {"12345678","123456789","1234567890","qwertyuiop","1q2w3e4r",
                "abcd1234","zxcvbnm","football","baseball","letmeinplease" };
        for (String badPass:notOK) {
            assertFalse(test.isNotCommon(badPass));
        }
        assertTrue(test.isNotCommon("chicken"));
    }
}
