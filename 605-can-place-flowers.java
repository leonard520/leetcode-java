package com.test.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		boolean prev = false;
		int count = 0;
		if(flowerbed.length == 1){
			return ((n == 1 && flowerbed[0] == 0) || n == 0);
		}
        for(int i = 0; i < flowerbed.length - 1; i++){
        	if(prev == false && flowerbed[i + 1] == 0 && flowerbed[i] == 0){
        		prev = true;
        		count++;
        	} else {
        		prev = flowerbed[i] == 0 ? false : true;
        	}
        }
        if(prev == false && flowerbed[flowerbed.length - 1] == 0){
        	count++;
        }
        return count >= n;
    }
	
	public static void main(String args[]){
		Solution s = new Solution();
		//int [][]nums = {{1,1,1},{1,0,1},{1,1,1}};
		//int [][]nums = {{1}};
		int []nums = {1, 0, 0, 0, 1};
		s.canPlaceFlowers(nums, 1);
		
	}
}
