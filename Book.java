package com.service;
/*
-->Implement a command-line interface (CLI) for
managing books in a library.
-->Features include adding, removing, and searching
for books.
-->Utilize file handling or basic data structures for
storage.
-->Focus on user input validation and error handling.*/
public class Book 
{
private String title;
private String author;
private boolean isAvailable;

public Book() {
	super();
}
public Book(String title, String author, boolean isAvailable) {
	super();
	this.title = title;
	this.author = author;
	this.isAvailable = isAvailable;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public boolean isAvailable() {
	return isAvailable;
}
public void setAvailable(boolean isAvailable) {
	this.isAvailable = isAvailable;
}
@Override
public String toString() {
	return "Book [title=" + title + ", author=" + author + ", isAvailable=" + isAvailable + "]\n";
}

}
