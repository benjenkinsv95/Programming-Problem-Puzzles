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
 * A utility class for mathematical products.
 *
 * @author ben
 */
public class Products {

  /**
   * Returns the product of all of the nums in the passed in aNumsArr.
   *
   * @param aNumsArr An array of numbers
   *
   * @return The product
   */
  public static int getProduct(final int[] aNumsArr) {
    if (aNumsArr == null || aNumsArr.length == 0) {
      throw new IllegalArgumentException("Array is null or empty.");
    }
    int product = aNumsArr[0];
    for (int i = 1; i < aNumsArr.length; i++) {
      product *= aNumsArr[i];
    }
    return product;
  }

}
