/**
 * Homework #2.
 * This program .
 * 
 * Authors: Mengdi Wei (mwei6@ucsc.edu)
 * 
 */
import java.util.*;
import java.io.*;

public class ChessBoard {
     int number;
     int number2;
     int number3;
     String character;
     boolean right;
    public static void main (String[] args) throws Exception {
    
       ChessBoard exe=new ChessBoard();
       exe.Linked();
     
  }

   void Linked () throws Exception {
     Scanner in= new Scanner(new FileInputStream("input.txt"));
     FileWriter fw = new FileWriter("analysis.txt");
       while (in.hasNextLine()) {
        int count = 0;
        int count2 = 0;
        number=in.nextInt();
        ChessPiece c = new ChessPiece();
       ChessPiece temp=new ChessPiece();
       String line = in.nextLine().trim() + " "; 
       String[] token = line.split("\\s+");  
       for(int i=0; i<token.length; i++){
            character = token[i];
            number2=Integer.parseInt(token[++i]);
            number3=Integer.parseInt(token[++i]);
       if (character.equals("r")) {
       c=new Rook(number,number2,number3,character);
       c.add(c,temp);
       }
       if (character.equals("R")) {
       c=new Rook(number,number2,number3,character);
       c.add(c,temp);
       }
       if (character.equals("q")) {
       c=new Queen(number,number2,number3,character);
       c.add(c,temp);
       }
       if (character.equals("Q")) {
       c=new Queen(number,number2,number3,character);
       c.add(c,temp);
       }
       if (character.equals("k")) {
       c=new King (number,number2,number3,character);
       c.add(c,temp);
       }
       if (character.equals("K")) {
       c=new King(number,number2,number3,character);
       c.add(c,temp);
       }
       if (character.equals("b")) {
       c=new Bishop(number,number2,number3,character);
       c.add(c,temp);
       }
       if (character.equals("B"))  {
       c=new Bishop(number,number2,number3,character);
        c.add(c,temp);
       }
         if (character.equals("N"))  {
       c=new Knight(number,number2,number3,character);
        c.add(c,temp);
       }
         if (character.equals("n"))  {
       c=new Knight(number,number2,number3,character);
        c.add(c,temp);
       }
         if (character.equals("P"))  {
       c=new blackPawn(number,number2,number3,character);
        c.add(c,temp);
       }
       if (character.equals("p"))  {
       c=new whitePawn(number,number2,number3,character);
        c.add(c,temp);
       }
       }
      String line2 = in.nextLine().trim() + " "; 
      String[] token2 = line2.split("\\s+");
         number2= Integer.parseInt(token2[0]);
         number3= Integer.parseInt(token2[1]);
       ChessPiece current = temp.head;
       if (validKing(temp)) {
          fw.write("Invalid"+"\n");
           continue;
       }
       while (current!=null) {
        if(valid(temp, current)) {
           fw.write("Invalid"+"\n");
             count=1;
             break;
         }
        current=current.next; 
       }
        if(count==1) {
         continue;
        }
       fw.write(search(temp,number2,number3)+" ");
       ChessPiece current3 = temp.head;
          while (current3!=null) {
          if(findAttacking (temp.head,current3)!=null) {
             count++;
          fw.write(""+findAttacking (temp.head,current3));
          fw.write(""+current3+"\n");
          break;
          }
           current3=current3.next;
        }
         if(count==0) {
           fw.write("-"+"\n");
          }
      }
       fw.close();
    }
    ChessPiece findAttacking (ChessPiece current2, ChessPiece cHead) {
    while (current2 != null) {
        if (current2.col==cHead.col&&cHead.row==current2.row) {
           current2=current2.next;
           continue;
          }
       if (current2.isAttacking(cHead)) {
          
          return current2;
        }
     current2=current2.next;
     }
      return null;
    }

     String search(ChessPiece c, int col, int row) {
        ChessPiece current = c.head;
        while (current != null) {
          if (current.col == col&& current.row == row) { 
            return current.color;
          }
         current = current.next;
        }
        return "-";  
    }

