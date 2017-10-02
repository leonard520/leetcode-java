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
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
        boolean []breakable = new boolean[s.length() + 1];
        breakable[0] = true;
        for(int i = 1; i <= s.length(); i++){
        	for(int j = 0; j < i; j++){
        		if(breakable[j] && wordDict.contains(s.substring(j, i))){
        			breakable[i] = true;
        		}
        	}
        }
        return breakable[s.length()];
    }
	
	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};
		String str = "leetcode";
		List<String> wordDict = new LinkedList<String>();
		wordDict.add("leet");
		wordDict.add("code");
		s.wordBreak(str, wordDict);
	}
}
