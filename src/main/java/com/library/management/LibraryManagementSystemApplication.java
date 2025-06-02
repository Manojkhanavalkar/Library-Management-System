package com.library.management;

import com.library.management.dao.BookDao;
import com.library.management.dao.UserDao;
import com.library.management.entity.Book;
import com.library.management.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.relational.core.sql.In;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class LibraryManagementSystemApplication implements CommandLineRunner {

	@Autowired
	private BookDao bookDao;

	@Autowired
	private UserDao userDao;

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
				System.out.println("PRESS 8 to issue book to user");
				System.out.println("PRESS 9 to return book from user");
				System.out.println("PRESS 10 to view all issued book");
				System.out.println("PRESS 11 to view the USER menu: ");
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
					System.out.println("Enter the price for the day:");
					int priceOfDay=Integer.parseInt(bufferedReader.readLine());
					Book book=new Book();

					book.setTitle(title);
					book.setAbout(about);
					book.setAuthor(author);
					book.setLanguage(language);
					book.setAvailable(isAvailable);
					book.setPriceOfDay(priceOfDay);
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
					//search logic
					System.out.println("Enter the book title to search");
					String titleKeyword=bufferedReader.readLine();
					List<Book> search=bookDao.search(titleKeyword);

					System.out.println("ID | Title");

					search.forEach(book -> {
						System.out.println(book.getId()+" | "+book.getTitle());
					});
					System.out.println("-----------------------------------");
					System.out.println();


				} else if (choice==4) {
					//update code
					System.out.println("Enter the book Id:");
					int id=Integer.parseInt(bufferedReader.readLine());
					Book updatedBook=new Book();
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
					System.out.println("Enter the price for the day:");
					int priceOfDay=Integer.parseInt(bufferedReader.readLine());
					boolean isAvailable=available.equalsIgnoreCase("T");
					updatedBook.setTitle(title);
					updatedBook.setAbout(about);
					updatedBook.setAuthor(author);
					updatedBook.setLanguage(language);
					updatedBook.setAvailable(isAvailable);
					updatedBook.setPriceOfDay(priceOfDay);

					bookDao.update(id,updatedBook);


				} else if (choice==5) {

					System.out.println("Enter the book id:");
					int bookId=Integer.parseInt(bufferedReader.readLine());
					bookDao.delete(bookId);
					System.out.println("Book deleted successfully");
					System.out.println("------------------------");
					System.out.println();

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
					System.out.println("Book price for a day:"+book.getPriceOfDay());
					System.out.println("-----------------------");

				} else if (choice==7) {
					System.out.println("Exiting App");
					break;
				} else if (choice == 8) {
					//book ko issue karna hai:
					System.out.println("Enter the book id:");
					int bookId=Integer.parseInt(bufferedReader.readLine());

					Book book=bookDao.get(bookId);

					if(!book.getAvailable()){
						System.out.println("Book is not available");
						return;
					}
					System.out.println("Enter the user id: ");
					int user_id= Integer.parseInt(bufferedReader.readLine());
					User user= userDao.get(user_id);

					LocalDate issueDate=LocalDate.now();
					System.out.println("Enter days to issue: ");
					int days=Integer.parseInt(bufferedReader.readLine());
					int totalPrice=days*book.getPriceOfDay();
					LocalDate submitDate=issueDate.plusDays(days);


				} else if (choice==11) {//user CRUD logic
					try{
						while (true){
							System.out.println("PRESS 1 to enter the user:");
							System.out.println("PRESS 2 to get the user list:");
							System.out.println("PRESS 3 to get  the specific user information:");
							System.out.println("PRESS 4 to enter update user:");
							System.out.println("PRESS 5 to delete user:");
							System.out.println("PRESS 6 to exit user menu:");
							System.out.println("Enter you choice:");

							int userChoice=Integer.parseInt(bufferedReader.readLine());
							if(userChoice==1){
								User user=new User();

								System.out.println("Enter the user name:");
								String name=bufferedReader.readLine();
								System.out.println("Enter the user phone no:");
								int userPhoneNo=Integer.parseInt(bufferedReader.readLine());
								System.out.println("Enter user address:");
								String userAddress= bufferedReader.readLine();
								user.setUser_name(name);
								user.setUser_phone_no(userPhoneNo);
								user.setUser_address(userAddress);
								userDao.save(user);
								System.out.println("user saved successfully");
								System.out.println();

							} else if (userChoice == 2) {
								System.out.println("********* Kadak Library Users List ***********");
								System.out.println("==============================");
								System.out.println("ID | User Name");
								List<User> users= userDao.getAll();
								users.forEach(user -> {
									System.out.println(user.getUser_id()+"|"+user.getUser_name());
								});
								System.out.println("----------------------------------");
								System.out.println();
							} else if (userChoice == 3) {
								System.out.println("Enter user_id=");
								int userId=Integer.parseInt(bufferedReader.readLine());
								User user=userDao.get(userId);
								System.out.println("*********User Info********");
								System.out.println("======================");
								System.out.println("User id:"+user.getUser_id());
								System.out.println("User name:"+user.getUser_name());
								System.out.println("User phone number="+user.getUser_phone_no());
								System.out.println("User Address="+user.getUser_address());
								System.out.println("----------------------------------------");
								System.out.println();
							} else if (userChoice == 4) {
								System.out.println("Enter the User Id:");
								int userId=Integer.parseInt(bufferedReader.readLine());
								User updateUser=new User();
								System.out.println("Enter user name : ");
								String userName= bufferedReader.readLine();
								System.out.println("Enter the user phone no : ");
								int userPhoneNo= Integer.parseInt(bufferedReader.readLine());
								System.out.println("Enter the User address: ");
								String userAddress= bufferedReader.readLine();

								updateUser.setUser_name(userName);
								updateUser.setUser_phone_no(userPhoneNo);
								updateUser.setUser_address(userAddress);
								userDao.update(userId,updateUser);

							} else if (userChoice==5) {
								System.out.println("Enter the User Id:");
								int userId=Integer.parseInt(bufferedReader.readLine());
								userDao.delete(userId);
							} else if (userChoice==6) {
								System.out.println("Exiting user menu:");
								break;
							}
						}
					}catch (Exception e){
						System.out.println("exception occured:"+e.getMessage());
					}

				}
			}
		}catch (Exception e){
			System.out.println("Exception:"+e.getMessage());
		}
	}
}
