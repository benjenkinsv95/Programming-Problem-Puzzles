/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.benjenkinsprogramming.q11.largest.product.in.a.grid;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ben
 */
public class LargestProductFinderTest {

  private static LargestProductFinder myLargestProductFinder;

  @BeforeClass
  public static void LargestProductFinderTest() {
    int[][] numberGrid = {{1, 2, 3, 4, 5},
                          {1, 2, 3, 4, 5},
                          {1, 2, 3, 4, 5},
                          {1, 2, 3, 4, 5},
                          {1, 2, 3, 4, 5}};
    myLargestProductFinder = new LargestProductFinder(numberGrid);
  }

  @Test
  public void testGetLargestProductInGrid() {

    int expResult = 625;// 5^4 is the largest product
    int result = myLargestProductFinder.getLargestProductInGrid(4);
    Assert.assertEquals(expResult, result);
  }

  @Test
  public void getLargestProductInGridTestIncorrect() {

    int expResult = 235;// 5^4 is the largest product
    int result = myLargestProductFinder.getLargestProductInGrid(4);
    Assert.assertNotEquals(expResult, result);
  }

  @Test
  public void getVerticalNumsArrTest() {

    final int[] expResult = {2, 2, 2, 2};
    final int[] result = myLargestProductFinder.getVerticalNumsArr(0, 1, 4);
    Assert.assertArrayEquals(expResult, result);
  }

  @Test
  public void getHorizontalNumsArrTest() {
    final int[] expResult = {1, 2, 3, 4};
    final int[] result = myLargestProductFinder.getHorizontalNumsArr(1, 0, 4);
    Assert.assertArrayEquals(expResult, result);
  }

  @Test
  public void getDownwardsDiagonalNumsArrTest() {
    final int[] expResult = {2, 3, 4, 5};
    final int[] result = myLargestProductFinder.getDownwardsDiagonalNums(1, 1, 4);
    Assert.assertArrayEquals(expResult, result);
  }

  @Test
  public void getUpwardsDiagonalNumsArrTest() {
    final int[] expResult = {1, 2, 3, 4};
    final int[] result = myLargestProductFinder.getUpwardsDiagonalNums(0, 0, 4);
    Assert.assertArrayEquals(expResult, result);
  }

  /**
   * Test of getLargestProductForRowAndCol method, of class LargestProductFinder.
   */
  @Test
  public void testGetLargestProductForRowAndCol() {
    System.out.println("getLargestProductForRowAndCol");
    int aRow = 0;
    int aCol = 0;
    int aProductLength = 3;
    int expResult = 6;
    int result = myLargestProductFinder.getLargestProductForRowAndCol(aRow, aCol, aProductLength);
    Assert.assertEquals(expResult, result);
  }

  /**
   * Test of colInRange method, of class LargestProductFinder.
   */
  @Test
  public void testColInRange() {
    System.out.println("colInRange");
    int aCol = 2;
    int aProductLength = 3;
    boolean expResult = true;
    boolean result = myLargestProductFinder.colInRange(aCol, aProductLength);
    Assert.assertEquals(expResult, result);
  }

  /**
   * Test of rowInRange method, of class LargestProductFinder.
   */
  @Test
  public void testRowInRange() {
    System.out.println("rowInRange");
    int aRow = 1;
    int aProductLength = 4;
    boolean expResult = true;
    boolean result = myLargestProductFinder.rowInRange(aRow, aProductLength);
    Assert.assertEquals(expResult, result);
  }

  /**
   * Test of getLargerProduct method, of class LargestProductFinder.
   */
  @Test
  public void testGetLargerProduct() {
    System.out.println("getLargerProduct");
    int[] aNumsList = {1, 2, 3};
    Integer aLargestProduct = new Integer(4);
    int expResult = 6;
    int result = myLargestProductFinder.getLargerProduct(aNumsList, aLargestProduct);
    Assert.assertEquals(expResult, result);
  }

  /**
   * Test of getVerticalNumsArr method, of class LargestProductFinder.
   */
  @Test
  public void testGetVerticalNumsArr() {
    System.out.println("getVerticalNumsArr");
    int aRow = 0;
    int aCol = 0;
    int aProductLength = 3;
    int[] expResult = {1, 1, 1};
    int[] result = myLargestProductFinder.getVerticalNumsArr(aRow, aCol, aProductLength);
    Assert.assertArrayEquals(expResult, result);
  }

  /**
   * Test of getHorizontalNumsArr method, of class LargestProductFinder.
   */
  @Test
  public void testGetHorizontalNumsArr() {
    System.out.println("getHorizontalNumsArr");
    int aRow = 0;
    int aCol = 0;
    int aProductLength = 3;
    int[] expResult = {1, 2, 3};
    int[] result = myLargestProductFinder.getHorizontalNumsArr(aRow, aCol, aProductLength);
    Assert.assertArrayEquals(expResult, result);
  }

  /**
   * Test of getDownwardsDiagonalNums method, of class LargestProductFinder.
   */
  @Test
  public void testGetDownwardsDiagonalNums() {
    System.out.println("getDownwardsDiagonalNums");
    int aRow = 0;
    int aCol = 1;
    int aProductLength = 4;
    int[] expResult = {2, 3, 4, 5};
    int[] result = myLargestProductFinder.getDownwardsDiagonalNums(aRow, aCol, aProductLength);
    Assert.assertArrayEquals(expResult, result);
  }

  /**
   * Test of getUpwardsDiagonalNums method, of class LargestProductFinder.
   */
  @Test
  public void testGetUpwardsDiagonalNums() {
    System.out.println("getUpwardsDiagonalNums");
    int aRow = 0;
    int aCol = 3;
    int aProductLength = 2;
    int[] expResult = {4, 5};
    int[] result = myLargestProductFinder.getUpwardsDiagonalNums(aRow, aCol, aProductLength);
    Assert.assertArrayEquals(expResult, result);
  }

}
