package com.main;

import java.util.Scanner;

import com.Operations.ATM;
import com.exception.ExceptionAraised;

public class MainClass {

	static Scanner sc=new Scanner(System.in);
	public static void welcome()
	{
		String st=".....Welcome to ATM 🎉🙏💰💵₹....";
		for(int i=0;i<=st.length()-1;i++)
		{
			System.out.print(st.charAt(i));
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
	}
	public static int password()
	{
		System.out.println("Enter You're PIN :");
		return sc.nextInt();
		
	}
	
	public static void main(String[] args) 
	{
		welcome();
		int pin=1234;
		int attempts=3;
		
		while(attempts>0)
		{
			if(password()==pin)
			{
				System.out.println("..✅✅✅Sucess \nNow Perform You're Operations..");
				
				break;
			}
			else
			{
				attempts--;
				System.out.println("Wrong PIN. \n Attempts left: "+attempts);
			}
			if(attempts==0)
			{
				System.out.println("Card Blocked!");
				throw new ExceptionAraised("Try After SomeTime..❌❌");
			}
		}
		ATM atm=new ATM(5000.0,pin);
		while(true)
		{
			System.out.println("1.View Balance");
			System.out.println("2.Withdraw");
			System.out.println("3.Deposit");
			System.out.println("4.Transfer");
			System.out.println("5.Exit");
			System.out.println("Enter your choice:");
	        int choice=sc.nextInt();
	        switch(choice)
	        {
	        case 1:
	        	System.out.println("Your Balance is :"+atm.getBalance());
	        	ATM.waitForEnter();
	        	break;
	        case 2:
	        {
	        	System.out.println("Enter the amount to withdraw  :");
	        	double withdraw=sc.nextDouble();
	        	boolean success=atm.withdraw(withdraw);
	        	if(success)
	        	{
	        		System.out.println("Withdraw succesfull..");
	        	}
	        	else
	        	{
	        		System.err.println("Insufficient balance..");
	        	}
	        	ATM.waitForEnter();
	        }break; 
	        case 3:
	        {
	        	System.out.println("Enter amount to deposit");
	        	double deposit=sc.nextDouble();
	        	atm.deposit(deposit);
	        	System.out.println("Deposit Successfull..");
	        	ATM.waitForEnter();
	        }break;
	        case 4:{
	        	System.out.println("Enter the amount to transfer:");
	        	int amount=sc.nextInt();
	        	System.out.println("Enter you're PIN to submit transfer:");
	        	int otp=sc.nextInt();
	        	//ATM receiver =new ATM(0,otp);
	        	boolean transferSuccess=atm.transfer(amount,  otp);
	        	if(transferSuccess)
	        	{
	        		System.out.println("Transfer SuccessFull..");
	        	}
	        	else
	        	{
	        		System.err.println("Invalid details..❌❌");
	        	}
	        	ATM.waitForEnter();
	        }break;
	        case 5:
	        	System.out.println("Thanks for using ATM..");
	        	System.exit(0); break;
	        default:
	        	System.out.println("Invalid choice...");
	        }
		}

	}
}
