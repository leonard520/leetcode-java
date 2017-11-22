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
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> result = new  LinkedList<Integer>();
        if(arr == null || arr.length == 0) return result;
        if(arr.length <= k) {
        	for(int i = 0; i < arr.length; i++) result.add(arr[i]);
        	return result;
        }
        int low = 0;
        int high = arr.length - 1 - k;
        while(low < high){
        	int middle = low + (high - low) / 2;
        	if(x - arr[middle] > arr[middle + k] - x){
        		low = middle + 1;
        	} else {
        		high = middle;
        	}
        }
        for(int i = 0; i < k; i++){
        	result.add(arr[low + i]);
        }
        return result;
    }
}