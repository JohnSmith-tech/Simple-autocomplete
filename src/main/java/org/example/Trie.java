package org.example;


import java.util.ArrayList;
import java.util.List;

public class Trie {

    TrieNode root = new TrieNode(' ');

    void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.getChild(ch) == null)
                node.children.add(new TrieNode(ch));
            node = node.getChild(ch);
        }
        node.isEnd = true;
    }

    List<String> autocomplete(String prefix) {
        TrieNode node = root;
        List<String> res = new ArrayList<String>();
        for (char ch : prefix.toCharArray()) { //find end of prefix
            node = node.getChild(ch);
            if (node == null)
                return new ArrayList<String>();
        }
        helper(node, res, prefix.substring(0, prefix.length() - 1));
        return res;
    }

    // Time O(n), Space O(n), n is number of nodes in branches
    void helper(TrieNode node, List<String> res, String prefix) {
        if (node.isEnd)
            res.add(prefix + node.data);
        for (TrieNode child : node.children)
            helper(child, res, prefix + node.data);
    }


}