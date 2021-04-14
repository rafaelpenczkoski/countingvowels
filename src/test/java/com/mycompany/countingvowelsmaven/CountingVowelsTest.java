/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.countingvowelsmaven;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Rafael Penczkoski
 */
public class CountingVowelsTest {
    
    @Test
    public void testIsVowel() {
        Character a = 'A';
        Character b = 'B';
        Assert.assertTrue(CountingVowels.isVowel(a));
        Assert.assertFalse(CountingVowels.isVowel(b));
    }

    @Test
    public void testStringClean() {
        String s = "-+^.:,";
        Assert.assertEquals("", CountingVowels.stringClean(s));
    }

    @Test
    public void testCountVowels() {
        String sample = "Platon made bamboo boats.";
        String result = "([a, e], 4) -> 2,0\n" +
                "([a, o], 5) -> 2,0\n" +
                "([a, o], 6) -> 2,5\n";
        Assert.assertEquals(result, CountingVowels.countVowels(sample));

        sample = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        result = "([a, e, i, o, u], 2) -> 1,2\n" +
                "([e, u, i, o], 3) -> 1,2\n" +
                "([a, e, i, u], 4) -> 1,9\n" +
                "([a, e, i, o, u], 5) -> 2,1\n" +
                "([a, e, i, o, u], 6) -> 2,8\n" +
                "([a, e, i, o, u], 7) -> 3,3\n" +
                "([a, e, i, o, u], 8) -> 3,5\n" +
                "([a, e, i, o, u], 9) -> 4,0\n" +
                "([a, u, i], 10) -> 4,0\n" +
                "([e, u, o], 11) -> 4,0\n" +
                "([a, e, i, o], 12) -> 6,0\n" +
                "([e, i], 13) -> 5,0\n";

        Assert.assertEquals(result, CountingVowels.countVowels(sample));
    }
    
    
}
