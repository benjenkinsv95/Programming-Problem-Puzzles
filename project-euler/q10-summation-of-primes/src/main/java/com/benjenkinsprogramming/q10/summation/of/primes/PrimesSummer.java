/*
 * Copyright 2016 Ben Jenkins <benjenkinsv95@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.benjenkinsprogramming.q10.summation.of.primes;

import java.math.BigInteger;
import java.util.List;

/**
 * Solution for Project Euler question 10.
 * <a href="https://projecteuler.net/problem=10">Problem Description</a>.
 *
 * @author ben
 */
public class PrimesSummer {

  public static void main(String[] args) {
    final List<Long> primesList = Primes.getListOfPrimes(2, 1999999);

    final BigInteger sumPrimes = sumNumberList(primesList);
    System.out.println("The sum of primes below 2,000,000: " + sumPrimes);
  }

  /**
   * Sums a list of numbers and returns the sum as a BigInteger.
   *
   * @param aNumberList The list of numbers to be summed
   *
   * @return The sum of the numbers in aNumberList
   */
  public static BigInteger sumNumberList(List<Long> aNumberList) {
    BigInteger sum = new BigInteger("0");
    for (Number number : aNumberList) {
      BigInteger numberBigInteger = new BigInteger(number.toString());
      sum = sum.add(numberBigInteger);
    }
    return sum;
  }
}
