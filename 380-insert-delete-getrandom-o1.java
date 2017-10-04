package com.test.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
	public class RandomizedSet {

		private List<Integer> list;
		private HashMap<Integer, Integer> map;
		
		/** Initialize your data structure here. */
	    public RandomizedSet() {
	        list = new ArrayList<Integer>();
	        map = new HashMap<Integer, Integer>();
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	    	if(map.containsKey(val) == true){
	    		return false;
	    	}
	    	map.put(val, list.size());
	        list.add(val);
	        return true;
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	        if(map.containsKey(val) == false){
	        	return false;
	        }
	        int index = map.get(val);
	        if(index < list.size() - 1){
	        	list.set(index, list.get(list.size() - 1));
	        	map.put(list.get(list.size() - 1), index);
	        	list.remove(list.size() - 1);
	        	map.remove(val);
	        } else {
	        	map.remove(val);
	        	list.remove(index);
	        }
	        return true;
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	    	Random rand = new java.util.Random();
	        return list.get(rand.nextInt(list.size()));
	    }
	}
    
	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};
	}
}
