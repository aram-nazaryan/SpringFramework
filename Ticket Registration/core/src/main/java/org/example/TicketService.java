package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/consume")
public class TicketService extends HttpServlet {
    TicketRepository<Ticket> repository = PooledJDBCTicketRepository.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post in consume ");
        repository.consume(req.getParameter("ticketId"));
        resp.sendRedirect("index.jsp");
    }
}
