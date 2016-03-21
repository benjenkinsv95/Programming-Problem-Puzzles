/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benjenkinsprogramming.q10.summation.of.primes;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ben
 */
public class PrimesTest {

    public PrimesTest() {
    }

    /**
     * Test of isPrime method, of class Primes.
     */
    @Test
    public void testIsPrimeCorrect() {
        System.out.println("isPrime");

        boolean expResult = true;
        long[] primes = {2, 3, 5, 7, 11, 13, 17};
        for (long prime : primes) {
            boolean result = Primes.isPrime(prime);
            Assert.assertEquals(expResult, result);
        }
    }

    /**
     * Test of isPrime method, of class Primes.
     */
    @Test
    public void testIsPrimeIncorrect() {
        System.out.println("isPrime");

        boolean expResult = false;
        long[] primes = {-1, 0, 1, 4, 6, 8, 9};
        for (long prime : primes) {
            boolean result = Primes.isPrime(prime);
            Assert.assertEquals(expResult, result);
        }
    }

    /**
     * Test of getListOfPrimes method, of class Primes.
     */
    @Test
    public void testGetListOfPrimes() {
        System.out.println("getListOfPrimes");

        List<Long> expResult = new ArrayList<>();
        expResult.add(new Long(2));
        expResult.add(new Long(3));
        expResult.add(new Long(5));
        expResult.add(new Long(7));
        List<Long> result = Primes.getListOfPrimes(2, 7);
        Assert.assertEquals(expResult, result);

        expResult.add(new Long(8));
        Assert.assertNotEquals(expResult, result);
    }

}
