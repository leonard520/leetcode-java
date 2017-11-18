package com.test.solution;

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
	public void swap(int array[], int a, int b){
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
	public int leftChild(int i){
		return i * 2 + 1;
	}
	public int rightChild(int i){
		return i * 2 + 2;
	}
	public void adjustHeap(int array[], int index, int size){
		for(int i = index; leftChild(i) < size;){
			int tmp = leftChild(i);
			if(rightChild(i) < size && array[rightChild(i)] < array[leftChild(i)]){
				tmp++;
			}
			if(array[tmp] < array[i]){
				swap(array, tmp, i);
			} else {
				break;
			}
			i = tmp;
		}
	}
	public void buildHeap(int array[]){
		for(int i = (array.length - 1) / 2; i >= 0; i--){
			adjustHeap(array, i, array.length);
		}
		
	}
	public void heapSort(int array[]){
		if(array == null || array.length == 0) return;
		buildHeap(array);
		for(int i = array.length - 1; i > 0; i--){
			swap(array, 0, i);
			adjustHeap(array, 0, i);
		}
	}
	
	public int hIndex(int[] citations) {
		if(citations == null || citations.length == 0) return 0;
		heapSort(citations);
		int n = citations.length;
		for(int i = n - 1; i >= 0; i--){
			if(citations[i] >= i + 1){
				return i + 1;
			}
		}
		return 0;
    }
}