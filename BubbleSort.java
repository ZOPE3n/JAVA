class BubbleSort{
	public static void main(String[] args) {
		int[] num={8,89,56,79,5,1,100,598,778,-89,-50};
		int x=0,y=0;
		BubbleSort(num);
		for(int i=0;i<num.length;i++) 
			System.out.println(num[i]);
			if(x==1||y==0)
			System.out.println(8);
		
	}
  static void BubbleSort(int[] n) {
  	int bottom =n.length;
  	int temp;
  	for (int i=0;i<bottom;i++) {
  		for(int s=i+1;s<bottom;s++) {
  			if(n[i]>n[s]) {
  				temp=n[i];
  				n[i]=n[s];
  				n[s]=temp;
  			}
  		}
  	}
  }
}