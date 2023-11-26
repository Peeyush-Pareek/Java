import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
public class JavaFileIOExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try{
		FileOutputStream finput=new FileOutputStream("fileio.txt");    
	     BufferedOutputStream bout=new BufferedOutputStream(finput);    
	     String s="Welcome to FileInputOutput Class.";    
	     byte b[]=s.getBytes();    
	     bout.write(b);    
	     bout.flush();    
	     bout.close();    
	     finput.close();    
	     System.out.println("success"); 
	        // to read  from file
	       
	            FileInputStream foutput=new FileInputStream("fileio.txt");
	            int i;
	            // to read single character from file
	           /* 
	           i=fio.read();
	            System.out.println((char)i);
	            */
	            // to read complete file
	            i=0;    
	            while((i=foutput.read())!=-1){    
	             System.out.print((char)i); }
	            foutput.close();
	        }catch(Exception e){System.out.println(e);}

	}

}
