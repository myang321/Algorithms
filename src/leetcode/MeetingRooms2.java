package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import leetcode.model.Interval;

public class MeetingRooms2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Given an array of meeting time intervals consisting of start and end
	// times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of
	// conference rooms required.
	//
	// For example,
	// Given [[0, 30],[5, 10],[15, 20]],
	// return 2.

	// sort by start time, if one cannot be added, increase count
	public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;
		Arrays.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.add(intervals[0].end);
		for (int i = 1; i < intervals.length; i++) {
			int minEnd = queue.poll();
			if (minEnd > intervals[i].start) {
				queue.add(intervals[i].end);
			} else {
				minEnd = intervals[i].end;
			}
			queue.add(minEnd);
		}
		return queue.size();
	}
}
