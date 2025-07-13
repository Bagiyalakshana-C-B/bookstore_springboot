package com.bootbs.bookstore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootbs.bookstore.Model.BookStoreModel;
import com.bootbs.bookstore.Model.UserModel;
//import org.springframework.web.bind.annotation.RestController;
import com.bootbs.bookstore.Repository.BookStoreRepo;
import com.bootbs.bookstore.Repository.UserRepo;

import jakarta.servlet.http.HttpServletRequest;

//import com.bootbs.bookstore.Model.BookStoreModel;

@Controller
public class BookStoreController {
	
	//with database using hibernate
	@Autowired
	private BookStoreRepo repo;
	@Autowired
	private UserRepo userrepo;
	
	@GetMapping("/login")
	public String showlogin(HttpServletRequest request) {
		request.setAttribute("action","login");
		return "pages/login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("username") String username,@RequestParam("password") String password ,HttpServletRequest request) {
		UserModel user = userrepo.findByUsername(username);
		if(user!=null && username.equals(user.getUsername()) && password.equals(user.getPassword())) {
			request.setAttribute("msg", "Welcome Back to the Book Store");
			return "redirect:/pages/home";
		}
		else {
			request.setAttribute("msg", "Invalid User");
			return "pages/login";
		}
	}
	
	@GetMapping("/signup")
	public String showsigin(HttpServletRequest request) {
		request.setAttribute("action","signup");
		return "pages/login";
	}
	
	@PostMapping("/signup")
	public String signin(@RequestParam("username") String username,@RequestParam("password") String password ,HttpServletRequest request) {
		UserModel user = userrepo.findByUsername(username);
		if(user==null) {
			UserModel newuser = new UserModel(username,password);
			userrepo.save(newuser);
			request.setAttribute("msg","Welcome to Book Store");
			return "redirect:/pages/home";
		}
		else {
			request.setAttribute("msg", "User Already exist");
			return "pages/login";
		}
	}
	
	@GetMapping("/home")
	public String home() {
		return "pages/home";
	}
	
	@GetMapping("/books")
	public String showbooks(HttpServletRequest request) {
		List<BookStoreModel> bookList = repo.findAll();
		request.setAttribute("books", bookList);
		return "pages/books";
	}
	
	@GetMapping("/add")
	public String showform() {
		return "pages/form";
	}
	
	@PostMapping("/add")
	public String addBook(@ModelAttribute BookStoreModel book,HttpServletRequest request) {
		repo.save(book);
		request.setAttribute("msg","Book Added Successfully");
		return "pages/form";
	}
	
	@GetMapping("/delete")
	public String showdelete() {
		return "pages/deleteBook";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("id") int id,HttpServletRequest request) {
		String message = "";
		try {
			if(repo.existsById(id)) {
				repo.deleteById(id);
				message = "Book deleted Successfully";
			}
			else {
				message = "Book not found";
			}
		}
		catch(Exception e){
			message = "Invalid Input";
		}
		request.setAttribute("msg", message);
		return "pages/deleteBook";
	}
	
	@GetMapping("/sell")
	public String showsell(HttpServletRequest request) {
		request.setAttribute("action","sell");
		return "pages/updateBook";
	}
	
	@PostMapping("/sell")
	public String sell(@RequestParam("id") int id,
						@RequestParam("quantity") int quantity,HttpServletRequest request) {
		String message="";
		try {
			if(repo.existsById(id)) {
				BookStoreModel book = repo.findById(id).get();
				if(book.getQuantity() >= quantity && book.getQuantity()>0) {
					book.setQuantity(book.getQuantity()-quantity);
					repo.save(book);
					message="Book Sold";
				}
				else {
					message="Book out of stock";
				}
			}
			else {
				message="Book Not Found";
			}
		}
		catch(Exception e) {
			message="Invalid Id";
		}
		request.setAttribute("msg", message);
		return "pages/updateBook";
	}
	
	@GetMapping("/buy")
	public String showbuy(HttpServletRequest request) {
		request.setAttribute("action","buy");
		return "pages/updateBook";
	}
	
	@PostMapping("/buy")
	public String buy(@RequestParam("id") int id,@RequestParam("quantity") int quantity,HttpServletRequest request) {
		String message="";
		try {
			if(repo.existsById(id)) {
				BookStoreModel book = repo.findById(id).get();
				book.setQuantity(book.getQuantity()+quantity);
				repo.save(book);
				message="Book get bought";
			}
			else {
				message="Book Not Found";
			}
		}
		catch(Exception e) {
			message="Invalid Id";
		}
		request.setAttribute("msg", message);
		return "pages/updateBook";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "redirect:/pages/login";
	}
	
}
