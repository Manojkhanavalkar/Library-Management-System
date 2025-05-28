package com.library.management;

import com.library.management.dao.BookDao;
import com.library.management.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@SpringBootApplication
public class LibraryManagementSystemApplication implements CommandLineRunner {

	@Autowired
	private BookDao bookDao;

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {



		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
		try{
			while (true){
				System.out.println("*** Welcome to library Management System ***");
				System.out.println("PRESS 1 to add book");
				System.out.println("PRESS 2 to view All books");
				System.out.println("PRESS 3 to search book");
				System.out.println("PRESS 4 to Update a book");
				System.out.println("PRESS 5 to Delete a book");
				System.out.println("PRESS 6 to view a book details");
				System.out.println("PRESS 7 to Exit");
				System.out.println("Enter you choice:");

				int choice=Integer.parseInt(bufferedReader.readLine());
				if (choice==1){
					System.out.println("Enter book title: ");
					String title= bufferedReader.readLine();
					System.out.println("Enter the book about: ");
					String about= bufferedReader.readLine();
					System.out.println("Enter the book author: ");
					String author= bufferedReader.readLine();
					System.out.println("Enter the book language: ");
					String language= bufferedReader.readLine();
					System.out.println("Enter the book available :[T/F]");
					String available= bufferedReader.readLine();
					boolean isAvailable=available.equalsIgnoreCase("T");
					Book book=new Book();

					book.setTitle(title);
					book.setAbout(about);
					book.setAuthor(author);
					book.setLanguage(language);
					book.setAvailable(isAvailable);
					bookDao.save(book);
					System.out.println("Book added Successfully");

				} else if (choice==2) {
					//view logic
					System.out.println("All books in the library");
					System.out.println("---------------------------------");
					System.out.println();
					System.out.println("ID | Title");
					List<Book> all=bookDao.getAll();
					all.forEach(book -> {
						System.out.println(book.getId()+" | "+book.getTitle());
					});
					System.out.println("-----------------------------------");
					System.out.println();

				} else if (choice==3) {

				} else if (choice==4) {

				} else if (choice==5) {

				} else if (choice==6) {
					System.out.println("Enter the book id:");
					int bookId=Integer.parseInt(bufferedReader.readLine());
					Book book = bookDao.get(bookId);
					System.out.println("---------------------");
					System.out.println("Book Id:"+book.getId());
					System.out.println("Book Title:"+book.getTitle());
					System.out.println("Book About:"+book.getAbout());
					System.out.println("Book Language:"+book.getLanguage());
					System.out.println("Book Author:"+book.getAuthor());
					System.out.println("Book Available:"+(book.getAvailable()?"Yes":"No"));
					System.out.println("-----------------------");

				} else if (choice==7) {
					System.out.println("Exiting App");
					break;
				}
			}
		}catch (Exception e){
			System.out.println("Exception:"+e.getMessage());
		}
	}
}
