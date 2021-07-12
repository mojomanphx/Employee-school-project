//Jeriod Ruschell, CIS163AA, MEID JER2181272
//Final Project Exercise 4 Pay
//written on 8/28/20

import javax.swing.*; 


public class Pay
{//begin class
   private static final double payL1 = 17.00, payL2 = 20.00, payL3 = 22.00; //final variable for pay scale.  
   private static final double MEDDED = 32.00, DENTDED = 20.00, LTDISDED = 10.00, RETIRE = .03; //final variable for insurance deductions
   private static final int MAX_HRS = 40; //final for Max regular hours
   private static final double OTLV1 = payL1 * 1.5, OTLV2 = payL2 * 1.5, OTLV3 = payL3 * 1.5; //factors OT rates from pay scale
   private int skill, x; //user entry variable
   private String name; //user entry variable  
   private double payRate, otHours, totalHrs, totalPay, weekHrs, otRate, deduction; //user entry variable and operational variables
   private boolean medical = false, dental = false, disability = false, retirement = false; //boolean to be used in output
   private double retireAmt; 
   private double netPay; 
   //Constructor obtains user needed information
   public Pay()
   {
      do//Do loop to cycle if user enters numbers outside 1 2 or 3; 
      {
         skill =Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter your Job Skill Level >>"));//assigns skill level 
         
         switch (skill)//analyzes skill level for appropriate pay information
         {
            case 1://assigns level 1 pay/ot rate
            {  
             payRate = payL1; 
             otRate = OTLV1;
             break;             
            }
            case 2://assigns level 2 pay/ot rate 
            {
               payRate = payL2;
               otRate = OTLV2;
               break; 
            }
            case 3://assigns level 3 pay/ot rate
            {
               payRate = payL3; 
               otRate = OTLV3;
               break;  
            }
            default://shows message of an invalid entry
            {  JOptionPane.showMessageDialog(null, "Sorry that is not a valid entry!"); 
               break; 
            }            
          }
       }while (skill > 3 || skill <= 0 );
      name = JOptionPane.showInputDialog(null, "Please enter your name, leave one space between First and Last Name >>");//collects name from user 
      totalHrs =Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the Total number of hours worked this week >>"));//collects total hours worked
      if (totalHrs > MAX_HRS)
      {
         weekHrs = MAX_HRS; //sets weekly hours to max hours
         otHours = totalHrs - MAX_HRS; //calculates OT hours
         totalPay = (weekHrs * payRate) + (otHours * otRate);//calculates total pay for week
         retireAmt  = totalPay * RETIRE; //facors retirement amount to deduct
                  
      }
      else
      {
         weekHrs = totalHrs; //assigns weekly hours
         totalPay = weekHrs * payRate; //factors total pay for week 
         retireAmt = totalPay * RETIRE; //facors retirement amount to deduct
      }
   }
   
   public void getMedical()
   {//offers medical for eligible employee
      x = JOptionPane.showConfirmDialog (null, "Add Medical insurance for $"+MEDDED); 
      if ( x == JOptionPane.YES_OPTION)
      {
         deduction = deduction + MEDDED; //adds proper deduction
         medical = true;//enrolls in program        
      }
      x = 999; //resets variable 
   }
   
    public void getDental()
   {//Offers dental for eligible employee
      x = JOptionPane.showConfirmDialog (null, "Add Dental insurance for $"+DENTDED); 
      if ( x == JOptionPane.YES_OPTION)
      {
         deduction = deduction + DENTDED;//adds proper deduction 
         dental = true;//enrolls in program        
      }
      x = 999;//resets variable 
   }
   
    public void getDisability()
   {//Offers disability for eligible employee
      x = JOptionPane.showConfirmDialog (null, "Add Long Term Disability insurance for $"+LTDISDED); 
      if ( x == JOptionPane.YES_OPTION)//analyzes for yes click
      {
         deduction = deduction + LTDISDED; //adds proper deductions
         disability = true;//enrolls in program        
      }
      x = 999; //resest variable 
   }
   
