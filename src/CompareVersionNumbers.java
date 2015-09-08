public class CompareVersionNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String version1 = "1";
		String version2 = "1.1";
		String[] a1 = version1.split("\\.");
		// System.out.println(a1.length);
		CompareVersionNumbers c = new CompareVersionNumbers();
		System.out.println(c.compareVersion(version1, version2));
	}

	public int compareVersion(String version1, String version2) {
		String[] a1 = version1.split("\\.");
		String[] a2 = version2.split("\\.");
		int n1;
		int n2;
		int len1 = a1.length;
		int len2 = a2.length;
		for (int i = 0; i < Math.max(len1, len2); i++) {
			n1 = 0;
			n2 = 0;
			if (len1 > i)
				n1 = Integer.parseInt(a1[i]);
			if (len2 > i)
				n2 = Integer.parseInt(a2[i]);
			System.out.println(n1);
			System.out.println(n2);
			System.out.println();
			if (n1 > n2)
				return 1;
			else if (n1 < n2)
				return -1;
		}
		return 0;
	}
}
