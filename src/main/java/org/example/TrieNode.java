package org.example;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {
    char data;
    List<TrieNode> children = new ArrayList<>();
    boolean isEnd = false;


    TrieNode(char c) {
        data = c;
    }


    //Time O(k), Space O(1), k is number of children of this node
    TrieNode getChild(char c) {
        if (children != null)
            for (TrieNode child : children)
                if (child.data == c)
                    return child;
        return null;
    }
}