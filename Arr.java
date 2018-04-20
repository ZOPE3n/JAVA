public class Arr {
	public static void main (String[] args) {
		int[] a1={4,5,6,7};
		int[] a2=(int[])a1.clone();
		for(int d: a2) {
			System.out.println(d);
		}
 }
}