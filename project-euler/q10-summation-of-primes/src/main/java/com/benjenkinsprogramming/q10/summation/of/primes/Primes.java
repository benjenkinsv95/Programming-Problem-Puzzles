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

import java.util.ArrayList;
import java.util.List;

/**
 * This is a utility class for operating on prime numbers.
 *
 * @author ben
 */
public class Primes {

  /**
   * Start the iterator at 2 as anything less than 2 isn't prime. Since a prime number cannot have
   * factors outside of 1 and itself, we can stop looking for the prime number after the square
   * root, this is because the smaller number of a pair of factors would be found before the square
   * root of a number is passed.
   *
   * @param aNumber
   *
   * @return TODO fill
   */
  public static boolean isPrime(long aNumber) {
    double sqrtNumber = Math.sqrt(aNumber);
    for (int i = 2; i <= sqrtNumber; i++) {

      // If i is a factor of the number, return false, this is not prime
      if (aNumber % i == 0) {
        return false;
      }
    }

    // If the number is greater than 1, and has no factors besides 1 and itself, it is prime
    return aNumber > 1;
  }

  /**
   * Returns a list of all of the prime numbers between {@code aStartIndex} and {@code anEndIndex}.
   *
   * @param aStartIndex First number to include if prime
   * @param anEndIndex  Last number to include if prime
   *
   * @return prime list
   */
  public static List<Long> getListOfPrimes(final long aStartIndex,
                                           final long anEndIndex) {
    ArrayList<Long> primes = new ArrayList<>();
    for (long i = aStartIndex; i <= anEndIndex; i++) {
      if (isPrime(i)) {
        primes.add(i);
      }
    }
    return primes;
  }
}
