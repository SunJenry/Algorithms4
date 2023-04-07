package org.sun.chapter2.section5;

import java.util.*;
import java.util.function.Consumer;

public class Exe2 {
    public static void main(String[] args) {

    }

    private List<String> getCompoundWords(ArrayList<String> wordList) {
        Collections.sort(wordList);
        Set<String> wordsSet = new HashSet<>(wordList);

        wordsSet.addAll(wordList);

        List<String> compoundWords = new ArrayList<>();

        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (wordList.get(j).startsWith(wordList.get(i))) {

                    String restOfTheWord = wordList.get(j).substring(wordList.get(i).length());
                    if (wordsSet.contains(restOfTheWord)) {
                        compoundWords.add(wordList.get(j));
                    }
                } else {
                    break;
                }
            }
        }
        return compoundWords;
    }
}
