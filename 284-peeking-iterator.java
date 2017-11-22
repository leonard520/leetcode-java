package com.test.solution;

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
	private Integer current = null;
    private Iterator<Integer> iter;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
		iter = iterator;
		if(iter.hasNext()){
			current = iter.next();
		}
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return current;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		Integer i = current;
		current = iter.hasNext() ? iter.next() : null;
		return i;
	}

	@Override
	public boolean hasNext() {
	    return current == null ? false : true;
	}
}