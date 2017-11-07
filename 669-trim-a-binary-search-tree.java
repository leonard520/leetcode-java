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
	public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null) return null;
        int val = root.val;
        if(val > R){
        	return trimBST(root.left, L, R);
        } else if(val < L){
        	return trimBST(root.right, L, R);
        } else{
        	root.left = trimBST(root.left, L, R);
        	root.right = trimBST(root.right, L, R);
        }
        return root;
    }
}