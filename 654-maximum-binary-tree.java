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
	public TreeNode constructMaximumBinaryTreeInternal(int[] nums, int start, int end) {
		if(start > end) return null;
		int max = nums[start];
		int ind = start;
        for(int i = start + 1; i <= end; i++){
        	if(max < nums[i]){
        		ind = i;
        		max = nums[i];
        	}
        }
        TreeNode node = new TreeNode(max);
        node.left = constructMaximumBinaryTreeInternal(nums, start, ind - 1);
        node.right = constructMaximumBinaryTreeInternal(nums, ind + 1, end);
        return node;
    }
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		if(nums == null || nums.length == 0) return null;
		return constructMaximumBinaryTreeInternal(nums, 0, nums.length - 1);
    }
}