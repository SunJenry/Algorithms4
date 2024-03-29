package org.sun.chapter5.section2;

import org.sun.chapter1.section3.Queue;

public class TrieST extends AbsStringST {

    private static int R = 256;
    private Node root;

    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }

    @Override
    void put(String key, Object val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Object val, int d) {
        if (x == null) return new Node();
        if (d == key.length()) {
            x.val = val;
            return x;
        }

        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }

    @Override
    Object get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return x.val;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    @Override
    void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) return null;

        if (d == key.length()) {
            x.val = null;
        } else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d + 1);
        }

        if (x.val != null) return x;

        for (char c = 0; c < R; c++) {
            if (x.next[c] != null) return x;
        }

        return null;
    }

    @Override
    boolean contains(String key) {
        return false;
    }

    @Override
    boolean isEmpty() {
        return false;
    }

    @Override
    String longestPrefixOf(String s) {
        int length = search(root, s, 0, 0);
        return s.substring(0, length);
    }

    private int search(Node x, String s, int d, int length) {
        if (x == null) return length;
        if (x.val != null) length = d;
        if (d == s.length()) return length;
        char c = s.charAt(d);
        return search(x.next[c], s, d + 1, length);
    }

    @Override
    Iterable<String> keysWithPrefix(String s) {
        Queue<String> q = new Queue<>();
        collect(get(root, s, 0), s, q);
        return q;
    }

    private void collect(Node x, String pre, Queue<String> q) {
        if (x == null) return;
        if (x.val != null) q.enqueue(pre);
        for (char c = 0; c < R; c++) {
            collect(x.next[c], pre + c, q);
        }
    }

    @Override
    Iterable<String> keysThatMatch(String s) {
        Queue<String> q = new Queue<>();
        collect(root, "", s, q);
        return q;
    }

    private void collect(Node x, String pre, String pat, Queue<String> q) {
        int d = pre.length();
        if (x == null) return;
        if (d == pat.length() && x.val != null) q.enqueue(pre);
        if (d == pat.length()) return;

        char next = pat.charAt(d);
        for (char c = 0; c < R; c++) {
            if (next == '.' || next == c) {
                collect(x.next[c], pre + c, pat, q);
            }
        }
    }

    @Override
    int size() {
        return 0;
    }

    @Override
    Iterable<String> keys() {
        return keysWithPrefix("");
    }
}
