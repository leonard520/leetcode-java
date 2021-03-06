package com.test.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
	public int findUnsortedSubarray(int[] nums) {
		int a = -1, b = -1;
		int min = nums[nums.length - 1], max = nums[0];
		for(int i = 1; i < nums.length; i++){
			max = Math.max(max, nums[i]);
			if(nums[i] < max) {
				b = i;
			}
			min = Math.min(min, nums[nums.length - i - 1]);
			if(nums[nums.length - i - 1] > min){
				a =  nums.length - i - 1;
			}
		}
		if(a == -1) return 0;
		return b - a + 1;
    }
	
	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};
		int []nums = {1,3,4};
		s.findUnsortedSubarray(nums);
		
	}
}
