import java.util.*;
import java.io.*;



class args {
  public static void main(String[] args) throws  FileNotFoundException{
  if (args.length <1) {
  // throw new ArrayIndexOutOfBoundsException("0000000");
   //throw new FileNotFoundException("0");
  }//
  FileInputStream in = new FileInputStream ("mark.txt");
  Scanner scan = new Scanner(in);
  varArgs(1,2,"three",4.4);
  varArgs("five",6);
  varArgs();
 }
  static void varArgs(Object... args) {
     for(Object obj : args) {
       System.out.print(obj + ", ");
      }
  if (args.length > 0)
     System.out.println(args[0]);
  else
     System.out.println("no args");
   }
}