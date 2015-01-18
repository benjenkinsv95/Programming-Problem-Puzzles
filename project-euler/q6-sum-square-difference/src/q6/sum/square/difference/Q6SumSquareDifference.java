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

package q6.sum.square.difference;

/**
 *
 * @author Ben Jenkins <benjenkinsv95@gmail.com>
 * Problem Description: "The sum of the squares of the first ten natural numbers is,
 * 12 + 22 + ... + 102 = 385
 * The square of the sum of the first ten natural numbers is,
 * 
 * (1 + 2 + ... + 10)2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum." 
 * https://projecteuler.net/problem=6 
 * Answer: 25,164,150
 */
public class Q6SumSquareDifference {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        long sum = 0;
        long sumOfSquares = 0;
        final long MAX_NATURAL_NUMBER = 100;
        
        for(int num = 1; num <= MAX_NATURAL_NUMBER; num++){
            sum += num;
            sumOfSquares += (num * num);
        }
        
        long sumSquareDifference = (sum * sum) - sumOfSquares;
        System.out.println("Sum Square Difference: " + sumSquareDifference);
    }

}
