package com.test.solution;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
	private Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
    	stack = new Stack<NestedInteger>();
        for(int i = nestedList.size() - 1; i >= 0; i--){
        	stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
    	return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
    	while(!stack.isEmpty()){
	    	NestedInteger item = stack.peek();
	    	if(item.isInteger()){
	    		return true;
	    	} else {
	    		NestedInteger l = stack.pop();
	    		for(int i = l.getList().size() - 1; i >= 0; i--){
	    			stack.push(l.getList().get(i));
	    		}
	    	}
    	}
    	return false;
    }
}