import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestNumber l= new LargestNumber();
		int []num={38,3812,3899,383,384};
		System.out.println(l.largestNumber(num));

	}

	// example: 52,5299,5211,59,5
	// order: 59,5,5299,52,5211

	// example: 38,3821,3899
	// order: 3899,38,3821

	// first: compare digit by digit
	// then: for abcdefg & ab
	// if cd >ab, abcd>ab
	// efg doesn't matter

	// for abc & ab
	// compare ca>ab

	// for abcde & abc
	// compare dea>abc

	// for abcd & abc
	// compare dab>abc

	// for abc & abefg
	// compare cabefg>efgabc
	public String largestNumber(int[] num) {
		int len = num.length;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int e : num) {
			arr.add(e);
		}
		Collections.sort(arr, new Mycom());
		StringBuffer sb = new StringBuffer();
		boolean flag=true;
		for (Integer e:arr){
			if(flag){
				if(e==0)
					continue;
				else
					flag=false;
			}
			sb.append(e);
		}
		if (sb.length()==0)
			sb.append("0");
		return sb.toString();

	}
	public static String toStr(int n){
		Integer i=new Integer(n);
		return i.toString();
	}

	class Mycom implements Comparator<Integer> {
		@Override
		public int compare(Integer a, Integer b) {
			String sa=toStr(a);
			String sb=toStr(b);
			StringBuffer sb1=new StringBuffer(sa+sb);
			StringBuffer sb2=new StringBuffer(sb+sa);
			return -sb1.toString().compareTo(sb2.toString());
		}
	}

}
