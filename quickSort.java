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
    public void quickSort(int nums[]){
    	if(nums == null || nums.length == 0) return;
    	quickSort(nums, nums.length - 1, 0);
    }
    
    private void quickSort(int nums[], int high, int low){
    	if(low >= high) return;
    	int base = nums[low];
    	int i = low;
    	int j = high;
    	while(i < j){
    		while(nums[i] <= base && i < j){
    			i++;
    		}
    		while(nums[j] > base && j >= i){
    			j--;
    		}
    		if(i < j) swap(nums, i, j);
    	}
    	swap(nums, j, low);
    	quickSort(nums, j - 1, low);
    	quickSort(nums, high, j + 1);
    }
    
    private void swap(int nums[], int i, int j){
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
    
    public static void main(String args[]){
    	int len = 100;
    	int []nums = new int[len];
    	Random rand = new Random();
    	Solution solution = new Solution();
    	for(int test = 0; test < len; test++){
	    	for(int i = 0; i < len; i++){
	    		nums[i] = rand.nextInt(len);
	    	}
	    	solution.quickSort(nums);
	    	for(int i = 0; i < len - 1; i++){
	    		if(nums[i] > nums[i + 1]){
	    			System.out.println("failuer");
	    		}
	    	}
    	}
    }
}