//Chapter 7 Exercise 1 Employee Scheduler 
//written by Jeriod Ruschell on 7/14/2020
import java.util.Scanner; 
public class EmployeeScheduler
{
   public static void main(String[] args)
   { 
      //declarations
      String userEntry; 
      String parseInfo;
      int length; 
      int spaceLoc;
      char contLoop; 
      boolean contEntry;
      do//Overall control loop
      {  
      Scanner input = new Scanner(System.in); 
      Employee empOne = new Employee(); //New instance of employee class 
    
      System.out.println("Please enter Employee First Name, Last Name, Employee ID, Wage "); 
      System.out.println("Please leave one space between each piece of information!");
      System.out.println("Please enter the information below:");
      
      userEntry = input.nextLine(); //accepts user entry
      userEntry = userEntry.trim(); //trims unwanted data from the ends of statement 
      
      StringBuilder userString = new StringBuilder(userEntry); //Passes user entry to stringbuilder to modify 
      length = userEntry.length(); 
      userString = userString.append(" "); //adds space to the end of the statement
      for(int x = 0 ; x < length ;++x )//for statement to parse out sentence into seperate variables.  
      {
         spaceLoc = userString.indexOf(" ",x);//Locates the next instance of space past x
         parseInfo = userString.substring(x, spaceLoc); //splits word from sentence
         
         if(empOne.firstName == null)//Nested if statement to drop parsed information into appropriate variables.  
         {
            empOne.firstName = parseInfo; 
             
         }   
         else
         {
            if(empOne.lastName == null)
            {
               empOne.lastName = parseInfo; 
                
            }
            else
            {//3
               if(empOne.empID == 0)
               {  parseInfo = parseInfo.trim(); 
                  empOne.empID = Integer.parseInt(parseInfo); 
                  
               }
               else
               {//3
                  if(empOne.wage == 0)
                  {
                     empOne.wage = Double.parseDouble(parseInfo); 
                     
                  }
               }//4
            }//3
         }//2
         
         x = spaceLoc ;//changes control loop to space location(one is added to this each iteration to begin the next word
        
         
         
        
      }//1
      empOne.Output();//Output for employee information that was entered
      System.out.println(); 
      System.out.println("Would you like to enter another employee, Type Y to continue or N to exit");//User control question
      contLoop = input.next().toUpperCase().charAt(0);//Pulling and modifying char from user control question
       
      
      
      if (contLoop == 'Y')//If statement to test and see if would like to contine.  
      { contEntry = true; }
      else
      { contEntry = false; }   
        
      }while (contEntry == true);//Overall control question.        
   }
}