/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.benjenkinsprogramming.q11.largest.product.in.a.grid;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author ben
 */
public class ProductsTest {

  @Test
  public void getProductTestCorrect() {

    int[] nums = {1, 2, 3, 4};
    int expProduct = 24;
    int product = Products.getProduct(nums);
    Assert.assertEquals(expProduct, product);

  }

  @Test
  public void getProductTestIncorrect() {

    int[] nums = {1, 2, 3, 4, 5};
    int expProduct = 99;
    int product = Products.getProduct(nums);
    Assert.assertNotEquals(expProduct, product);

  }
}
