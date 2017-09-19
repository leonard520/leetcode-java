package com.test.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
	public int maximumProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int min1, min2, min3;
        int max1, max2, max3;
        min1 = min2 = Integer.MAX_VALUE;
        max1 = max2 = max3 = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
        	if(nums[i] < min1){
        		min2 = min1;
        		min1 = nums[i];
        	} else if(nums[i] < min2){
        		min2 = nums[i];
        	}
        	if(nums[i] > max1){
        		max3 = max2;
        		max2 = max1;
        		max1 = nums[i];
        	} else if(nums[i] > max2){
        		max3 = max2;
        		max2 = nums[i];
        	} else if(nums[i] > max3){
        		max3 = nums[i];
        	}
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
	
	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};
		int []nums = {1,3,4};
		s.maximumProduct(nums);
		
	}
}
