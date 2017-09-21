package com.test.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
	private boolean check(int hash[]){
		for(int i = 0; i < 26; i++){
			if(hash[i] != 0) return false;
		}
		return true;
	}
	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<Integer>();
		if(s.length() < p.length()) return result;
        int []hash = new int[26];
        for(int i = 0; i < 26; i++){
        	hash[i] = 0;
        }
        int len = p.length();
        for(int i = 0; i < len; i++){
        	hash[p.charAt(i) - 'a'] += 1;
        	hash[s.charAt(i) - 'a'] -= 1;
        }
        if(check(hash) == true){
    		result.add(0);
    	}
        for(int i = len; i < s.length(); i++){
        	hash[s.charAt(i) - 'a']--;
        	hash[s.charAt(i - len) - 'a']++;
        	if(check(hash) == true){
        		result.add(i - len + 1);
        	}
        }
        return result;
    }
	
	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};
		
		
	}
}
