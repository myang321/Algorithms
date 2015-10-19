package leetcode;
import java.util.ArrayList;

import leetcode.model.Interval;

public class InsertInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertInterval i = new InsertInterval();
		Interval i1 = new Interval(1, 5);
		Interval i2 = new Interval(6, 8);
		Interval i3 = new Interval(5, 6);
		ArrayList<Interval> array = new ArrayList<Interval>();
		array.add(i1);
		array.add(i2);
		i.insert(array, i3);

	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		if (intervals.size() == 0) {
			result.add(newInterval);
			return result;
		}
		if (intervals.get(0).start > newInterval.start) {
			Interval tmp = newInterval;
			newInterval = intervals.get(0);
			intervals.set(0, tmp);
		}
		int i;
		for (i = 0; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if (newInterval.start < curr.start) {
				break;
			}
			if (curr.end < newInterval.start)
				result.add(curr);
			else {
				newInterval.start = Math.min(curr.start, newInterval.start);
				newInterval.end = Math.max(curr.end, newInterval.end);
			}
		}
		boolean flag = false;
		for (; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if (newInterval.end >= curr.start)
				newInterval.end = Math.max(curr.end, newInterval.end);
			else {
				if (!flag) {
					result.add(newInterval);
					flag = true;
				}
				result.add(curr);
			}
		}
		if (!flag)
			result.add(newInterval);
		return result;
	}
}
