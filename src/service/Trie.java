package service;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Chèn một từ vào Trie
    public void insert(String key) {
        TrieNode node = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    // Tìm kiếm một từ trong Trie
    public boolean search(String key) {
        TrieNode node = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node != null && node.isEndOfWord;
    }
    
    // Find all words that start with a given prefix
    public List<String> searchByPrefix(String prefix) {
        List<String> result = new ArrayList<>();
        TrieNode node = root;

        // Traverse the Trie to find the node representing the prefix
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.children[index] == null) {
                return result;  // No words with this prefix
            }
            node = node.children[index];
        }

        // Use a helper method to collect all words from this node
        collectWords(node, prefix, result);
        return result;
    }

    // Helper method to collect words from a given node
    private void collectWords(TrieNode node, String prefix, List<String> result) {
        if (node.isEndOfWord) {
            result.add(prefix);  // Add the word to the result list
        }
        // Recurse for all children
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                collectWords(node.children[i], prefix + (char)(i + 'a'), result);
            }
        }
    }
}
