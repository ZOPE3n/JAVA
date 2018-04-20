import java.util.*;
import java.io.*;
public class BOJ{ 
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan=new Scanner(System.in);
		Scanner in=new Scanner(new FileInputStream(args[0]));
		String str=scan.next();
		int size=in.nextInt();
		int a=0;
		String[] sb=new String[size];
		
		while (a<size) {
	  String str2=in.next();
	  sb[a]=str2;
	  a++;
	}
	 for (int s=0;s<size;s++) {
	 	
	 	if (multi(str,sb[s])) {
	 		System.out.println(sb[s]);
	}
	}
}
	static boolean multi(String p, String o) {
	
	HashMap<String,Integer> hmap=new HashMap<String,Integer>();
		
		Random rnd=new Random(1000000);
		int n=1;
		int m=1;
		int v=0;
		if(p.length()<o.length())
		v=o.length();
		else if(p.length()>o.length())
	   v=p.length();
	  else if(p.length()>o.length())
	   v=p.length();
      int c=0;
   while(c<v) {
		 int d=rnd.nextInt();
	for(int i=0;i<p.length();i++) {
		 
			
			int num=p.length();
		
			
			String a=p.substring(num-1);
			
		  
		  hmap.put(a,d);
		  int b=hmap.get(a);
		  
			n=n*b;
		
			num--;
			
			i++;
		}
			for(int i=0;i<o.length();i++) {
		 
			int num=o.length();
		
		
			String a=o.substring(num-1);
		  
		  hmap.put(a,d);
		  int b=hmap.get(a);
		  
			m=m*b;
		
			num--;
			
			i++;
		}
	}
		if(n==m)
		 return true;
		else
		 return false;
		
	}

}