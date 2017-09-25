package com.test.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new LinkedList<List<String>>();
		if(strs == null || strs.length == 0) return result;
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		int[] PRIMES = new int[]{2, 3, 5, 7, 11 ,13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 107};
		for(int i = 0; i < strs.length; i++){
			int mapping = 1;
            for (int j = 0, max = strs[i].length(); j < max; j++) {
                mapping *= PRIMES[strs[i].charAt(j) - 'a'];
            }
            List<String> strings = map.get(mapping);
            if (strings == null) {
                strings = new LinkedList<>();
                map.put(mapping, strings);
            }
            strings.add(strs[i]);
		}
		for (List<String> mapList : map.values()){
            result.add(mapList);
        }
		return result;
    }
	
	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};

	}
}
