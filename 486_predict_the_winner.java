package com.eg;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	int[] used;
	Map<Integer[], Boolean> map;
	int a;
	int b;

	public Solution() {
		map = new HashMap<Integer[], Boolean>();
		a = 0;
		b = 0;
	}

	public boolean PredictTheWinner(int[] nums) {
		if (nums == null || nums.length == 1) {
			return true;
		}
		used = new int[nums.length];
		return helper(nums, 0, nums.length - 1, 1);
	}

	private Integer[] array2key(int[] array) {
		Integer[] newArray = new Integer[array.length];
		int i = 0;
		for (int value : array) {
			newArray[i++] = Integer.valueOf(value);
		}
		return newArray;
	}

	private boolean helper(int[] nums, int start, int end, int w) {

		if (start > nums.length - 1 || end < 0 || end < start) {
			return a <= b ? true : false;
		}
		Integer[] status = array2key(used);

		if (map.containsKey(status) == false) {
			used[start] = w;
			if (w == 1)
				a += nums[start];
			else
				b += nums[start];
			if (helper(nums, start + 1, end, -w) == false) {
				used[start] = 0;
				if (w == 1)
					a -= nums[start];
				else
					b -= nums[start];
				map.put(status, Boolean.TRUE);
				return true;
			}
			used[start] = 0;
			if (w == 1)
				a -= nums[start];
			else
				b -= nums[start];

			if (w == 1)
				a += nums[end];
			else
				b += nums[end];
			used[end] = w;
			if (helper(nums, start, end - 1, -w) == false) {
				used[end] = 0;
				if (w == 1)
					a -= nums[end];
				else
					b -= nums[end];
				map.put(status, Boolean.TRUE);
				return true;
			}
			if (w == 1)
				a -= nums[end];
			else
				b -= nums[end];
			used[end] = 0;
			map.put(status, Boolean.FALSE);
		}

		return map.get(status);
	}

	public static void main(String args[]) {
		Solution s = new Solution();
		int nums[] = { 1, 1 };
		System.out.println(s.PredictTheWinner(nums));
	}
}
