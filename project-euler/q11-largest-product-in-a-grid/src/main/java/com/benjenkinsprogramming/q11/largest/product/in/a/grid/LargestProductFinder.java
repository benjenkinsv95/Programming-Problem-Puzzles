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

package com.benjenkinsprogramming.q11.largest.product.in.a.grid;

/**
 * Solution for Project Euler question 11.
 * <a href="https://projecteuler.net/problem=11">Problem Description</a>.
 *
 * @author ben
 */
public class LargestProductFinder {

  /**
   * Finds the largest product for the Project Euler question 11 grid.
   *
   * @param args Unused
   */
  public static void main(String[] args) {
    int[][] numberGrid = {{8, 2, 22, 97, 38, 15, 0, 40, 0, 75, 4, 5, 7, 78, 52, 12, 50, 77, 91, 8},
                          {49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 4, 56,
                           62, 0},
                          {81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 3, 49, 13,
                           36, 65},
                          {52, 70, 95, 23, 4, 60, 11, 42, 69, 24, 68, 56, 1, 32, 56, 71, 37, 2,
                           36, 91},
                          {22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33,
                           13, 80},
                          {24, 47, 32, 60, 99, 3, 45, 2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17,
                           12, 50},
                          {32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38,
                           64, 70},
                          {67, 26, 20, 68, 2, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49,
                           94, 21},
                          {24, 55, 58, 5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89,
                           63, 72},
                          {21, 36, 23, 9, 75, 0, 76, 44, 20, 45, 35, 14, 0, 61, 33, 97, 34, 31,
                           33, 95},
                          {78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 3, 80, 4, 62, 16, 14, 9, 53,
                           56, 92},
                          {16, 39, 5, 42, 96, 35, 31, 47, 55, 58, 88, 24, 0, 17, 54, 24, 36, 29,
                           85, 57},
                          {86, 56, 0, 48, 35, 71, 89, 7, 5, 44, 44, 37, 44, 60, 21, 58, 51, 54,
                           17, 58},
                          {19, 80, 81, 68, 5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 4, 89,
                           55, 40},
                          {4, 52, 8, 83, 97, 35, 99, 16, 7, 97, 57, 32, 16, 26, 26, 79, 33, 27,
                           98, 66},
                          {88, 36, 68, 87, 57, 62, 20, 72, 3, 46, 33, 67, 46, 55, 12, 32, 63, 93,
                           53, 69},
                          {4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62,
                           76, 36},
                          {20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 4,
                           36, 16},
                          {20, 73, 35, 29, 78, 31, 90, 1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57,
                           5, 54},
                          {1, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 1, 89, 19,
                           67, 48}};

    LargestProductFinder largestProductFinder = new LargestProductFinder(numberGrid);
    final int largestProductInGrid = largestProductFinder.getLargestProductInGrid(4);
    System.out.println("Largest product in grid: " + largestProductInGrid);
  }

  private int[][] myNumberGrid;

  public LargestProductFinder(final int[][] aNumberGrid) {
    myNumberGrid = aNumberGrid;
  }

  /**
   * Will find the largest product of {@code aProductLength} numbers in a number grid. Will check
   * horizontally, vertically, and diagonally.
   *
   * @param aProductLength How many numbers in a row to get the product of
   *
   * @return The largest product in the grid
   *
   * @throws IllegalArgumentException If {@code aProductLength} is longer than the height and width
   *                                  of the number grid.
   */
  public int getLargestProductInGrid(int aProductLength) {
    int largestProduct = getLargestProductForRowAndCol(0, 0, aProductLength);

    for (int row = 0; row < myNumberGrid.length; row++) {
      for (int col = 0; col < myNumberGrid[0].length; col++) {
        if (rowInRange(row, aProductLength) || colInRange(col, aProductLength)) {
          largestProduct = Math.max(largestProduct, getLargestProductForRowAndCol(row,
                                                                                  col,
                                                                                  aProductLength));
        }
      }
    }
    return largestProduct;
  }

