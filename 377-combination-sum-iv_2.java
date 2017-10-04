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
		 int []dp = new int[target + 1];
		 for(int i = 1; i <= target; i++){
			 for(int j = 0; j < nums.length; j++){
				 if(i >= nums[j]){
					 dp[i] += dp[i - nums[i]];
				 }
			 }
		 }
		 return dp[target];
	 }

	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};
	}
}
