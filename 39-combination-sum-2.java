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
	public void combinationSumInternal(List<List<Integer>> result, List<Integer> list, int target, int[] candidates, int start){
		if(target == 0){
			result.add(new LinkedList<Integer>(list));
			return;
		}
		for(int i = start; i < candidates.length; i++){
			if(candidates[i] <= target){
				list.add(candidates[i]);
				combinationSumInternal(result, list, target - candidates[i], candidates, i);
				list.remove(list.size() - 1);
			}
		}
	}
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if(candidates == null || candidates.length == 0){
			return result;
		}
		combinationSumInternal(result, new LinkedList<Integer>(), target, candidates, 0);
		return result;
	}
	
	public static void main(String args[]){
		Solution s = new Solution();
		int target = 7;
		int []candidates = {2, 2, 3, 7};
		s.combinationSum(candidates, target);
	}
}
