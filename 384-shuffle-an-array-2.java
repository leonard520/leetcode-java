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
	int []array;

	public Solution(int[] nums) {
        array = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
        	array[i] = nums[i];
        }
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return array;
    }
    
    private void swap(int []nums, int i, int j){
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	Random r = new Random();
    	int []result = new int[array.length];
    	
    	int []nums = new int[array.length];
        for(int i = 0; i < array.length; i++){
        	nums[i] = array[i];
        }
        
    	for(int i = 0; i < nums.length; i++){
    		int rand = r.nextInt(nums.length - i);
    		result[i] = nums[rand];
    		swap(nums, rand, nums.length - i - 1);
    	}
    	return result;
    }
    
}
