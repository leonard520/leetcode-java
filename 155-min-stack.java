package com.test.solution;

import java.util.Stack;

class MinStack {

	private Stack s1;
	private Stack s2;
	
    /** initialize your data structure here. */
    public MinStack() {
        s1 = new Stack();
        s2 = new Stack();
    }
    
    public void push(int x) {
        s1.push(x);
        if(s2.isEmpty() || getMin() >= x){
        	s2.push(x);
        }
    }
    
    public void pop() {
        int top = (int) s1.pop();
        if(top == (int)s2.peek()){
        	s2.pop();
        }
    }
    
    public int top() {
    	return (int) s1.peek();
    }
    
    public int getMin() {
        return (int) s2.peek();
    }
}
