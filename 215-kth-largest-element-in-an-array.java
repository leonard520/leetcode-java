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
	public int quickSelect(int[] nums, int start, int end, int k){
		int tmp = nums[start];
		int i = start, j = end;
		while(i < j){
			while(i <= j && nums[i] <= tmp) i++;
			while(j >= i && nums[j] > tmp) j--;
			if(i < j) swap(nums, i, j);
		}	
		swap(nums, j, start);
		if(j == k) return nums[j];
		else if(j < k) return quickSelect(nums, j + 1, end, k);
		else return quickSelect(nums, start, j - 1, k);
	}
	public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length < k) return 0;
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
	void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;				
	}
	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};
		int []nums = {3,2,1,6,5,4};
		System.out.println(s.findKthLargest(nums, 3));
	}
}
