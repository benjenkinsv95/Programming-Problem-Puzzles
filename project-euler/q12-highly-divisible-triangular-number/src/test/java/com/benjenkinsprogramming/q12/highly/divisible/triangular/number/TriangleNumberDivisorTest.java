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

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ben
 */
public class TriangleNumberDivisorTest {

  private static TriangleNumberDivisor theTriangleNumberDivisor;

  @BeforeClass
  public static void setUpClass() {
    Long num = new Long(28);
    theTriangleNumberDivisor = new TriangleNumberDivisor(num);
  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Test
  public void testGetNumOfDivisors() {
    Long numOfDivisors = theTriangleNumberDivisor.getNumOfDivisors();
    Long expectedNumOfDivisors = new Long(6);
    Assert.assertEquals(numOfDivisors, expectedNumOfDivisors);
  }

  /**
   * Test of getFirstTriangleNumWithOverNDivisors method, of class TriangleNumberDivisor.
   */
  @Test
  public void testGetFirstTriangleNumWithOverNDivisors() {
    System.out.println("getFirstNumWithNDivisors");
    Long aNumOfDivisors = new Long(3);
    Long expResult = new Long(6);
    Long result = TriangleNumberDivisor.getFirstTriangleNumWithOverNDivisors(aNumOfDivisors);
    Assert.assertEquals(expResult, result);
  }
}
