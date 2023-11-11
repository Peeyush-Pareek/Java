public class JavaExceptionEg{  
  public static void main(String args[]){  
   try{  
      //code that may raise exception  
      int data=200/0;  
   }catch(ArithmeticException e){System.out.println(e);}  
   //rest code of the program   
   System.out.println("out of catch block");  
  }  
}  
