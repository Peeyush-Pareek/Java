class Person{
 String name;
void setparameter(String s){
this.name=s;
}
}
//single inheritance
class Employee extends Person{
 float salary=48000;
//overriding
void setparameter(String s, float sal){
this.name=s;
this.salary=sal;
}
//overloading
void setparameter(){
this.name="LMN";
this.salary=50000;
}
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
// calling overden method
    p1.setparameter("PQR",50000);
    System.out.println("Programmer name is:"+p1.name);
   System.out.println("Programmer salary is:"+p1.salary);
// calling overloaded method
    p1.setparameter();
    System.out.println("Programmer name is:"+p1.name);
   System.out.println("Programmer salary is:"+p1.salary);
   s1.name="ABC";s1.rollno=1234;
   System.out.println("Student name is:"+s1.name);
   System.out.println("Student Roll No. is:"+s1.rollno);
}
}
