package org.sun.chapter2.section4.exe;

import org.sun.chapter2.section4.MaxPQ;
import org.sun.util.StdOut;

public class Exe6 {
    public static void main(String[] args) {
        String command = "P R I O * R * * I * T * Y * * * Q U E * * * U * E";
        String[] commands = command.split(" ");

        MaxPQ<String> stringMaxPQ = new MaxPQ<>(5);

        for (int i = 0; i < commands.length; i++) {
            String commandSingle = commands[i];
            if (commandSingle.equals("*")) {
                String max = stringMaxPQ.delMax();
                StdOut.println(max);
            } else {
                stringMaxPQ.insert(commandSingle);
            }

            stringMaxPQ.printPQ();
        }
    }
}
