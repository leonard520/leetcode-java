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
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new LinkedList<Interval>();
		if(intervals == null || intervals.size() == 0) return result;
		Collections.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval s1, Interval s2) {
				return s1.start - s2.start;
			}
		});
		result.add(intervals.get(0));
		for(int i = 1; i < intervals.size(); i++){
			int len = result.size();
			if(result.get(len - 1).end < intervals.get(i).start){
				result.add(intervals.get(i));
			} else if(result.get(len - 1).end < intervals.get(i).end){
				Interval interval = new Interval(result.get(len - 1).start, intervals.get(i).end);
				result.remove(len - 1);
				result.add(interval);
			}
		}
		return result;
    }
	
	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};

	}
}
