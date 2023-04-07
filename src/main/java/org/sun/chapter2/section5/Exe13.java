package org.sun.chapter2.section5;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Exe13 {
    public static class Processor implements Comparable<Processor> {
        private String name;
        private List<Exe11.Job> jobsAssigned;
        private int sumOfJobsAssignedProcessingTime;

        Processor(String name) {
            this.name = name;
            this.sumOfJobsAssignedProcessingTime = 0;
            jobsAssigned = new ArrayList<>();
        }

        void assignJob(Exe11.Job job) {
            jobsAssigned.add(job);
            sumOfJobsAssignedProcessingTime += job.getProcessingTime();
        }

        @Override
        public int compareTo(Processor that) {
            if (this.sumOfJobsAssignedProcessingTime < that.sumOfJobsAssignedProcessingTime) {
                return -1;
            } else if (this.sumOfJobsAssignedProcessingTime > that.sumOfJobsAssignedProcessingTime) {
                return 1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        ArrayList<Exe11.Job> jobs = new ArrayList<>();

        PriorityQueue<Processor> processors = new PriorityQueue<>();

        assignJob(jobs,processors);
    }

    //find current min load processor,and assign the job
    private static void assignJob(ArrayList<Exe11.Job> jobs, PriorityQueue<Processor> processors) {
        for (int i = 0; i < jobs.size(); i++) {
            Processor peek = processors.peek();
            peek.assignJob(jobs.get(i));
            processors.add(peek);
        }
    }
}
