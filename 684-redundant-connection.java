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
	public int[] findRedundantConnection(int[][] edges) {
		final int MAXNODE = 2001;
		int[] parents = new int[MAXNODE];
		for(int i = 0; i < MAXNODE; i++){
			parents[i] = i;
		}
		for(int i = 0; i < edges.length; i++){
			int child = edges[i][0];
			int parent = edges[i][1];
			if(getParent(parents, child) == getParent(parents, parent)) return edges[i];
			else parents[getParent(parents, child)] = getParent(parents, parent);
		}
		return new int[2];
	}
	
	public int getParent(int []parent, int i){
		if(parent[i] != i){
			parent[i] = getParent(parent, parent[i]);
		}
		return parent[i];
	}
}