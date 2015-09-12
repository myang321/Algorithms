package leetcode;
public class ReverseWordsinaString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String reverseWords(String s) {
		s = s.trim();
		String[] arr = s.split(" ");
		StringBuffer sb= new StringBuffer();
		for (int i=0;i<arr.length;i++){
			if (arr[i].length()==0)
				continue;
			if (i!=0)
				sb.insert(0," ");
			sb.insert(0, arr[i]);
		}
		return sb.toString();
	}

}
