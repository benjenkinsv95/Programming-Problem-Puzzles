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

package com.benjenkinsprogramming.q12.highly.divisible.triangular.number;

/**
 * Solution for Project Euler question 12.
 * <a href="https://projecteuler.net/problem=12">Problem Description</a>.
 *
 * @author ben
 */
public class TriangleNumberDivisor {

  /**
   * Finds the first triangle number with over 500 divisors.
   *
   * @param args Unused
   */
  public static void main(String[] args) {
    final Long firstNumWithOver500Divisors = getFirstTriangleNumWithOverNDivisors(new Long(500));
    System.out.println("First triangle number with over 500 divisors: "
                         + firstNumWithOver500Divisors);
  }

  /**
   * Get the first number that has over {@code aNumOfDivisors} amount of divisors.
   *
   * @param aNumOfDivisors Any postitive number
   *
   * @return First number with over {@code aNumOfDivisors} of divisors.
   */
  public static Long getFirstTriangleNumWithOverNDivisors(Long aNumOfDivisors) {
    int triangle = 1;
    Long triangleNum = new Long(triangle);
    while (true) {
      TriangleNumberDivisor triangleNumberDivisor = new TriangleNumberDivisor(triangleNum);
      final Long numOfDivisors = triangleNumberDivisor.getNumOfDivisors();
      if (numOfDivisors.compareTo(aNumOfDivisors) > 0) {
        return triangleNum;
      } else {
        triangle++;
        triangleNum += triangle;
      }
    }
  }

  protected Long myNumValue;
  protected Long myNumOfDivisors;

  /**
   *
   * @param aNumValue Any positive number
   *
   * @throws IllegalArgumentException aNumValue should be greater than 0
   */
  public TriangleNumberDivisor(Long aNumValue) {
    if (aNumValue == null || aNumValue <= 0) {
      throw new IllegalArgumentException("aNumValue should be greater than 0");
    }

    myNumValue = aNumValue;
    myNumOfDivisors = null;
  }

  /**
   * Get the number of divisors {@code myNumValue} has.
   *
   * @return Number of divisore myNumValue has.
   */
  public Long getNumOfDivisors() {
    if (myNumOfDivisors != null) {
      return myNumOfDivisors;
    }
    myNumOfDivisors = new Long(0);
    Long squareRoot = (long) Math.floor(Math.sqrt(myNumValue));
    boolean perfectSquare = myNumValue == (squareRoot * squareRoot);
    for (long i = 1; i <= squareRoot; i++) {
      if (myNumValue % i == 0) {
        if (i == squareRoot && perfectSquare) {
          myNumOfDivisors++;
        } else {
          // Add one for the divisor, and the divisor on the other side of the square root
          myNumOfDivisors += 2;
        }
      }
    }
    return myNumOfDivisors;
  }

  @Override
  public String toString() {
    return "TriangleNumberDivisor{" + "myNumValue=" + myNumValue + ", myNumOfDivisors="
             + myNumOfDivisors + '}';
  }

}
