/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.benjenkinsprogramming.q10.summation.of.primes;

import java.math.BigInteger;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ben
 */
public class PrimesSummerTest {

  /**
   * Test of sumPromes method, of class PrimesSummer.
   */
  @Test
  public void testSumPrimesCorrect() {

    List<Long> primes = Primes.getListOfPrimes(2, 5); // 2, 3, and 5
    final BigInteger expectedSum = new BigInteger("10");

    final BigInteger sumPrimes = PrimesSummer.sumNumberList(primes);
    Assert.assertEquals(expectedSum, sumPrimes);

  }

  /**
   * Test of sumPromes method, of class PrimesSummer.
   */
  @Test
  public void testSumPrimesIncorrect() {

    List<Long> primes = Primes.getListOfPrimes(3, 7); // 3, 5, and 7
    final BigInteger unexpectedSum = new BigInteger("13");

    final BigInteger sumPrimes = PrimesSummer.sumNumberList(primes);
    Assert.assertNotEquals(unexpectedSum, sumPrimes);
  }
}
