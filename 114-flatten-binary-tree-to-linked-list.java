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
	public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);
        if(root.right == null){
        	root.right = root.left;
        	root.left = null;
        } else if(root.left != null && root.right != null){
        	TreeNode node = root.right;
        	root.right = root.left;
        	TreeNode temp = root.left;
        	root.left = null;
        	while(temp.right != null){
        		temp = temp.right;
        	}
        	temp.right = node;
        }
    }
}