class Bubble {
	public static void main (String[] args) {
		int[] num={4,6,5,8,3,7,2,1};
		sort(num);
		for(int i=0; i<num.length;i++) {
			System.out.print(num[i]);
		}
	}
	static void sort (int[] num) {
		int len=num.length;
		int temp;
		for (int i=0;i<len-1;i++) {
			for (int s=0;s<len-1;s++) {
					if (num[s]<num[s+1]) {
				  temp=num[s];
					num[s]=num[s+1];
					num[s+1]=temp;
				}
			}
		}
	}
}