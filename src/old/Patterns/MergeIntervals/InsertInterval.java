package javaSolutions.src.old.Patterns.MergeIntervals;

import java.util.ArrayList;
import java.util.List;

class InsertInterval {

  public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> mergedIntervals = new ArrayList<>();
    for (int i = 0; i < intervals.size(); i ++) {
      Interval interval = intervals.get(i);
      if (interval.start > newInterval.end) {
        mergedIntervals.add(newInterval);
        for (int j = i; j < intervals.size(); j ++) {
          mergedIntervals.add(intervals.get(j));
        }
        return mergedIntervals;
      } else if (interval.end < newInterval.start) {
        mergedIntervals.add(interval);
      } else {
        newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end));
      }
    }

    mergedIntervals.add(newInterval);
    return mergedIntervals;
  }

  public static void main(String[] args) {
      List<Interval> input = new ArrayList<>();
    input.add(new Interval(1, 3));
    input.add(new Interval(5, 7));
    input.add(new Interval(8, 12));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<>();
    input.add(new Interval(1, 3));
    input.add(new Interval(5, 7));
    input.add(new Interval(8, 12));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<>();
    input.add(new Interval(2, 3));
    input.add(new Interval(5, 7));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();
  }
}