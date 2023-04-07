package org.sun.chapter2.section5;

public class Exe11 {

    public static class Job implements Comparable<Job> {

        private String name;
        private int processingTime;

        Job(String name, int processingTime) {
            this.name = name;
            this.processingTime = processingTime;
        }

        @Override
        //Shortest processing time first rule
        public int compareTo(Job that) {
            if (this.processingTime < that.processingTime) {
                return -1;
            } else if (this.processingTime > that.processingTime) {
                return 1;
            } else {
                return 0;
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getProcessingTime() {
            return processingTime;
        }

        public void setProcessingTime(int processingTime) {
            this.processingTime = processingTime;
        }

        @Override
        public String toString() {
            return name + "   " + processingTime;
        }
    }
}
