package javaSolutions.src.old.Patterns.MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;

class ConflictingAppointments {

  public static boolean canAttendAllAppointments(Interval[] intervals) {
    if (intervals.length < 2) {
      return true;
    }
    Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));

    Interval interval = intervals[0];
    int i = 1;

    while (i < intervals.length) {
      Interval currentInterval = intervals[i++];
      if (currentInterval.start < interval.end) return false;
      interval = currentInterval;
    }

    return true;
  }

  public static void main(String[] args) {
    Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
    boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
    System.out.println("Can attend all appointments: " + result);

    Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
    result = ConflictingAppointments.canAttendAllAppointments(intervals1);
    System.out.println("Can attend all appointments: " + result);

    Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
    result = ConflictingAppointments.canAttendAllAppointments(intervals2);
    System.out.println("Can attend all appointments: " + result);
  }
}