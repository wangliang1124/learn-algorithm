package Exercise.Chapter1_2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import edu.princeton.cs.algs4.StdOut;

public class Ex11 {
    public static void main(String[] args) {
        // SmartDate date = new SmartDate(2, 29, 2024);
        // StdOut.println(date);
        // date = new SmartDate(3, 31, 2023);
        // StdOut.println(date);

        SmartDate smartDate1 = new SmartDate(4, 2, 2023);
        StdOut.println(smartDate1.dayOfTheWeek() + " Expected: Sunday");

        SmartDate smartDate2 = new SmartDate(11, 27, 1985);
        StdOut.println(smartDate2.dayOfTheWeek() + " Expected: Wednesday");

    }

    static class SmartDate {
        private final int month;
        private final int day;
        private final int year;

        public SmartDate(int month, int day, int year) {
            isValidDate(month, day, year);
            this.month = month;
            this.day = day;
            this.year = year;
        }

        private boolean isValidDate(int month, int day, int year) {
            // int[] bigMonths = { 1, 3, 5, 7, 8, 10, 12 };
            // int[] smallMonths = { 4, 6, 9, 11 };
            int[] maxNumberOfDaysPerMonth = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

            if (year < 1) {
                throw new IllegalArgumentException("year must >=1 ");
            }

            if (month < 1 || month > 12) {
                throw new IllegalArgumentException("month 1~12");
            }

            if (day < 1 || (day > maxNumberOfDaysPerMonth[month - 1])) {
                throw new IllegalArgumentException(String.format("month is %d, day must between 1~%d\n", month,
                        maxNumberOfDaysPerMonth[month - 1]));
            }

            if (day > 28 && isLeapYear(year)) {
                throw new IllegalArgumentException(
                        String.format("%s is leap year, month is 2, day must between 1~28\n", year));
            }

            return true;
        }

        private boolean isLeapYear(int year) {
            return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
        }

        // public String dayOfTheWeek() {
        // String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday",
        // "Friday", "Saturday" };
        // Calendar calendar = Calendar.getInstance();
        // Date date;
        // try {
        // date = new SimpleDateFormat("MM/dd/yyyy").parse(this.toString()); // new
        // Date(month + "/" + day + "/" +
        // // year);
        // calendar.setTime(date);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        // int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        // return days[dayOfWeek - 1];
        // }

        public String dayOfTheWeek() {
            String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
            int y = year;
            int m = month;
            int d = day;
            int y0 = y - (14 - m) / 12;
            int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
            int m0 = m + 12 * ((14 - m) / 12) - 2;
            int d0 = (d + x + (31 * m0) / 12) % 7;
            return days[d0];
        }

        public String toString() {
            return month + "/" + day + "/" + year;
        }
    }
}
