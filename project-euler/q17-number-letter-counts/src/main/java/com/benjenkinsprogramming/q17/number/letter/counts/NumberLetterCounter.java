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

package com.benjenkinsprogramming.q17.number.letter.counts;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.CharMatcher;
import com.google.common.base.MoreObjects;
import com.google.common.base.Stopwatch;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Project Euler problem: https://projecteuler.net/problem=17
 *
 * So there are two approaches that immediately come to mind:<br>
 * 1) Try to make a method that writes a number out as words. Use this method to brute force over
 * all of the words needed.
 * <p>
 * 2) Make a method that mathematically finds out how many times each word would be occur in a
 * range, ex. in the range of 1-100 "three" would appear 9 times.
 * <p>
 * The first approach seems like it would be easier to edit longterm, incase I ever wanted to make
 * adjustments (support all of the numbers to a billion). The second approach seems like it would
 * run faster.
 *
 * @author ben
 */
public class NumberLetterCounter {

  private static final int THOUSANDS_PLACE = 0;
  private static final int HUNDREDS_PLACE = 1;
  private static final int TENS_PLACE = 2;
  private static final int SINGLE_DIGIT_PLACE = 3;
  private static final DecimalFormat FOUR_DIGIT_FORMAT = new DecimalFormat("0000");

  public static void main(String[] args) {

    final Stopwatch stopwatch = Stopwatch.createStarted();

    int sumOfLetters = 0;
    for (int i = 1; i <= 1000; i++) {
      NumberLetterCounter numberLetterCounter = new NumberLetterCounter(i);
      System.out.println(numberLetterCounter);// Comment out for lightning fast computation
      sumOfLetters += numberLetterCounter.getWordsLength();
    }

    stopwatch.stop();
    System.out.println("Number of letters: " + sumOfLetters);
    System.out.println("Completed in: " + stopwatch);
  }

  private final int myNum;
  private final List<String> myWords;
  private final int myWordsLength;

  public NumberLetterCounter(final int aNum) {
    checkArgument(aNum >= 1, "Num must be greater than 0.");

    myNum = aNum;
    myWords = createWordsFromNumber(myNum);
    myWordsLength = lengthOfLettersInWords(myWords);
  }

  /**
   * <h3>Rules</h3>
   * Must use the word "and" when appropriate ex. (one hundred and fifteen)
   * <p>
   * <h3>Edge cases</h3>
   * Eleven, twelve, all of the teens
   */
  private static List<String> createWordsFromNumber(final int aNum) {
    final String numStr = FOUR_DIGIT_FORMAT.format(aNum);
    final List<String> words = new ArrayList<>();

    for (int currentPlace = THOUSANDS_PLACE; currentPlace <= SINGLE_DIGIT_PLACE; currentPlace++) {
      if (numStr.length() > currentPlace) {
        int singlePlacesDigit = numStr.charAt(SINGLE_DIGIT_PLACE) - '0';
        int currentDigit = numStr.charAt(currentPlace) - '0';

        if (currentDigit != 0) {
          if (currentPlace == THOUSANDS_PLACE) {
            words.add(getWordForNumByPlace(currentDigit, currentPlace, singlePlacesDigit));
            words.add("thousand");

          } else if (currentPlace == HUNDREDS_PLACE) {
            words.add(getWordForNumByPlace(currentDigit, currentPlace, singlePlacesDigit));
            words.add("hundred");

          } else if (currentPlace == TENS_PLACE) {
            if (!words.isEmpty()) {
              words.add("and");
            }

            StringBuilder wordBuilder = new StringBuilder();
            wordBuilder.append(getWordForNumByPlace(currentDigit, currentPlace, singlePlacesDigit));
            if (currentDigit != 1 && singlePlacesDigit != 0) {
              wordBuilder.append('-')
                .append(getWordForNumByPlace(singlePlacesDigit, SINGLE_DIGIT_PLACE,
                                             singlePlacesDigit));
            }

            words.add(wordBuilder.toString());
            currentPlace++;
          } else if (currentPlace == SINGLE_DIGIT_PLACE) {
            if (!words.isEmpty() && numStr.charAt(numStr.length() - 2) == '0') {
              words.add("and");
            }

            words.add(getWordForNumByPlace(currentDigit, currentPlace, singlePlacesDigit));
          }
        }
      }
    }

    return words;
  }

  private static String getWordForNumByPlace(int currentDigit, int currentPlace,
                                             int singlePlacesDigit) {
    checkArgument(currentDigit >= 0 && currentDigit <= 9, "Current digit needs to be between 0-9.");
    checkArgument(singlePlacesDigit >= 0 && singlePlacesDigit <= 9,
                  "The digit in the single place needs to be between 0-9.");

    if (currentPlace == TENS_PLACE) {
      // Get the the values between 10 and 19, since their names are so different
      if (currentDigit == 1) {
        if (singlePlacesDigit == 0) {
          return "ten";
        } else if (singlePlacesDigit == 1) {
          return "eleven";
        } else if (singlePlacesDigit == 2) {
          return "twelve";
        } else if (singlePlacesDigit == 3) {
          return "thirteen";
        } else if (singlePlacesDigit == 4) {
          return "fourteen";
        } else if (singlePlacesDigit == 5) {
          return "fifteen";
        } else if (singlePlacesDigit == 6) {
          return "sixteen";
        } else if (singlePlacesDigit == 7) {
          return "seventeen";
        } else if (singlePlacesDigit == 8) {
          return "eighteen";
        } else if (singlePlacesDigit == 9) {
          return "nineteen";
        }
      } // Get the names of the ten place words
      else if (currentDigit == 2) {
        return "twenty";
      } else if (currentDigit == 3) {
        return "thirty";
      } else if (currentDigit == 4) {
        return "forty";
      } else if (currentDigit == 5) {
        return "fifty";
      } else if (currentDigit == 6) {
        return "sixty";
      } else if (currentDigit == 7) {
        return "seventy";
      } else if (currentDigit == 8) {
        return "eighty";
      } else if (currentDigit == 9) {
        return "ninety";
      }
    } // Get the standard words for everything else.
    else if (currentDigit == 1) {
      return "one";
    } else if (currentDigit == 2) {
      return "two";
    } else if (currentDigit == 3) {
      return "three";
    } else if (currentDigit == 4) {
      return "four";
    } else if (currentDigit == 5) {
      return "five";
    } else if (currentDigit == 6) {
      return "six";
    } else if (currentDigit == 7) {
      return "seven";
    } else if (currentDigit == 8) {
      return "eight";
    } else if (currentDigit == 9) {
      return "nine";
    }

    // Return an empty string if the currentDigit is zero
    return "";
  }

  private static int lengthOfLettersInWords(final List<String> aWordList) {
    checkNotNull(aWordList);

    int sum = 0;
    for (final String word : aWordList) {
      String wordWithoutHyphens = CharMatcher.JAVA_LETTER.retainFrom(word);
      sum += wordWithoutHyphens.length();
    }
    return sum;
  }

  /**
   * @return the myNum
   */
  public int getNum() {
    return myNum;
  }

  /**
   * @return the myWords
   */
  public List<String> getWords() {
    return myWords;
  }

  /**
   * @return the myWordsLength
   */
  public int getWordsLength() {
    return myWordsLength;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(getClass())
      .add("myNum", myNum)
      .add("myWordsLength", myWordsLength)
      .add("myWords", myWords)
      .omitNullValues()
      .toString();
  }

}
