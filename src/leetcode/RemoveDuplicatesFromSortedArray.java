
public class RemoveDuplicatesFromSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 1 };
		removeDuplicates(a);
	}
	public static int removeDuplicates(int[] A) {
		if (A==null || A.length==0)
			return 0;
		int index =0;
		for (int i=0;i<A.length;i++){
			if (A[index]==A[i])
				continue;
			else
			{
				index++;
				A[index]=A[i];
			}
		}
		return index +1;
    }

}
