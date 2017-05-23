package com.test.solution;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> sum = new HashMap<>();
		int result = 0;
		int total = 0;
		sum.put(0, 1);
		for(int i = 0; i < nums.length; i++){
			total += nums[i];

			if(sum.get(total - k) != null){
				result += sum.get(total - k);
			}
			sum.put(total, sum.getOrDefault(total, 0) + 1);
		}
		return result;
	}
}

