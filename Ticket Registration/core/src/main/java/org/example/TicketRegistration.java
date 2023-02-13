package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/register")
public class TicketRegistration extends HttpServlet {

    private final TicketRepository<Ticket> repository = PooledJDBCTicketRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("count", repository.countByActiveIsTrue());
        resp.sendRedirect("register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final HttpSession session = req.getSession();
        session.setAttribute("ticketId", repository.save(new Ticket()));
        session.setAttribute("count", repository.countByActiveIsTrue());
        session.setMaxInactiveInterval(3600);
        resp.sendRedirect("ticket.jsp");
    }

}

