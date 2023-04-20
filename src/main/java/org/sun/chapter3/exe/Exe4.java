package org.sun.chapter3.exe;

public class Exe4 {
    private class Time implements Comparable<Time>{

        private int hours;
        private int minutes;
        private int seconds;

        public Time(int hours, int minutes, int seconds) {
            if (hours < 0 || hours > 23) {
                throw new IllegalArgumentException("Hours range must be between 0 and 23");
            }
            if (minutes < 0 || minutes > 59) {
                throw new IllegalArgumentException("Minutes range must be between 0 and 59");
            }
            if (seconds < 0 || seconds > 59) {
                throw new IllegalArgumentException("Seconds range must be between 0 and 59");
            }

            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
        }

        @Override
        public int compareTo(Time that) {
            if (this.hours < that.hours) {
                return -1;
            } else if (this.hours > that.hours) {
                return 1;
            } else if (this.minutes < that.minutes) {
                return -1;
            } else if (this.minutes > that.minutes) {
                return 1;
            } else if (this.seconds < that.seconds) {
                return -1;
            } else if (this.seconds > that.seconds) {
                return 1;
            }

            return 0;
        }

        @Override
        public String toString() {
            String hourString = String.valueOf(hours);
            if (hours < 10) {
                hourString = "0" + hourString;
            }

            String minutesString = String.valueOf(minutes);
            if (minutes < 10) {
                minutesString = "0" + minutesString;
            }

            String secondsString = String.valueOf(seconds);
            if (seconds < 10) {
                secondsString = "0" + secondsString;
            }

            return hourString + ":" + minutesString + ":" + secondsString;
        }
    }

    private class Event {
        private String name;

        public Event(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
