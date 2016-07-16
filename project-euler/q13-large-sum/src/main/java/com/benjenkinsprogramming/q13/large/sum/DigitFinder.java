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

package com.benjenkinsprogramming.q13.large.sum;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Charsets;
import com.google.common.base.Verify;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DigitFinder {

  /**
   * Load numbers from textfile. Numbers should be separated by newlines.
   *
   * @param aFilepath The textfile's filepath.
   *
   * @return A list of numbers.
   *
   * @throws IOException If fails to read file.
   */
  public static List<String> loadNumbers(final String aFilepath) throws
    IOException {
    checkNotNull(aFilepath, "Filepath cannot be null.");
    File file = new File(aFilepath);
    checkArgument(file.exists(), "Filepath \"%s\" must exist.", aFilepath);
    checkArgument(file.isFile(), "Filepath \"%s\" must lead to a file.",
                  aFilepath);

    String content = "";
    try {
      content = Files.toString(new File(aFilepath), Charsets.UTF_8);
    } catch (IOException ex) {
      throw new IOException("Failed to read file: \"" + aFilepath + "\"",
                            ex);
    }

    String[] lines = content.split("\n");
    return Arrays.asList(lines);
  }

  /**
   * Finds the answer to question 13.
   *
   * @param args No args used.
   */
  public static void main(String[] args) {
    List<String> numbersList = null;
    try {
      numbersList = loadNumbers("large-numbers.txt");
    } catch (IOException ex) {
      System.err.println("Could not load large numbers file!");
      ex.printStackTrace();
      System.exit(1);
    }

    DigitFinder digitFinder = new DigitFinder(numbersList);
    System.out.println("First " + 10 + " digits: " + digitFinder.findFirstNDigits(10));
  }

  private final List<String> myNumberList;

  /**
   *
   * @param aNumberList The list of numbers to find n digits on.
   */
  public DigitFinder(final List<String> aNumberList) {
    myNumberList = checkNotNull(aNumberList);
  }

  /**
   *
   * @param aNum How many digits to find the sum of.
   *
   * @return Finds the first n digits of the sum of the number list.
   */
  public String findFirstNDigits(final int aNum) {
    checkArgument(aNum >= 0,
                  "Cannot find first n digits, n(%s) was negative, n must be positive.",
                  aNum);

    long sum = getSumOfFirstNDigits(aNum + 2);
    String firstNDigits = Long.toString(sum).substring(0, aNum);
    return firstNDigits;
  }

  private long getSumOfFirstNDigits(final int aNum) {
    long sum = 0;

    for (String numberStr : myNumberList) {
      Verify.verify(myNumberList.size() >= aNum,
                    "Cannot get the first n digits of \"%s\", number has too few digits.",
                    numberStr);
      String beginningOfNumber = numberStr.substring(0, aNum);
      long beginningNumber = Long.parseLong(beginningOfNumber);
      sum += beginningNumber;
    }

    return sum;
  }

  /**
   * Get the number list.
   *
   * @return The number list
   */
  public List<String> getNumberList() {
    return myNumberList;
  }
}
