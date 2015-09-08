public class Single_Number {

	public static void main(String[] args) {
		int [] B = {1,2,3,2,1};
		
		System.out.println(Single_Number.singleNumber(B));

	}

	public static  int singleNumber(int[] A) {
		int single = 0;
		for (int i :A) {
			single = single ^ i;
		}
		return single;
	}

}
