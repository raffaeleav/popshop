package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Carrello;

import java.io.IOException;

@WebServlet("/acquista")
public class PurchaseServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String address;

        synchronized (session){


            if(session.getAttribute("logged") == null){
                address = "/WEB-INF/results/acquisto-non-registrato.jsp";
            }

            else {
                boolean logged = (boolean) session.getAttribute("logged");

                if(logged) {
                    address = "/WEB-INF/results/acquisto-registrato.jsp";
                    Carrello carrello = new Carrello();
                    session.setAttribute("carrello", null);
                }

                else {
                    address = "/WEB-INF/results/acquisto-non-registrato.jsp";
                }
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
            dispatcher.forward(request,response);
        }
    }
}
