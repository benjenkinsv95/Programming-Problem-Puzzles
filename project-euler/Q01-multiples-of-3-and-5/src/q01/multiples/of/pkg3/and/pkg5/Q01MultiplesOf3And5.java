/*
 * Copyright 2015 Ben.
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

package q01.multiples.of.pkg3.and.pkg5;

/**
 *
 * @author Ben Jenkins <benjenkinsv95@gmail.com>
 * Problem Description: "If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000."
 * Problem Link: https://projecteuler.net/problem=1
 * Answer: 233,168
 */
public class Q01MultiplesOf3And5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int sum = 0;
        int maxNumber = 1000;
        
        // List all natural numbers between below 1000
        for(int i = 1; i < maxNumber; i++){
            
            // If multiple of 3 or 5
            if(i % 3 == 0 || i % 5 == 0){
                sum += i;
            }
        }
        
        System.out.println("The sum of all multiples of 3 or 5 below " + maxNumber + ": " + sum);
    }

}
