package org.sun.chapter1.section3.exe;

import org.sun.chapter1.section3.Queue;

import java.io.File;

public class Exercise43 {
    public static void main(String[] args) {

    }

    public static Queue<String> listFile(File file) {
        Queue<String> strings = new Queue<>();
        listFile(strings, file, 0);
        return strings;
    }

    private static void listFile(Queue<String> strings, File file, int depth) {
        addToFileQueue(strings, file, depth);

        File[] files = file.listFiles();

        if (files != null) {
            for (File innerFile : files) {
                if (file.isDirectory()) {
                    listFile(strings, innerFile, ++depth);
                } else {
                    addToFileQueue(strings, innerFile, depth);
                }
            }
        }
    }

    private static void addToFileQueue(Queue<String> strings, File file, int depth) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            stringBuilder.append(" ");
        }

        strings.enqueue(stringBuilder.append(file.getName()).toString());
    }
}
