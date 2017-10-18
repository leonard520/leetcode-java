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
	public int countSubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++){
        	count += countSubstringsInternal(s, i, i);
        	count += countSubstringsInternal(s, i, i + 1);
        }
        return count;
    }
	
	private int countSubstringsInternal(String s, int start, int end){
		int count = 0;
		while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
			start--;
			end++;
			count++;
		}
		return count;
	}
    
	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};
	}
}
