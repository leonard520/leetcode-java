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
	
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
       Map<Integer, Integer> map = new HashMap<Integer, Integer>();
       int result = 0;
       for(int i = 0; i < A.length; i++){
    	   for(int j = 0; j < B.length; j++){
    		   int sum = A[i] + B[j];
    		   map.put(sum, map.getOrDefault(sum, 0) + 1);
    	   }
       }
       for(int i = 0; i < C.length; i++){
    	   for(int j = 0; j < D.length; j++){
    		   int sum = C[i] + D[j];
    		   result += map.getOrDefault(-1 * sum, 0);
    	   }
       }
       return result;
    }
	
	public static void main(String args[]){
		Solution s = new Solution();
	}
}
