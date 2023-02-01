package org.sun.chapter1.section3.exe;

public class Exercise1 {

    private String[] a;
    private int n;

    public Exercise1(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(String item) {
        a[n++] = item;
    }

    public String pop() {
        return a[--n];
    }

    public boolean isFull() {
        return n == a.length;
    }
    public static void main(String[] args) {

    }
}
