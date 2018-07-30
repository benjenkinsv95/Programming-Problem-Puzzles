//
//  main.cpp
//  stack
//
//  Created by Ben J on 7/30/18.
//  Copyright © 2018 Ben Jenkins. All rights reserved.
//

#include <iostream>

#include "Queue.cpp"

void mergeSort(int nums[], int length) {
    if(length <= 1) {
        return;
    }
    
    int left[length / 2];
    int right[length / 2];
    for (int i = 0; i < length / 2; i++) {
        left[i] = nums[i];
    }
    for (int i = 0; i < length / 2; i++) {
        right[i] = nums[i + (length / 2)];
    }
    
    mergeSort(left, length / 2);
    mergeSort(right, length / 2);
    
    int leftIndex = 0;
    int rightIndex = 0;
    int numsIndex = 0;
    while(leftIndex < length / 2 || rightIndex < length / 2){
        if(leftIndex < length / 2 && rightIndex < length / 2){
            if (left[leftIndex] < right[rightIndex]) {
                nums[numsIndex] = left[leftIndex];
                leftIndex++;
            } else {
                nums[numsIndex] = right[rightIndex];
                rightIndex++;
            }
            numsIndex++;
        } else if (leftIndex < length / 2){
            nums[numsIndex] = left[leftIndex];
            leftIndex++;
            numsIndex++;
        } else {
            nums[numsIndex] = right[rightIndex];
            rightIndex++;
            numsIndex++;
        }
    }
    
}



int main(int argc, const char * argv[]) {
    Stack* stack = new Stack;
    stack->put(5);
    stack->put(3);
    
    Queue* queue = new Queue;
    queue->put(5);
    queue->put(3);
    
    
    
    std::cout << "Hello, World!\n";
    
    std::cout << "Stack: " << stack->pop() << " " << stack->pop() << std::endl;
    std::cout << "Queue: " << queue->pop() << " " << queue->pop() << std::endl;
    
    int nums[] = {1, 5 ,6 ,7, 8, 3, 2, 9, 4};
    for (int val : nums) {
        std::cout << val << " ";
    }
    std:: cout << std::endl;
    
    mergeSort(nums, 8);
    
    for (int val : nums) {
        std::cout << val << " ";
    }
    std:: cout << std::endl;
    
    return 0;
}


