// Tries: Contacts
// https://www.hackerrank.com/challenges/ctci-contacts/problem

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.*;

class Node {
    
    private HashMap<Character,Node> childs;
    private boolean endOfWord;
    private int numberOfWords;
    
    public Node () {
        childs = new HashMap<Character, Node>();
        endOfWord = false;
        numberOfWords = 0;
    }
    
    public Node add (char c) {
        if (!childs.containsKey(c)) {
            childs.put(c, new Node());
        }
        childs.get(c).incrementWords();
        return childs.get(c);
    }
    
    public void incrementWords() {
        numberOfWords++;
    }
    
    public void setEnd() {
        endOfWord = true;
    }
    
    public int countWords() {
        /*int count = 0;
        if (this.endOfWord) count++;
        for (Node n : childs.values()) {
            count += n.countWords();
        }*/
        return numberOfWords;
    }
    
    public Node get(Character key) {
        return childs.get(key);
    }
}

class Catalog extends Node {
    
    //private HashMap<char, Node> childs = HashMap<char, Node>;
    
    public void addContact (String contact) {
        Node n = this;
        for (int i = 0; i < contact.length(); i++) {
            char c = contact.charAt(i);
            n = n.add(c);
        }
        n.setEnd();
    }
    
    public int find(String contact) {
        Node n = this;
        for (int i = 0; i < contact.length(); i++) {
            char c = contact.charAt(i);
            n = n.get(c);
            if (n == null) {
                return 0;
            }
        }
        return n.countWords();
    }
    
}

public class Solution {

    final static String OP_ADD = "add";
    final static String OP_FIND = "find";
    
    public static void main(String[] args) {
        
        Catalog catalog = new Catalog();
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();
            
            switch (op) {
                case OP_ADD:
                    catalog.addContact(contact);
                    break;
                case OP_FIND:
                    System.out.println(catalog.find(contact));
                    break;
            }
        }
    }
}
