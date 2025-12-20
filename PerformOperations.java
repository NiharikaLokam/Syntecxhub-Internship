package com.validation;

import java.util.Scanner;

import com.main.LibraryManagement;
import com.service.Book;

public class PerformOperations {
	static Scanner scanner=new Scanner(System.in);
	 public static void addBook() {
	        try {
	            System.out.print("Enter Book Title: ");
	            String title = scanner.nextLine();
	            if (title.isEmpty()) throw new Exception("Title cannot be empty.");

	            System.out.print("Enter Book Author: ");
	            String author = scanner.nextLine();
	            if (author.isEmpty()) throw new Exception("Author cannot be empty.");

	            LibraryManagement.books.add(new Book(title, author, true));
	            System.out.println("Book added successfully.");

	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

	    public static void removeBook() {
	        System.out.print("Enter Book Title to remove: ");
	        String title = scanner.nextLine();
	        boolean removed = LibraryManagement.books.removeIf(b -> b.getTitle().equalsIgnoreCase(title));

	        if (removed) {
	            System.out.println("Book removed successfully.");
	        } else {
	            System.out.println("No book found with title: " + title);
	        }
	    }

	    public static void searchBook() {
	        System.out.print("Enter keyword: ");
	        String keyword = scanner.nextLine().toLowerCase();
	        boolean found = false;

	        for (Book b : LibraryManagement.books) {
	            if (b.getTitle().toLowerCase().contains(keyword) ||
	                b.getAuthor().toLowerCase().contains(keyword)) {
	                System.out.println(b);
	                found = true;
	            }
	        }

	        if (!found) System.out.println("No matching book found.");
	    }

	    public static void displayBooks() {
	        if (LibraryManagement.books.isEmpty()) {
	            System.out.println("No books available.");
	            return;
	        }
	        System.out.println("\n--- Book List ---");
	        LibraryManagement.books.forEach(System.out::println);
	    }

	    public static void toggleAvailability() {
	        System.out.print("Enter Book Title to change availability: ");
	        String title = scanner.nextLine();

	        for (Book b : LibraryManagement.books) {
	            if (b.getTitle().equalsIgnoreCase(title)) {
	                b.setAvailable(!b.isAvailable());
	                System.out.println("Updated availability: " + (b.isAvailable() ? "Available" : "Not Available"));
	                return;
	            }
	        }
	        System.out.println("Book not found.");
	    }
}
