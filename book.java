import java.util.*;
import java.io.*;

public class book{
	static int sum=0;
	static int sum2=0;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan=new Scanner(System.in);
	  Scanner in= new Scanner(new FileInputStream(args[0]));
		int size =in.nextInt();
		int i=0;
		String s1=scan.next();
		String[] str=new String[size];
		while(i<size) {
		 str[i]=in.next();
		 i++;
		}
		String[] s3={"works", "asad", "skwor"};
		int n=0;
		while(n<size) {
		String s2=s3[n];
		byte[] bt=s1.getBytes();
		byte[] bt2=s2.getBytes();
		if (sort(bt,bt2)) 
			System.out.println("true");
	   else
	    System.out.println("false");
	   n++;
 }
}

  public static boolean sort(byte[] a, byte[] b) {
  	for(int i=0; i<a.length; i++) {
  		sum+=a[i];
  	}
  	for(int n=0;n<b.length;n++) {
  		sum2+=b[n];
  	}
  	if(sum==sum2) {
  		return true;
  	}
  	else {
  	 return false;
  	}
  }
}