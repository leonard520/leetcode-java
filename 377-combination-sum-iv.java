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
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
	 public int combinationSum4(int[] nums, int target) {
		 if(nums == null || nums.length == 0) return 0;
		 if(target == 0) return 1;
		 int sum = 0;
		 for(int i = 0; i < nums.length; i++){
			 if(target >= nums[i]){
				 sum += combinationSum4(nums, target - nums[i]);
			 }
		 }
		 return sum;
	 }

	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};
	}
}
