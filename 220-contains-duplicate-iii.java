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
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
       if(nums == null || nums.length == 0 || k <= 0){
       	return false;
       }
       TreeSet<Long> map = new TreeSet<Long>();
       map.add((long)nums[0]);
       for(int i = 1; i < nums.length; i++){
       	Long max = map.ceiling((long)nums[i]);
       	Long min = map.floor((long)nums[i]);
       	if((max != null && max - nums[i] <= t) ||(min != null && nums[i] <= min + t)){
       		return true;
       	}
       	if(i >= k){
       		map.remove((long)nums[i - k]);
       	}
       	map.add((long)nums[i]);
       }
       return false;
   }
}