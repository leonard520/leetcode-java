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
	private void partitionInternal(List<List<String>> result, List<String> list, String s, int low, int high){
		if(low == high + 1){
			result.add(new LinkedList<String>(list));
			return;
		}
		for(int i = low; i <= high; i++){
			if(isPalindrome(s, low, i) == true){
				list.add(s.substring(low, i + 1));
				partitionInternal(result, list, s, i + 1, high);
				list.remove(list.size() - 1);
			}
		}
	}
	public List<List<String>> partition(String s) {
		List<List<String>> result = new LinkedList<List<String>>();
        if(s == null || s.length() == 0){
        	return result;
        }
        partitionInternal(result, new LinkedList<String>(), s, 0, s.length() - 1);
        return result;
    }
	
	private boolean isPalindrome(String s, int low, int high){
		while(low < high){
			if(s.charAt(low) == s.charAt(high)){
				low++;
				high--;
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String args[]){
		Solution s = new Solution();
		String str = "aab";
		s.partition(str);
	}
}
