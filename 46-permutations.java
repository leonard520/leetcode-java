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
	public void permute(List<Integer> nums, List<Integer> l, List<List<Integer>> result) {
		if(nums.isEmpty()) result.add(new LinkedList<Integer>(l));
        for(int i = 0; i < nums.size(); i++){
        	int tmp = nums.get(i);
        	int length = l.size();
        	l.add(tmp);
        	nums.remove(i);
        	permute(nums, l, result);
        	l.remove(length);
        	nums.add(i, tmp);
        }
    }

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(nums == null || nums.length == 0) return result;
        List<Integer> list = new LinkedList<Integer>();
        for(int i = 0; i < nums.length; i++){
        	list.add(nums[i]);
        }
        permute(list, new LinkedList<Integer>(), result);
        return result;
    }
	
	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};
		int []nums = {2, 3, 6, 7};
		s.permute(nums);

	}
}