    public void getRetirement()
   {//dialog box to offer retirement benefit
      x = JOptionPane.showConfirmDialog (null, "Add to a 401K at "+RETIRE * 100+"% or $"+retireAmt);//assigns click to variable  
      if ( x == JOptionPane.YES_OPTION)//analyzes for yes click 
      {
         deduction = deduction + retireAmt; //adds to deductions
         retirement = true;//enrolls in program        
      }
      x = 999;//resets variable
   }
   
   public void Benefits()//method analyzes skill level and offer appropriate benefit options
   {
      if(skill == 1)
      {
         JOptionPane.showMessageDialog(null, "You are not eligible for Benefits at this time. ");//informs of ineligibility 
         deduction = 0; //ensures deductions at zero
         
      }
      
      if (skill == 2)
      {
         getMedical();//calls to medical method for medical insurance 
         getDental(); //calls to dental insurance method 
         getDisability();//calls to Disability insurance method 
         
      }
      
      if (skill == 3)
      {
         getMedical(); //calls to medical insurance method 
         getDental(); //calls to dental insurance method 
         getDisability(); //calls to disability insurance method
         getRetirement();//calls to retirement benefit method
           
      }
      netPay = totalPay - deduction;//calculates net pay 

   }
   public void Output()
   {
      if(skill == 1)//if skill level 1 creates output with appropriate deductions
      {
         JOptionPane.showMessageDialog(null, "PAYROLL INFORMATION \n\n"+name+"\n\n"+
                                       "Weekly Hours: "+totalHrs+"\n"+
                                       "Regular Hours: "+weekHrs+"\t PayRate: $"+payRate+"\n"+
                                       "Overtime Hours: "+otHours+"\t Overtime Rate: $"+OTLV1+"\n\n"+
                                       "Total Earnings: $"+totalPay); 
      } 
      
      if(skill == 2)//if skill level 2 creates output with appropriate deductions
      {
         JOptionPane.showMessageDialog(null, "PAYROLL INFORMATION \n\n"+name+"\n\n"+
                                       "Weekly Hours: "+totalHrs+"\n"+
                                       "Regular Hours: "+weekHrs+"\t PayRate: $"+payRate+"\n"+
                                       "Overtime Hours: "+otHours+"\t Overtime Rate: $"+OTLV2+"\n\n"+
                                       "Total Earnings: $"+totalPay+"\n\n"+
                                       "DEDUCTIONS\n\n"+
                                       "Medical Insurance: $"+MEDDED+"\t Enrolled: "+medical+"\n"+
                                       "Dental Insurance: $"+DENTDED+"\t Enrolled: "+dental+"\n"+
                                       "Long Term Disability: $"+LTDISDED+"\t Enrolled "+disability+"\n\n"+
                                       "Total Deductions: $"+deduction+"\n\n\n"+
                                       "Net Earnings: $"+netPay); 
                                  
      }  
      
      if (skill == 3)//if skill level 3 creates output with appropriate deductions
      {
         JOptionPane.showMessageDialog(null, "PAYROLL INFORMATION \n\n"+name+"\n\n"+
                                       "Weekly Hours: "+totalHrs+"\n"+
                                       "Regular Hours: "+weekHrs+"\t PayRate: $"+payRate+"\n"+
                                       "Overtime Hours: "+otHours+"\t Overtime Rate: $"+OTLV3+"\n\n"+
                                       "Total Earnings: $"+totalPay+"\n\n"+
                                       "DEDUCTIONS\n\n"+
                                       "Medical Insurance: $"+MEDDED+"\t Enrolled: "+medical+"\n"+
                                       "Dental Insurance: $"+DENTDED+"\t Enrolled: "+dental+"\n"+
                                       "Long Term Disability: $"+LTDISDED+"\t Enrolled "+disability+"\n"+
                                       "Retirement : "+RETIRE * 100+"% or $"+retireAmt+"\n\n"+
                                       "Total Deductions: $"+deduction+"\n\n\n"+
                                       "Net Earnings: $"+netPay); 
 

      }
                                                                                
   }
   
   public static void main(String[] args)
   {
     Pay player1 = new Pay(); 
     player1.Benefits(); 
     player1.Output(); 

   }



   
      
}//end class
