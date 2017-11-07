package com.test.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {

	public int lengthOfLIS(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
        int []dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
        	dp[i] = 1;
        }
        for(int i = 1; i < nums.length; i++){
        	for(int j = 0; j < i; j++){
        		if(nums[i] > nums[j]){
        			dp[i] = Math.max(dp[j] + 1, dp[i]);
        		}
        	}
        }
        int max = 0;
        for(int i = 0; i < nums.length; i++){
        	max = Math.max(dp[i], max);
        }
        return max;
    }
}