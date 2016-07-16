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

package com.benjenkinsprogramming.q14.longest.collatz.sequence;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.base.Stopwatch;

import java.util.HashMap;
import java.util.Map;

/**
 * So my first idea is the brute force approach of running through every element and seeing which
 * element has the longest sequence.
 * <p>
 * That brute force solution *may* work, but would probably take a long time.
 * <p>
 * Some observations:
 * <ul>
 * <li>The sequence starts to terminate when a number is equal to any 2^n value.</li>
 * <li>I could make an array that is one million numbers long, and each time I hit a number I would
 * check it off, since its path can't be longer than the path it is currently in.</li>
 * <li>A map could also be used to store each index visited and the number of numbers it found.</li>
 * </ul>
 * <p>
 * Project Euler question 14: https://projecteuler.net/problem=14
 *
 * @author Ben
 */
public class CollatzRunner {

  public static void main(String[] args) {
    int maxNum = 1000000;
    CollatzRunner collatzRunner = new CollatzRunner(maxNum);

    final Stopwatch stopwatch = Stopwatch.createStarted();
    long highestStartingNum = collatzRunner.getStartingNumberWithLongestSequence();
    stopwatch.stop();

    System.out.println("Highest Collatz Number Under " + maxNum + ": " + highestStartingNum);
    System.out.println("Elapsed time ==> " + stopwatch);
  }

  private Map<Long, Integer> myCollatzIndexToSequenceLengthMap;
  private long myBestCollatzStartingNum;
  private int myEndIndexExclusive;

  /**
   * @param anEndIndexExclusive The index to stop searching at.
   */
  public CollatzRunner(int anEndIndexExclusive) {
    checkArgument(anEndIndexExclusive > 0, "Index should be greater than 0.");
    myEndIndexExclusive = anEndIndexExclusive;
    myCollatzIndexToSequenceLengthMap = new HashMap<>();
  }

  /**
   * Calculate the highest number using a brute force solution.
   *
   * @return Starting number with the longest sequence length.
   */
  public long getStartingNumberWithLongestSequence() {
    if (myCollatzIndexToSequenceLengthMap.isEmpty()) {
      calculateHighestBruteForceNumber();
    }

    return myBestCollatzStartingNum;
  }

  private void calculateHighestBruteForceNumber() {
    myBestCollatzStartingNum = 0;
    int maxSequenceLength = 0;
    for (long i = 1; i < myEndIndexExclusive; i++) {
      int sequenceLength = calculateBruteForceSequenceLength(i, i, 1);
      if (sequenceLength > maxSequenceLength) {
        myBestCollatzStartingNum = i;
        maxSequenceLength = sequenceLength;
      }

      if (!myCollatzIndexToSequenceLengthMap.containsKey(i)) {
        myCollatzIndexToSequenceLengthMap.put(i, sequenceLength);
      }
    }
  }

  private int calculateBruteForceSequenceLength(long aStartNum, long aCurrentNum,
                                                int aSequenceLength) {

    if (aCurrentNum == 1) {
      return aSequenceLength;

    } else if (myCollatzIndexToSequenceLengthMap.containsKey(aStartNum)) {
      return myCollatzIndexToSequenceLengthMap.get(aStartNum);

    } else if (myCollatzIndexToSequenceLengthMap.containsKey(aCurrentNum)) {
      return myCollatzIndexToSequenceLengthMap.get(aCurrentNum);

    } else {

      // Calculate sub number and store it if needed
      long subNum = isEven(aCurrentNum) ? aCurrentNum / 2 : (aCurrentNum * 3) + 1;
      int subLength = calculateBruteForceSequenceLength(aCurrentNum, subNum, 1);
      if (!myCollatzIndexToSequenceLengthMap.containsKey(subNum)) {
        myCollatzIndexToSequenceLengthMap.put(subNum, subLength);
      }

      return aSequenceLength + subLength;
    }
  }

  private static boolean isEven(long aNum) {
    return aNum % 2 == 0;
  }
}
