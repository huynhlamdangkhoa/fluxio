package service;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;

    public TrieNode() {
        isEndOfWord = false;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
}