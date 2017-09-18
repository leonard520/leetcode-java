package com.test.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public int findLengthOfLCIS(int[] nums) {
    	int max = 0;
    	int tmp = 1;
    	if(nums == null || nums.length == 0){
    		return 0;
    	}
        for(int i = 1; i < nums.length; i++){
        	if(nums[i] > nums[i - 1]){
        		tmp++;
        	} else {
        		max = max > tmp ? max:tmp;
        		tmp = 1;
        	}
        }
        max = max > tmp ? max:tmp;
        return max;
    }
	
	public static void main(String args[]){
		Solution s = new Solution();
		int []nums = {1,2,5,4,3};
		s.findLengthOfLCIS(nums);
		
	}
}
