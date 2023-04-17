package org.sun.chapter2.section5;

import java.util.Arrays;

public class Exe20 {

    private class Job implements Comparable<Job> {

        private int startTime;
        private int endTime;

        Job(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Job that) {
            if (this.startTime < that.startTime) {
                return -1;
            } else if (this.startTime > that.startTime) {
                return 1;
            } else {
                if (this.endTime < that.endTime) {
                    return -1;
                } else if (this.endTime > that.endTime) {
                    return 1;
                }
            }

            return 0;
        }
    }

    public static void main(String[] args) {

    }

    private int[] getAsynchronousJobsIntervals(Job[] jobs) {
        if (jobs == null || jobs.length == 0) {
            return new int[]{0, 0, 0, 0};
        }

        int currentIntervalStartIndex = 0;

        int largestIdleTimeStartIndex = 0;
        int largestIdleTimeEndIndex = 0;
        int largestBusyTimeStartIndex = 0;
        int largestBusyTimeEndIndex = 0;

        Arrays.sort(jobs);

        int currentMaxEndTime = jobs[0].endTime;
        int currentMaxEndTimeIndex = 0;
        int maxIdleTime = jobs[0].startTime;

        for (int i = 0; i < jobs.length; i++) {
            if (i != 0 && jobs[i].startTime > currentMaxEndTime) {
                if (jobs[i].startTime - currentMaxEndTime > maxIdleTime) {
                    largestIdleTimeEndIndex = i;
                    largestIdleTimeStartIndex = currentMaxEndTimeIndex;
                    maxIdleTime = jobs[largestIdleTimeEndIndex].startTime - jobs[largestBusyTimeStartIndex].endTime;
                }

                currentIntervalStartIndex = i;
            }

            if (jobs[i].endTime - jobs[currentIntervalStartIndex].startTime > jobs[largestBusyTimeEndIndex].endTime - jobs[largestBusyTimeStartIndex].startTime) {
                largestBusyTimeStartIndex = currentIntervalStartIndex;
                largestBusyTimeEndIndex = i;
            }

            if (jobs[i].endTime > currentMaxEndTime) {
                currentMaxEndTime = jobs[i].endTime;
                currentMaxEndTimeIndex = i;
            }
        }

        int largestIdleTimeStart = jobs[largestIdleTimeStartIndex].endTime;
        int largestIdleTimeEnd = jobs[largestBusyTimeEndIndex].endTime;

        // Edge case - when the largest idle interval is from time 0 to the beginning of the first job
        if (largestIdleTimeStart > largestIdleTimeEnd) {
            largestIdleTimeStart = 0;
        }

        int largestBusyTimeStart = jobs[largestBusyTimeStartIndex].startTime;
        int largestBusyTimeEnd = jobs[largestBusyTimeEndIndex].endTime;

        return new int[]{largestIdleTimeStart, largestIdleTimeEnd, largestBusyTimeStart, largestBusyTimeEnd};
    }
}
