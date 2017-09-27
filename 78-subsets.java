package com.test.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
	public void subsetsInternal(List<Integer> nums, List<List<Integer>> result, List<Integer> list) {
		if(nums.size() == 0) {
			result.add(new LinkedList<Integer>(list));
			return;
		}
		int len = list.size();
		int tmp = nums.get(0);
		list.add(tmp);
		nums.remove(0);
		subsetsInternal(nums, result, list);
		list.remove(len);
		subsetsInternal(nums, result, list);
		nums.add(0, tmp);
	}
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(nums == null || nums.length == 0) return result;
        List<Integer> list = new LinkedList<Integer>();
        for(int i = 0; i < nums.length; i++){
                list.add(nums[i]);
        }
        subsetsInternal(list, result, new LinkedList<Integer>());
        return result;
    }
	
	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};
		int []nums = {1, 2, 3};
		s.subsets(nums);
	}
}
