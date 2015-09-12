package leetcode;
import java.util.Stack;

public class SimplifyPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "/home/";
		System.out.println(simplifyPath(s));
	}

	public static String simplifyPath(String path) {
		Stack<String> s = new Stack<String>();
		String[] arr = path.split("/");
		for (String e : arr) {

			if (e.length() == 0)
				continue;
			else if (e.equals("."))
				continue;
			else if (e.equals("..")) {
				if (s.isEmpty() == false)
					s.pop();
			} else
				s.push(e);
		}
		StringBuffer sb = new StringBuffer();
		while (!s.isEmpty())
			sb.insert(0, "/" + s.pop());
		if (sb.length() == 0)
			sb.append("/");
		return sb.toString();
	}

}
