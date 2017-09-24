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
	public void combinationSumInternal(int[] candidates, int target, List<Integer> l, List<List<Integer>> result, int i) {
		if(0 == target){
			result.add(new LinkedList<Integer>(l));
		} else if(target >= candidates[i]){
			int length = l.size();
			l.add(candidates[i]);
			combinationSumInternal(candidates, target - candidates[i], l, result, i);
			l.remove(length);
			if(i < candidates.length - 1){
				combinationSumInternal(candidates, target, l, result, i + 1);
			}
		}
	}
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> result = new LinkedList<List<Integer>>();
    	if(candidates == null || candidates.length == 0) return result;
    	List<Integer> l = new LinkedList<Integer>();
    	Arrays.sort(candidates);
    	combinationSumInternal(candidates, target, l, result, 0);
    	return result;
    }
	
	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};
		int []nums = {2, 3, 6, 7};
		s.combinationSum(nums,  7);

	}
}
