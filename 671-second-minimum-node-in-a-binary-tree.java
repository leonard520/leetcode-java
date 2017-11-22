package com.test.solution;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

class Solution {
	public int findSecondMinimumValueInternal(TreeNode root, int min) {
        if(root.val > min) return root.val;
        if(root.left != null && root.right != null){
        	int left = findSecondMinimumValueInternal(root.left, min);
        	int right = findSecondMinimumValueInternal(root.right, min);
        	if(left == -1 && right == -1) return -1;
        	else if(left == -1) return right;
        	else if(right == -1) return left;
        	else return Math.min(right, left);
        } else {
        	return -1;
        }
    }
	public int findSecondMinimumValue(TreeNode root) {
		int min = root.val;
        return findSecondMinimumValueInternal(root, min);
    }
}