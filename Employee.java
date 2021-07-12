//Chapter 7 Exercise 1 Employee class 
//written by Jeriod Ruschell on 7/14/2020

public class Employee
{  //declarations 
   String firstName=  null; 
   String lastName = null; 
   int empID = 0; 
   double wage = 0; 
   //set methods for class fields
   public void setFirstName(String fn)
   { firstName = fn; }
   public void setLastName(String ln)
   { lastName = ln; }
   public void setEmpID(int id)
   { empID = id; }
   public void setWage (double mny)
   { wage = mny; }
   //get methods for class fields
   public String getFirstName()
   { return firstName; }
   public String getLastName()
   { return lastName; }
   public int getEmpID()
   { return empID; }
   public double getWage()
   { return wage; }
   
   public void Output()
   {  //Output method to the scanner class.  
      System.out.println("You entered the following:"); 
      System.out.println("First Name:"+firstName+" Last Name: "+lastName); 
      System.out.println("Employee ID number: "+empID); 
      System.out.println("Employee Wage : $"+wage); 
   }
}