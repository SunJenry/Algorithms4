package org.sun.chapter3;

import org.sun.util.StdIn;
import org.sun.util.StdOut;

public class FrequencyCounter {
    public static void main(String[] args) {

        int minLen = Integer.parseInt(args[0]);
        ST<String, Integer> st;

//        while (!StdIn.isEmpty()) {
//            String word = StdIn.readString();
//            if (word.length() < minLen) continue;
//            if (st.contains(word)) {
//                st.put(word, st.get(word) + 1);
//            } else {
//                st.put(word, 1);
//            }
//        }

//        String max = "";
//        st.put(max, 0);
//        for (String word : st.keys()) {
//            if (st.get(word) > st.get(max)) {
//                max = word;
//            }
//        }
//
//        StdOut.println(max + " " + st.get(max));
    }
}
