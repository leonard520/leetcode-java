package com.test.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
	public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        if(target == nums[0]){
        	return 0;
        } else if(target < nums[0]){
        	int index = nums.length - 1;
        	int end = nums[index];
        	while(index > 0 && nums[index] >= target && end >= nums[index]){
        		if(nums[index] == target){
        			return index;
        		}
        		index--;
        	}
        	return -1;
        } else {
        	int index = 1;
        	int start = nums[0];
        	while(index < nums.length && start <= nums[index]){
        		if(nums[index] == target){
        			return index;
        		}
        		index++;
        	}
        	return -1;
        }
    }
	
	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};
		int []nums = {4,6,1,3};
		s.search(nums,  1);

	}
}
