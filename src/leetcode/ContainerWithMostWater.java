package leetcode;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxArea(int[] height) {
		int len = height.length;
		int left = 0;
		int right = len - 1;
		int max = 0;
		while (left < right) {
			max = Math.max(max,
					(right - left) * Math.min(height[right], height[left]));
			if (height[left] < height[right])
				left++;
			else
				right--;
		}
		return max;
	}

}
