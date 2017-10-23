package com.test.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
	private boolean increasingTripletInternal(int[] nums, int start, int v, int left) {
		if(left == 0) return true;
		boolean flag = false;
		for(int i = start; i < nums.length; i++){
			if(nums[i] > v){
				flag |= increasingTripletInternal(nums, i + 1, nums[i], left - 1);
				if(flag == true) return true;
			}
		}
		return flag;
	}
	public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3) return false;
        return increasingTripletInternal(nums, 0, Integer.MIN_VALUE, 3);
    }
}
