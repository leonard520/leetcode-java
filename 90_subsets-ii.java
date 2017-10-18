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
	public void subsetsInternal(int[] nums, List<List<Integer>> result, List<Integer> list, int start) {
		result.add(new LinkedList<Integer>(list));
		
		for(int i = start; i < nums.length; i++){
			if(i > start && nums[i] == nums[i-1]) continue;
			list.add(nums[i]);
			subsetsInternal(nums, result, list, i + 1);
			list.remove(list.size() - 1);
		}
	}
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if(nums == null || nums.length == 0){
			return result;
		}
		Arrays.sort(nums);
		subsetsInternal(nums, result, new LinkedList<Integer>(), 0);
		return result;
	}
}
