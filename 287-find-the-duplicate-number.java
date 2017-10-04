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
	public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int slow = 0;
        int fast = 0;
        int finder = 0;
        while(true){
        	slow = nums[slow];
        	fast = nums[nums[fast]];
        	if(slow == fast){
        		break;
        	}
        }

    	while (true)
    	{
    		slow = nums[slow];
    		finder = nums[finder];
    		if (slow == finder)
    			return slow;
    	}
    }
	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};
		int nums[] = {2, 1, 3, 1};
		s.findDuplicate(nums);
	}
}
