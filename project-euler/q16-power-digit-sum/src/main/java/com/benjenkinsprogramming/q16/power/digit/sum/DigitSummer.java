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

package com.benjenkinsprogramming.q16.power.digit.sum;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Stopwatch;

import java.math.BigInteger;

/**
 *
 * @author ben
 */
public class DigitSummer {

  /**
   * Lazy construction of this number. If this value was actually needed it should probably be
   * stored, not calculated.
   */
  public static final String TWO_TO_THE_POWER_OF_ONE_THOUSAND;

  static {
    BigInteger sum = BigInteger.valueOf(2);
    for (int i = 2; i <= 1000; i++) {
      sum = sum.multiply(BigInteger.valueOf(2));
    }

    TWO_TO_THE_POWER_OF_ONE_THOUSAND = sum.toString();
  }

  public static void main(String[] args) {

    final Stopwatch stopwatch = Stopwatch.createStarted();
    long sum = getSumOfDigitsInNumber(TWO_TO_THE_POWER_OF_ONE_THOUSAND);
    stopwatch.stop();

    System.out.println("Sum: " + sum);
    System.out.println("Elapsed time: " + stopwatch);
  }

  /**
   * @param aNumberString A number
   *
   * @return The sum of every digit in a number
   */
  private static long getSumOfDigitsInNumber(String aNumberString) {
    checkNotNull(aNumberString);

    long sum = 0;
    for (int i = 0; i < aNumberString.length(); i++) {
      int digit = aNumberString.charAt(i) - '0';
      sum += digit;
    }
    return sum;
  }

}
