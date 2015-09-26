package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// LinkedList<Integer> queue = new LinkedList<Integer>();
		// queue.add(1);
		// queue.add(2);
		// System.out.println(queue.pop());
		// Deque<Integer> q = new ArrayDeque<>();
		// q.offer(1);
		// q.offer(2);
		// System.out.println(q.poll());
		SlidingWindowMaximum swm = new SlidingWindowMaximum();
		int[] nums = { 4, -2 };
		for (int a : swm.maxSlidingWindow(nums, 2))
			System.out.println(a);
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		int len = nums.length;
		int[] result = null;
		if (len == 0) {
			result = new int[0];
			return result;
		}
		int reLen = len - k + 1;
		result = new int[reLen];
		// store index not value
		// value in queue is descending
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for (int i = 0, j = 0; i < len; i++) {
			if (!queue.isEmpty() && queue.peekFirst() <= i - k) {
				queue.pollFirst();
			}
			while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
				queue.pollLast();
			}
			queue.offerLast(i);
			if (i >= k - 1) {
				result[j++] = nums[queue.peekFirst()];
			}
		}
		return result;
	}
}
