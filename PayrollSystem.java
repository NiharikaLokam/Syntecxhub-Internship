package com;

import java.util.ArrayList;
import java.util.List;

public class PayrollSystem
{
   private List<Employee> li;

   public PayrollSystem() {
	li=new ArrayList<>();
   }
   
   public void addEmployee(Employee emp)
   {
	   li.add(emp);
   }
   public void removeEmployee(int id)
   {
	   Employee emp=null;
	   for(Employee e:li) {
		   if(e.getId()==id)
		   {
			   emp=e;
			   break;
		   }
	   }
	   if(emp!=null)
	   {
		   li.remove(emp);
	   }
	   System.out.println();
   }
   public void displayEmployee()
   {
	   for(Employee e:li)
	   {
		   System.out.println(e);
	   }
   }
}
