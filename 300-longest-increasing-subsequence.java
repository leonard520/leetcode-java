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
	public int lengthOfLIS(int[] nums, int start, int max, int len) {
		if(start == nums.length){
			 return len;
		}
		int current = 0;
		for(int i = start; i < nums.length; i++){
			int temp1 = 0;
			int temp2 = 0;
			if(len == 0 && max == Integer.MIN_VALUE && nums[i] == Integer.MIN_VALUE){
				temp1 = lengthOfLIS(nums, i + 1, nums[i], len + 1);
			} else if(nums[i] > max){
				temp1 = lengthOfLIS(nums, i + 1, nums[i], len + 1);
			}
			temp2 = lengthOfLIS(nums, i + 1, max, len);
			current = Math.max(Math.max(temp1, temp2), current);
		}
		return current;
	}
	public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        return lengthOfLIS(nums, 0, Integer.MIN_VALUE, 0);
    }
}