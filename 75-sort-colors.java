package com.test.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
	public void sortColors(int[] nums) {
		if(nums == null || nums.length == 0) return;
        int i = 0, j = 0;
        for(int k = 0; k < nums.length; k++){
        	int v = nums[k];
        	nums[k] = 2;
        	if(v < 2){
        		nums[j] = 1;
        		j += 1;
        	}
        	if(v < 1){
        		nums[i] = 0;
        		i += 1;
        	}
        }
    }
	
	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};
		int []nums = {0,2,1,1,2,0};
		s.sortColors(nums);
	}
}
