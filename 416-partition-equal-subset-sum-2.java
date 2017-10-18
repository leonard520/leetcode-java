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
	
	public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0){
        	return true;
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
        	sum += nums[i];
        }
        if(sum % 2 == 1) return false;
        sum /= 2;
        boolean [][]dp = new boolean[nums.length + 1][sum + 1];
        for(int i = 0; i <= nums.length; i++){
        	for(int j = 0; j <= sum; j++){
        		if(i == 0) {
        			dp[i][j] = false;
        		} else if(j == 0){
        			dp[i][j] = true;
        		} else {
        			dp[i][j] = dp[i - 1][j];
        			if(j >= nums[i - 1]){
            			dp[i][j] |= dp[i - 1][j - nums[i - 1]];
        			}
        		}
        	}
        }
        return dp[nums.length][sum];
    }
	
	public static void main(String args[]){
		Solution s = new Solution();
	}
}
