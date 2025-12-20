package com.Operations;

import java.util.Scanner;

public class ATM 
{
  private double balance;
  private int pincode;
  public ATM(double initialBalance,int pincode)
  {
	  this.balance=initialBalance;
	  this.pincode=pincode;
  }
  public double getBalance()
  {
	  return this.balance;
  }
  public boolean withdraw(double amount)
  {
	  
	  if(amount>this.balance && amount>0)
	  {
		  return false;
	  }
	  this.balance-=amount;
	  return true;
  }
  public void deposit(double amount)
  {
	  if(amount>0)
	  {
		  
	  this.balance+=amount;
	  System.out.println("Amount Deposited successfully..");
	  }
	  else
	  {
		  System.err.println("Invalid Amount");
	  }
  }
  public boolean transfer(int amount,int pin)
  {
	  if(pin!=this.pincode)
	  {
		  return false;
	  }
	  boolean success=this.withdraw(amount);
	  if(success)
	  {
		  withdraw(amount);
		  return true;
	  }
	  else
	  {
		  return false;
	  }
  }
  
  
  public static void waitForEnter()
  {
	  System.out.println("Enter to know more...🎉🎉🎉✅");
	  Scanner sc=new Scanner(System.in);
	  sc.nextLine();
  }
  
}






