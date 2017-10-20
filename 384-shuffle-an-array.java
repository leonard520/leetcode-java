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
	int len;
	List<List<Integer>> list;
	public Solution(int[] nums) {
        array = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
        	array[i] = nums[i];
        }
        len = nums.length;
        list = new LinkedList<List<Integer>>();
        permutation();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return array;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	Random r = new Random();
    	List<Integer> l = list.get(r.nextInt(list.size()));
    	int []result = new int[array.length];
    	for(int i = 0; i < array.length; i++){
    		result[i] = array[l.get(i)];
    	}
    	return result;
    }
    
    private void swap(int []nums, int i, int j){
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }
    
    private void permutationInternal(int []nums, int start, List<Integer> l){
    	if(start == nums.length){
    		list.add(new LinkedList<Integer>(l));
    		return;
    	}
    	for(int i = start; i < nums.length; i++){
    		l.add(nums[i]);
    		swap(nums, i, start);
    		permutationInternal(nums, start + 1, l);
    		swap(nums, i, start);
    		l.remove(l.size() - 1);
    	}
    }
    
    private void permutation(){
    	int []nums = new int[array.length];
        for(int i = 0; i < nums.length; i++){
        	nums[i] = i;
        }
        permutationInternal(nums, 0, new LinkedList<Integer>());
    }
}
