class Person{
 String name;
}
//single inheritance
class Employee extends Person{
 float salary=48000;
}
// hierarchical inheritance
class Student extends Person{
int rollno;
}
// multilevel inheritance
class Programmer extends Employee{
 int bonus=12000;
 public static void main(String args[]){
   Programmer p1=new Programmer();
    Student s1= new Student();
   p1.name="XYZ";
   System.out.println("Programmer name is:"+p1.name);
   System.out.println("Programmer salary is:"+p1.salary);
   System.out.println("Bonus of Programmer is:"+p1.bonus);
   s1.name="ABC";s1.rollno=1234;
   System.out.println("Student name is:"+s1.name);
   System.out.println("Student Roll No. is:"+s1.rollno);
}
}
