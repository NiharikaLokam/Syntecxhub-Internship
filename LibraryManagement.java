package com.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.service.Book;
import com.validation.PerformOperations;

public class LibraryManagement 
{
	
	    private static  final String Library_Management_System = "Library_Management_System/Books_In_Library.txt";
	    public static List<Book> books = new ArrayList<>();
	    private static Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        loadBooks();
	        while (true) {
	            showMenu();
	            String choice = scanner.nextLine();
	            switch (choice) {
	                case "1": PerformOperations.addBook(); break;
	                case "2": PerformOperations.removeBook(); break;
	                case "3": PerformOperations.searchBook(); break;
	                case "4": PerformOperations.displayBooks(); break;
	                case "5": PerformOperations.toggleAvailability(); break;
	                case "6": saveBooks(); System.out.println("Goodbye!"); return;
	                default: System.out.println("Invalid choice, please try again.");
	                
	            }
	        }
	    }

	    private static void showMenu() {
	        System.out.println("-------- Library Management System ----------");
	        System.out.println("1. Add Book");
	        System.out.println("2. Remove Book");
	        System.out.println("3. Search Book");
	        System.out.println("4. Display All Books");
	        System.out.println("5. Change Availability");
	        System.out.println("6. Exit");
	        System.out.print("Enter your choice: ");
	    }

	   

	    private static void loadBooks() {
	        File file = new File("Library_Management_System");
	        
              File f=new File(file,Library_Management_System);
              if(!f.exists())
              return;
            	  
	        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] data = line.split(",");
	                books.add(new Book(data[0], data[1], Boolean.parseBoolean(data[2])));
	            }
	            br.close();
	        } catch (IOException e) {
	            System.out.println("Failed to load books: " + e.getMessage());
	        }
	    }

	    private static void saveBooks() {
//	    	 File file = new File("Library_Management_System");
//		       
//				
//				//File f=new File(file,"Books_In_Library.txt");
//				
//		        if (!file.exists()) {
//		        	file.mkdir();
//		        }
	        try (BufferedWriter bw = new BufferedWriter(new FileWriter(Library_Management_System,true))) {
	        	for(Book b:books)
	        	{
	        		bw.write(b.getTitle()+","+b.getAuthor()+","+b.isAvailable());
	        		bw.newLine();
	        	}
	        	bw.close();
	            System.out.println("Saving : "+books.size());
	            System.out.println("Books saved successfully.");
	        } catch (IOException e) {
	            System.out.println("Failed to save books: " + e.getMessage());
	        }
	    }

}
