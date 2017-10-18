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
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
	public int minDistance(String word1, String word2) {
       if(word1 == null || word2 == null) return 0;
       int [][]dp = new int[word1.length() + 1][word2.length() + 1];
       int max = 0;
       for(int i = 0; i <= word1.length(); i++){
    	   for(int j = 0; j <= word2.length(); j++){
    		   if(i == 0 || j == 0) {
    			   dp[i][j] = 0;
    		   } else {
    			   dp[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
    		   }
    		   
    	   }
       }
       return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
    }
	
	public static void main(String args[]){
		Solution s = new Solution();
		String str1 = "eat";
		String str2 = "sea";
		s.minDistance(str1, str2);
	}
}
