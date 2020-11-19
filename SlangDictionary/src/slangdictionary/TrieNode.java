/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slangdictionary;

import java.util.HashMap;

/**
 *
 * @author MinhVu
 */
public class TrieNode {
    private HashMap<Character, TrieNode> children;
    private String content;
    private boolean isWord;
    
    public HashMap getChildren(){
        return children;
    }
    
}
