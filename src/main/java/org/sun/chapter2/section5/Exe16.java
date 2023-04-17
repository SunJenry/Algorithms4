package org.sun.chapter2.section5;

import java.util.Comparator;

public class Exe16 {

    private class CandidateOrder implements Comparator<String> {

        private String order = "RWQOJMVAHBSGZXNTCIEKUPDYFL";

        @Override
        public int compare(String name1, String name2) {
            int min = Math.min(name1.length(), name2.length());
            for (int i = 0; i < min; i++) {
                int compare = order.indexOf(name1.charAt(i)) - order.indexOf(name2.charAt(i));
                if (compare != 0) {
                    return compare;
                }
            }

            return name1.length() - name2.length();
        }
    }

    public static void main(String[] args) {

    }
}
