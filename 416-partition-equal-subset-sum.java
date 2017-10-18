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
	private boolean canPartitionInternal(int[] nums, int start, int target){
		if(target == 0) return true;
		boolean flag = false;
		for(int i = start; i < nums.length; i++){
			if(target >= nums[i]){
				flag |= canPartitionInternal(nums, i + 1, target - nums[i]);
				if(flag == true) return true;
			}
			flag |= canPartitionInternal(nums, i + 1, target);
			if(flag == true) return true;
		}
		return false;
	}
	public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0){
        	return true;
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
        	sum += nums[i];
        }
        if(sum % 2 == 1) return false;
        return canPartitionInternal(nums, 0, sum / 2);
    }
	
	public static void main(String args[]){
		Solution s = new Solution();
	}
}
