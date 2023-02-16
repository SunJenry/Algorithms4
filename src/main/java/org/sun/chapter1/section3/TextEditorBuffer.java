package org.sun.chapter1.section3;

public class TextEditorBuffer {

    private Stack<Character> left;
    private Stack<Character> right;

    public TextEditorBuffer() {
        left = new Stack<>();
        right = new Stack<>();
    }

    public void insert(char c) {
        left.push(c);
    }

    public char delete() {
        Character pop = left.pop();
        return pop;
    }

    public void left(int k) {
        while (!left.isEmpty() && --k > 0) {
            right.push(left.pop());
        }
    }

    public void right(int k) {
        while (!right.isEmpty() && --k > 0) {
            left.push(right.pop());
        }
    }

    public int size() {
        return left.size() + right.size();
    }
}
