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

public class TriangleNumberDivisor {

  private static int UNINITIALIZED = -1;

  public static void main(String[] args) {
    final long firstNumWithOver500Divisors = getFirstTriangleNumWithOverNDivisors(500);
    System.out.println("First triangle number with over 500 divisors: "
                       + firstNumWithOver500Divisors);
  }

  public static long getFirstTriangleNumWithOverNDivisors(long aNumOfDivisors) {
    int triangle = 1;
    long triangleNum = triangle;
    while (true) {
      TriangleNumberDivisor triangleNumberDivisor = new TriangleNumberDivisor(triangleNum);
      final long numOfDivisors = triangleNumberDivisor.getNumOfDivisors();
      if (numOfDivisors > aNumOfDivisors) {
        return triangleNum;
      } else {
        triangle++;
        triangleNum += triangle;
      }
    }
  }

  protected long myNumValue;

  protected long myNumOfDivisors;

  public TriangleNumberDivisor(long aNumValue) {
    if (aNumValue <= 0) {
      throw new IllegalArgumentException("aNumValue should be greater than 0");
    }
    myNumValue = aNumValue;
    myNumOfDivisors = UNINITIALIZED;
  }

  public long getNumOfDivisors() {
    if (myNumOfDivisors != UNINITIALIZED) {
      return myNumOfDivisors;
    }
    myNumOfDivisors = 0;
    long squareRoot = (long) Math.floor(Math.sqrt(myNumValue));
    boolean perfectSquare = myNumValue == (squareRoot * squareRoot);
    for (long i = 1; i <= squareRoot; i++) {
      if (myNumValue % i == 0) {
        if (i == squareRoot && perfectSquare) {
          myNumOfDivisors++;
        } else {
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
