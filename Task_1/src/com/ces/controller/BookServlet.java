package com.ces.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ces.model.BookModel;
import com.ces.service.BookService;
import com.ces.service.impl.BookServiceImpl;

@WebServlet(value = "/Book")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bookService = new BookServiceImpl();
		String type = request.getParameter("type");
		if(type != null) {
			if(type.equals("delete")) {
				Integer id = Integer.parseInt(request.getParameter("id"));
				bookService.delete(id);
			} else if(type.equals("edit")) {
				Integer id = Integer.parseInt(request.getParameter("id"));
				request.setAttribute("book", bookService.findById(id));
				request.getRequestDispatcher("/views/jsp/add.jsp").forward(request, response);
			}
		}
		if(type == null || !type.equals("edit")) {
			request.setAttribute("books", bookService.findAllBooks());
			request.getRequestDispatcher("/views/jsp/books.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bookService = new BookServiceImpl();
		String name = (String)request.getParameter("name");
		String author = (String)request.getParameter("author");
		String type = (String)request.getParameter("type");
		Integer id = null;
		if(type.equals("edit")) {
			id = Integer.parseInt(request.getParameter("id"));
		}
		if(name == "") {
			request.setAttribute("error", "This field can't empty.");
			request.getRequestDispatcher("/views/jsp/add.jsp").forward(request, response);
		} else {
			System.out.println(name);
			bookService.add(new BookModel(id, name, author));
			request.setAttribute("books", bookService.findAllBooks());
			request.getRequestDispatcher("/views/jsp/books.jsp").forward(request, response);
		}
	}

}
