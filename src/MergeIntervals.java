import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size()==0)
			return intervals;
		List<Interval> list = new ArrayList<Interval>();
		Collections.sort(intervals, new myComparator());
		Interval last = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if (curr.start <= last.end)
				last.end = Math.max(curr.end, last.end);
			else {
				list.add(last);
				last = curr;
			}
		}
		list.add(last);
		return list;
	}

	private class myComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.start - o2.start;
		}

	}

}
