//
//  Queue.cpp
//  stack
//
//  Created by Ben J on 7/30/18.
//  Copyright © 2018 Ben Jenkins. All rights reserved.
//

#include <stdio.h>
#include "Stack.cpp"

class Queue {
    Stack* inbox = new Stack;
    Stack* outbox = new Stack;
    
public:
    void put(int num) {
        inbox->put(num);
    }
    
    int pop() {
        if(outbox->isEmpty()) {
            while (!inbox->isEmpty()) {
                outbox->put(inbox->pop());
            }
        }
        
        return outbox->pop();
    }
    
    bool isEmpty() {
        return inbox->isEmpty() && outbox->isEmpty();
    }
};
