//
//  Stack.cpp
//  stack
//
//  Created by Ben J on 7/30/18.
//  Copyright © 2018 Ben Jenkins. All rights reserved.
//

#include "Stack.hpp"

struct Node {
    struct Node* next = nullptr;
    int val;
};

class Stack {
    Node* top;
    
public:
    void put(int num) {
        Node* newTop = new Node;
        newTop->next = top;
        newTop->val = num;
        top = newTop;
    }
    
    int pop() {
        int poppedVal = top->val;
        top = top->next;
        return poppedVal;
    }
    
    bool isEmpty() {
        return top == nullptr;
    }
};
