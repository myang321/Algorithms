package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LRUCache {
	private Map<Integer, Integer> map;

	public LRUCache(int capacity) {
		final int cap = capacity;
		map = new LinkedHashMap<Integer, Integer>(16, 0.75f, true) {

			@Override
			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
				return size() > cap;
			}

		};

	}

	public int get(int key) {
		if (map.containsKey(key))
			return map.get(key);
		return -1;
	}

	public void set(int key, int value) {
		map.put(key, value);
	}

}