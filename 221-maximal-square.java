package com.test.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
	public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][]dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++){
        	for(int j = 1; j <= n; j++){
        		if(matrix[i - 1][j - 1] == '1'){
        			dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
        			max = Math.max(max, dp[i][j]);
        		}
        	}
        }
        return max * max;
    }

	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};
		int nums[] = {2, 1, 3, 1};
		s.findDuplicate(nums);
	}
}
