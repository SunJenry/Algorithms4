package org.sun.chapter1.section2.exe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Exercise11 {
    public static void main(String[] args) {

    }

    public static class SmartDate {
        public static String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        private int day;
        private int month;
        private int year;


        public SmartDate(int day, int month, int year) {

            boolean dateValid = isDateValid(day, month, year);
            if (!dateValid) throw new RuntimeException("Invalid date!");

            this.day = day;
            this.month = month;
            this.year = year;
        }

        public SmartDate(String date) {
            String[] split = date.split("/");
            month = Integer.parseInt(split[0]);
            day = Integer.parseInt(split[1]);
            year = Integer.parseInt(split[2]);
        }

        @Override
        public String toString() {
            return month + "/" + day + "/" + year;
        }

        private boolean isDateValid(int day, int month, int year) {
            // TODO: 2023/1/28
            return true;
        }

        public String dayOfTheWeek() {
            Calendar calendar = Calendar.getInstance();
            Date date;

            try {
                date = new SimpleDateFormat("MM/dd/yyyy").parse(this.toString());
                calendar.setTime(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            return days[dayOfWeek - 1];
        }
    }
}