   boolean valid(ChessPiece c, ChessPiece cHead) {
        int count =0;
         ChessPiece current = c.head;
        while (current!=null) {
          if (current.row==cHead.row&&current.col==cHead.col) {
            if(current.color.equals(cHead.color)) {
              count++;
            if (count==2)
            return true;
          } else {
            return true;
          }
          current=current.next;
        } else
        return false;
  }
  return false;
 }
    boolean validKing(ChessPiece c) {
     int count =0;
    ChessPiece current=c.head;
     while (current!=null) {
         if(current.color.equals("K")) {
            count++;
          }
          if(current.color.equals("k")) {
            count++;
          }
          current=current.next;
        } 
        if (count==2)
        return false;
        else
        return true;
  }
    }
 
  class ChessPiece {
    int number;
    int col;
    int row;
    String color;
    ChessPiece next;
    ChessPiece head;
    public void add(ChessPiece new_Piece, ChessPiece cPiece) {
     new_Piece.next =cPiece.head;
         cPiece.head = new_Piece;
    }
     public String toString() {
      return (color+" "+col+" "+row+" ");
    } 
    boolean isAttacking(ChessPiece c) {
    return true;
    }
 }
 
  class Queen extends ChessPiece {
   Queen(int number,int col, int row, String color) {
    this.col=col;
    this.row=row;
    this.number=number;
    this.color=color;
    next=null;
  }
     boolean isAttacking (ChessPiece c) {
            ChessPiece current = c;
        if (col==current.col||row==current.row) {
           return true;
        }
         for (int i = col, j = row; i >= 0 && j >= 0; i--, j--) {
         if (current.col==i&&current.row==j) {
          return true;
      }
       }

       for(int i = col, j = row;i< number+1 && j<number+1;i++,j++){
         if (current.col==i&&current.row==j) {
          return true;
       }
      }
  
       for (int i = col, j = row; i < number+1 && j >= 0; i++, j--) {
         if (current.col==i&&current.row==j) {
          return true;
         }
       }

        for (int i = col, j = row; i > 0 && j < number+1; i--, j++) {
         if (current.col==i&&current.row==j) {
           return true;
       }
   }
              return false;
      
     }
   }
   
   
  class King extends ChessPiece {
   public King(int number,int col,  int row, String color) {
    this.col=col;
    this.row=row;
    this.number=number;
    this.color=color;
    next=null;
   }
    boolean isAttacking (ChessPiece c) {
         ChessPiece current = c;

      if(current.col==col+1 && current.row==row+1){
        return true;
      }

      if(current.col==col && current.row==row+1){
        return true;
      }

      if(current.col==col-1 && current.row==row+1){
        return true;
      }
      if(current.col==col-1 && current.row==row){
        return true;
      }

      if(current.col==col+1 && current.row==row){
        return true;
      }

      if(current.col==col-1 && current.row==row-1){
        return true;
      }
       if(current.col==col && current.row==row-1){
        return true;
      }

       if(current.col==col+1 && current.row==row-1){
        return true;
      }
      return false;

     }
    }
   
   class Rook extends ChessPiece {
       public Rook (int number,int col, int row,  String color) {
         this.col=col;
         this.row=row;
         this.number=number;
         this.color=color;
         next=null;
       }
      boolean isAttacking (ChessPiece c) {
        ChessPiece current = c;

        for (int i = 0; i < number; i++) {
         if (col==current.col||row==current.row) {
          return true;
        }
      }
        return false;
   }
    }
   
   class Bishop extends ChessPiece {
    public Bishop(int number,int col, int row, String color) {
     this.col=col;
     this.row=row;
     this.number=number;
     this.color=color;
     next=null;
   }
     boolean isAttacking (ChessPiece c) {
       ChessPiece current = c;
       for (int i = col, j = row; i >= 0 && j >= 0; i--, j--) {
         if (current.col==i&&current.row==j) {			
          return true;
      }
       }

       for(int i = col, j = row;i< number+1 && j<number+1;i++,j++){
         if (current.col==i&&current.row==j) {
          return true;
       }
      }
  
       for (int i = col, j = row; i < number+1 && j >= 0; i++, j--) {
         if (current.col==i&&current.row==j) {
          return true;
         }
       }

        for (int i = col, j = row; i > 0 && j < number+1; i--, j++) {
         if (current.col==i&&current.row==j) {
           return true;
       }
   }
      return false;
     }

 }

 class Knight extends ChessPiece {


 public Knight(int number,int col, int row,  String color) {
    this.col=col;
    this.row=row;
    this.number=number;
    this.color=color;
    next=null;
 }
     void tack() {}
     boolean isAttacking(ChessPiece c){
       ChessPiece current = c;

      if(current.col==col+1 && current.row==row+2){
        return true;
      }
      if(current.col==col+2 && current.row==row+1){
        return true;
      }
      if(current.col==col+2 && current.row==row-1){
        return true;
      }
      if(current.col==col+1 && current.row==row-2){
        return true;
      }
      if(current.col==col-1 && current.row==row-2){
        return true;
      }
      if(current.col==col-2 && current.row==row-1){
        return true;
      }
      if(current.col==col-2 && current.row==row+1){
        return true;
      }
      if(current.col==col-1 && current.row==row+2){
        return true;
      }
            return false;
    }

  }
  class whitePawn extends ChessPiece {
    public whitePawn(int number,int col, int row, String color) {
     this.col=col;
     this.row=row;
     this.number=number;
     this.color=color;
     next=null;
   }
     boolean isAttacking (ChessPiece c) {
       ChessPiece current = c;
         if (current.col==col+1&&current.row==row+1) {
          return true;
      }
         if (current.col==col-1&&current.row==row+1) {
          return true;
       }
  return false;
     }

 }
   class blackPawn extends ChessPiece {
    public blackPawn(int number,int col, int row, String color) {
     this.col=col;
     this.row=row;
     this.number=number;
     this.color=color;
     next=null;
   }
     boolean isAttacking (ChessPiece c) {
       ChessPiece current = c;
         if (current.col==col-1&&current.row==row-1) {
          return true;
      }
         if (current.col==col+1&&current.row==row-1) {
          return true;
       }
  return false;
     }

 }