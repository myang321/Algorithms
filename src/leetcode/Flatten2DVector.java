package leetcode;

import java.util.Iterator;
import java.util.List;

public class Flatten2DVector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Vector2D {
	Iterator<List<Integer>> vec2d;
	Iterator<Integer> currentList;

	public Vector2D(List<List<Integer>> vec2d) {
		this.vec2d = vec2d.iterator();
	}

	public int next() {
		if (hasNext()) {
			return currentList.next();
		}
		return 0;
	}

	public boolean hasNext() {
		while ((currentList == null || !currentList.hasNext())
				&& vec2d.hasNext())
			currentList = vec2d.next().iterator();
		return currentList != null && currentList.hasNext();
	}
}
