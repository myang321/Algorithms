package leetcode;

import java.util.Arrays;
import java.util.Comparator;

import leetcode.model.Interval;

public class MeetingRooms {

	public static void main(String[] args) {
		MeetingRooms m = new MeetingRooms();
		Interval[] intervals = new Interval[3];
		intervals[0]=new Interval(0,5);
		intervals[1]=new Interval(5,10);
		intervals[2]=new Interval(15,20);
		System.out.println(m.canAttendMeetings(intervals));

	}

	// Given an array of meeting time intervals consisting of start and end
	// times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend
	// all meetings.
	//
	// For example,
	//
	// Given [[0, 30],[5, 10],[15, 20]],
	// return false.

	public boolean canAttendMeetings(Interval[] intervals) {
		Arrays.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		for (int i = 0; i < intervals.length - 1; i++) {
			if (intervals[i].end > intervals[i + 1].start)
				return false;
		}
		return true;
	}

}
