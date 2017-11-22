package com.test.solution;

class WordDictionary {

	static class TrieNode{
		public TrieNode[] children = new TrieNode[26];
        public String item = "";
	}
	
	TrieNode root = new TrieNode();
	
    /** Initialize your data structure here. */
    public WordDictionary() {
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(word == null) return;
        TrieNode node = root;
        for(char c : word.toCharArray()){
        	if(node.children[c - 'a'] == null){
        		node.children[c - 'a'] = new TrieNode();
        	}
        	node = node.children[c - 'a'];
        }
        node.item = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word == null) return false;
        return searchInternal(word, 0, root);
    }
    
    public boolean searchInternal(String word, int index, TrieNode root) {
    	if(index == word.length()) return !root.item.equals("");
    	boolean flag = false;
    	if(word.charAt(index) == '.'){
    		for(int i = 0; i < 26; i++){
    			if(root.children[i] != null){
    				flag |= searchInternal(word, index + 1, root.children[i]);
    				if(flag == true) return flag;
    			}
    		}
    	} else {
    		if(root.children[word.charAt(index) - 'a'] != null) {
    			flag |= searchInternal(word, index + 1, root.children[word.charAt(index) - 'a']);
    		}
    	}
    	return flag;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */