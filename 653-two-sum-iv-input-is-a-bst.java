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
	private void tree2list(TreeNode root, List<Integer> list){
		if(root == null) return;
		tree2list(root.left, list);
		list.add(root.val);
		tree2list(root.right, list);
	}
	public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        List<Integer> list = new LinkedList<Integer>();
        tree2list(root, list);
        int i = 0;
        int j = list.size() - 1;
        while(i < j){
        	if(list.get(i) + list.get(j) == k){
        		return true;
        	} else if(list.get(i) + list.get(j) < k){
        		i++;
        	} else {
        		j--;
        	}
        }
        return false;
    }
}