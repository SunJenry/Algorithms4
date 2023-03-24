package org.sun.chapter2.section2.exe;

import org.sun.util.StdOut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exe21 {
    public static void main(String[] args) {
        List<String> namesList1 = new ArrayList<>();
        namesList1.add("Sedgewick");
        namesList1.add("Zord");
        namesList1.add("Bill");
        namesList1.add("Rene");

        List<String> namesList2 = new ArrayList<>();
        namesList2.add("Zord");
        namesList2.add("Wayne");
        namesList2.add("Rene");
        namesList2.add("Larry");

        List<String> namesList3 = new ArrayList<>();
        namesList3.add("Rene");
        namesList3.add("Sergey");
        namesList3.add("Zord");
        namesList3.add("Elon");

        List<List<String>> names = new ArrayList<>();
        names.add(namesList1);
        names.add(namesList2);
        names.add(namesList3);

        String s = checkFirstCommonName(names);
        StdOut.print("first common name:" + s);
    }

    public static String checkFirstCommonName(List<List<String>> namesList) {
        //init index，sort every name list
        ArrayList<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < namesList.size(); i++) {
            indexes.add(0);
            Collections.sort(namesList.get(i));
        }

        while (true) {

            String maxName = findMaxName(namesList, indexes);
            boolean commonName = currentIndexNameEqual(namesList, indexes);

            if (commonName) {
                return maxName;
            }

            //align each name list.(make each index in each name list not smaller than the current max)
            for (int i = 0; i < namesList.size(); i++) {
                List<String> names = namesList.get(i);
                int startIndex = indexes.get(i) + 1;
                if (startIndex >= names.size()) {
                    return null;
                }

                for (int j = startIndex; j < names.size(); j++) {
                    indexes.set(i, j);
                    if (names.get(j).compareTo(maxName) >= 0) {
                        break;
                    }
                }
            }
        }
    }

    private static boolean currentIndexNameEqual(List<List<String>> namesList, ArrayList<Integer> indexes) {
        for (int i = 0; i < namesList.size() - 1; i++) {
            String nameCurrent = namesList.get(i).get(indexes.get(i));
            String nameNext = namesList.get(i + 1).get(indexes.get(i + 1));

            if (!nameCurrent.equals(nameNext)) {
                return false;
            }

        }

        return true;
    }

    private static String findMaxName(List<List<String>> namesList, ArrayList<Integer> indexes) {
        String currentMax = namesList.get(0).get(indexes.get(0));

        for (int i = 1; i < namesList.size(); i++) {
            String temp = namesList.get(i).get(indexes.get(i));
            if (temp.compareTo(currentMax) > 0) {
                currentMax = temp;
            }
        }

        return currentMax;
    }
}
