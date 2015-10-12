package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class RepeatedDNASequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> findRepeatedDnaSequences(String s) {
		List<String> result = new ArrayList<String>();
		int len = s.length();
		if (len <= 10)
			return result;
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for (int i = 0; i <= len - 10; i++) {
			String str = s.substring(i, i + 10);
			if (hm.containsKey(str))
				hm.put(str, hm.get(str) + 1);
			else
				hm.put(str, 1);
		}
		Iterator<String> it = hm.keySet().iterator();
		while (it.hasNext()) {
			String str = it.next();
			if (hm.get(str) >= 2)
				result.add(str);
		}
		return result;
	}
}
