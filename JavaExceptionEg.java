public class JavaExceptionEg{  
  public static void main(String args[]){  
   try{  
      //code that may raise exception  
      int data=200/0;  
   }catch(ArithmeticException e){System.out.println(e);}  
    try{ int a[]={1,3,5};
        System.out.println(a[15]) // may throw exception 
          }
    catch(ArrayIndexOutOfBoundsException e) { System.out.println(e); }  
    // handling the exception by using Exception class      
    catch(Exception e)  {  System.out.println(e);  } 
    // finally block is executed regardless of exception occurred or not  
     finally {  System.out.println("from finally block "); }    
   //rest code of the program   
   System.out.println("out of catch block");  
  }  
}  

//exceptions types
//1) ArithmeticException
// int data=200/0;// ArithmeticException
//2) NullPointerException 
//String y=null;  
//System.out.println(y.length());//NullPointerException  
//3) NumberFormatException
//String y="xyz";
//int a=Integer.parseInt(y);//NumberFormatException
// 4) ArrayIndexOutOfBoundsException
//int r[]=new int[4];
//r[15]=26;//ArrayIndexOutOfBoundsException
// to handel exception use try catch
//try{    
  //code that may throw an exception    
// }catch(Exception_class_Name ref){}   
// use finally
///try{    
//code that may throw an exception    
//}finally{} 