  /**
   * Will find the largest product of {@code aProductLength} numbers at row and col in the number
   * grid. Will check horizontally, vertically, and diagonally.
   *
   * @param aRow           A row in the number grid.
   * @param aCol           A col in the number grid.
   * @param aProductLength How many numbers in a row to get the product of
   *
   * @return The largest product in the grid
   *
   * @throws IllegalArgumentException If {@code aProductLength} is longer than the height and width
   *                                  of the number grid.
   */
  int getLargestProductForRowAndCol(final int aRow, final int aCol, final int aProductLength) {
    Integer newLargestProduct = null;
    if (rowInRange(aRow, aProductLength)) {
      final int[] verticalNumsArr = getVerticalNumsArr(aRow, aCol, aProductLength);
      newLargestProduct = getLargerProduct(verticalNumsArr, newLargestProduct);
    }

    if (colInRange(aCol, aProductLength)) {
      final int[] horizontalNumsArr = getHorizontalNumsArr(aRow, aCol, aProductLength);
      newLargestProduct = getLargerProduct(horizontalNumsArr, newLargestProduct);
    }

    if (rowInRange(aRow, aProductLength) && colInRange(aCol, aProductLength)) {
      final int[] downwardsDiagonalNums = getDownwardsDiagonalNums(aRow, aCol, aProductLength);
      newLargestProduct = getLargerProduct(downwardsDiagonalNums, newLargestProduct);

      final int[] upwardsDiagonalNums = getUpwardsDiagonalNums(aRow, aCol, aProductLength);
      newLargestProduct = getLargerProduct(upwardsDiagonalNums, newLargestProduct);
    }
    return newLargestProduct;
  }

  /**
   * Bounds checking the column.
   *
   * @param aCol           The current column
   * @param aProductLength The number of numbers in a row to calculate the product
   *
   * @return If the column is within bounds.
   */
  boolean colInRange(int aCol, int aProductLength) {
    return aCol >= 0 && aCol <= myNumberGrid[0].length - aProductLength;
  }

  /**
   * Bounds checking the row.
   *
   * @param aRow           The current row.
   * @param aProductLength The number of numbers in a col to calculate the product
   *
   * @return If the row is within bounds.
   */
  boolean rowInRange(int aRow, int aProductLength) {
    return aRow >= 0 && aRow <= myNumberGrid.length - aProductLength;
  }

  /**
   * Returns the larger product between the product of {@code aNumsList} and @{code
   * aLargestProduct}.
   *
   * @param aNumsList       A valid list of nums to get the product of.
   * @param aLargestProduct The largest product that exists so far or {@code null}.
   *
   * @return The largest product. If {@code aLargestProduct} is {@code null} then the product of
   *         {@code aNumsList} will be returned.
   */
  int getLargerProduct(final int[] aNumsList, final Integer aLargestProduct) {
    if (aLargestProduct == null) {
      return Products.getProduct(aNumsList);
    }

    return Math.max(aLargestProduct, Products.getProduct(aNumsList));
  }

  /**
   * Get an array of nums starting at {@code aRow} and {@code aCol} and continuing downwards.
   *
   * @param aRow           A row in the number grid.
   * @param aCol           A col in the number grid.
   * @param aProductLength The number of numbers in a col to calculate the product
   *
   * @return An array of nums.
   */
  int[] getVerticalNumsArr(final int aRow, final int aCol, final int aProductLength) {
    int[] numsArr = new int[aProductLength];
    for (int i = 0; i < aProductLength; i++) {
      numsArr[i] = myNumberGrid[aRow + i][aCol];
    }
    return numsArr;
  }

  /**
   * Get an array of nums starting at {@code aRow} and {@code aCol} and continuing from left to
   * right.
   *
   * @param aRow           A row in the number grid.
   * @param aCol           A col in the number grid.
   * @param aProductLength The number of numbers in a col to calculate the product
   *
   * @return An array of nums.
   */
  int[] getHorizontalNumsArr(final int aRow, final int aCol, final int aProductLength) {
    int[] numsArr = new int[aProductLength];
    for (int i = 0; i < aProductLength; i++) {
      numsArr[i] = myNumberGrid[aRow][aCol + i];
    }
    return numsArr;
  }

  /**
   * Get an array of nums starting at {@code aRow} and {@code aCol} and continuing downw-right.
   *
   * @param aRow           A row in the number grid.
   * @param aCol           A col in the number grid.
   * @param aProductLength The number of numbers in a col to calculate the product
   *
   * @return An array of nums.
   */
  int[] getDownwardsDiagonalNums(final int aRow, final int aCol, final int aProductLength) {
    int[] numsArr = new int[aProductLength];
    for (int i = 0; i < aProductLength; i++) {
      numsArr[i] = myNumberGrid[aRow + i][aCol + i];
    }
    return numsArr;
  }

  /**
   * Get an array of nums starting at {@code aRow - aProductLength + 1} and {@code aCol} and
   * continuing up-left.
   *
   * @param aRow           A row in the number grid.
   * @param aCol           A col in the number grid.
   * @param aProductLength The number of numbers in a col to calculate the product
   *
   * @return An array of nums.
   */
  int[] getUpwardsDiagonalNums(final int aRow, final int aCol, final int aProductLength) {
    int[] numsArr = new int[aProductLength];
    for (int i = 0; i < aProductLength; i++) {
      int reverseI = aProductLength - i - 1;
      numsArr[i] = myNumberGrid[aRow + reverseI][aCol + i];
    }
    return numsArr;
  }

}
