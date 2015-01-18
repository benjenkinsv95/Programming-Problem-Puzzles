/*
 * Copyright 2015 Ben Jenkins <benjenkinsv95@gmail.com>.
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
package q5.smallest.multiple;

/**
 *
 * @author Ben Jenkins <benjenkinsv95@gmail.com>
 * Problem Description: "2520 is the smallest number that can be divided by each
 * of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the
 * numbers from 1 to 20?" https://projecteuler.net/problem=5 
 * Answer: 232,792,560
 */
public class Q5SmallestMultiple {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        boolean solved = false;
        long smallestMultiple = -1;

        long i = 1;
        // While not solved and i has not overflown
        while (!solved && i >= 0) {

            if (isEvenDivisibleUpTo20(i)) {
                solved = true;
                smallestMultiple = i;
            }
            i++;
        }

        System.out.println("Smallest multiple is: " + smallestMultiple);
    }

    public static boolean isEvenDivisibleUpTo20(long num) {
        
        for (int i = 11; i <= 20; i++) {
            if (num % i != 0) {
                return false;
            }
        }
        return true;
    }

}
