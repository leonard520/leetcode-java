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
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> result = new LinkedList<Integer>();
        if(nums == null || nums.length == 0) return result;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
        	map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
                new PriorityQueue<Map.Entry<Integer, Integer>>(7, new Comparator<Map.Entry<Integer, Integer>>(){
                	@Override
                    public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2) {
                		return m2.getValue() - m1.getValue();
                    }
                });
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
        	maxHeap.add(entry);
        }
        int times = Math.min(map.keySet().size(), k);
        for(int i = 0; i < times; i++){
        	result.add(maxHeap.poll().getKey());
        }
        return result;
    }
}
