package com.test.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
	final String three = "Fizz";
	final String five = "Buzz";
	
    public List<String> fizzBuzz(int n) {
        List<String> result = new LinkedList<String>();
        boolean flag = false;
        for(int i = 1; i <= n; i++){
        	flag = false;
        	StringBuilder temp = new StringBuilder();
        	if(i % 3 == 0){
        		temp.append(three);
        		flag = true;
        	}
        	if(i % 5 == 0){
        		temp.append(five);
        		flag = true;
        	}
        	if(flag == false){
        		temp.append(i);
        	}
        	result.add(temp.toString());
        }
        return result;
    }
}