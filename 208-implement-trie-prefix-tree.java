package com.test.solution;


/** Initialize your data structure here. */  
public class Trie {
	TrieNode root = new TrieNode();
	
	class TrieNode {
		boolean isValid;
		TrieNode []children = new TrieNode[26];
	}      

    /** Inserts a word into the trie. */
    public void insert(String word) {
    	if(word == null) return;
    	TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
        	char c = word.charAt(i);        		
        	TrieNode nn = node.children[c - 'a'];
        	if(nn == null){
        		nn = new TrieNode();
        		node.children[c - 'a'] = nn;
        	}
        	node = node.children[c - 'a'];
        }
        node.isValid = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	if(word == null) return false;
    	TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
        	char c = word.charAt(i);        	
        	if(node.children[c - 'a'] == null){
        		return false;
        	}
        	node = node.children[c - 'a'];
        }
        return node.isValid;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	if(prefix == null) return false;
    	TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++){
        	char c = prefix.charAt(i);        	
        	if(node.children[c - 'a'] == null){
        		return false;
        	}
        	node = node.children[c - 'a'];
        }
        return true;
    }
    
    public static void main(String args[]){
    	Trie trie = new Trie();
    	System.out.println(trie.search("abc"));
    	trie.insert("abc");
    	System.out.println(trie.search("a"));
    	System.out.println(trie.search("ab"));
    	System.out.println(trie.search("abc"));
    	System.out.println(trie.search("b"));
    	System.out.println(trie.search("bd"));
    }
}
