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
	
	public int longestSubstring(String s, int k) {
        if(s == null || s.length() < k) return 0;
        int []map = new int[26];
        for(int i = 0; i < s.length(); i++){
        	map[s.charAt(i) - 'a']++;
        }
        int []map2 = new int[26];
        int start = 0;
        int max = 0;
        boolean flag = true;
        boolean flag2 = true;
        for(int i = 0; i < s.length(); i++){
        	if(map[s.charAt(i) - 'a'] < k){
        		for(int j = 0; j < 26; j++){
        			if(map2[j] != 0 && map2[j] < k){
        				flag = false;
        			}
        			map2[j] = 0;
        		}
        		if(flag == true){
        			max = Math.max(i - start, max);
        		} else {
        			max = Math.max(longestSubstring(s.substring(start, i), k), max);
        		}
        		start = i + 1;
        		flag = true;
        		flag2 = false;
        	} else {
        		map2[s.charAt(i) - 'a']++;
        		flag2 = true;
        	}
        }
        if(flag2 == true){
        	for(int j = 0; j < 26; j++){
    			if(map2[j] != 0 && map2[j] < k){
    				flag = false;
    			}
    			map2[j] = 0;
    		}
    		if(flag == true){
    			max = Math.max(s.length() - start, max);
    		} else {
    			max = Math.max(longestSubstring(s.substring(start, s.length()), k), max);
    		}
		}
        return max;
    }
	
	public static void main(String args[]){
		Solution s = new Solution();
		s.longestSubstring("aaabaeijvqqjeiiqlejitehqinnnnnwwkkowqokwqwerqwrebb", 2);
	}
}
