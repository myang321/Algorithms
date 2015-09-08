public class RemoveElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 3,1,3,3,3 };

		removeElement2(A, 3);
	}

	public static int removeElement(int[] A, int elem) {
		int len = A.length;
		for (int i = 0; i < len; i++) {
			if (A[i] == elem) {
				if (len-1==i)
					return len-1;
				A[i] = A[len - 1];
				len--;
				if (A[i] == elem)
					i--;
			}
		}
		return len;

	}
	
	public static int removeElement2(int[] A, int elem) {
        int i = 0;
        int pointer = A.length - 1;
        while(i <= pointer){
            if(A[i] == elem){
                A[i] = A[pointer];
                pointer--;
            } else {
                i++;
            }
        }
        return pointer + 1;
    }

}
