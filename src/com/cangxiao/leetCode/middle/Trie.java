package com.cangxiao.leetCode.middle;

/**
 * @Author cangxiao
 * @Date 2021/12/4
 * @Desc 208. 实现 Trie (前缀树)
 */
public class Trie {

    private class TrieNode{
        boolean isEnding = false;
        TrieNode[] children = new TrieNode[26];
        public TrieNode() {
        }
    }

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (p.children[c-'a']==null){
                p.children[c-'a'] = new TrieNode();
            }
            p = p.children[c-'a'];
        }
        p.isEnding = true;
    }

    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (p.children[c-'a']==null) return false;
            p = p.children[c-'a'];
        }
        return p.isEnding;
    }

    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (p.children[c-'a']==null) return false;
            p = p.children[c-'a'];
        }
        return true;
    }
}
