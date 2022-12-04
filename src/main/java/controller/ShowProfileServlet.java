package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.UtenteBean;
import model.UtenteBeanDAO;

import java.io.IOException;
import java.util.List;

@WebServlet("/show-profile")
public class ShowProfileServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String address;
        RequestDispatcher dispatcher;

        synchronized (session) {
            if (session.getAttribute("logged") == null){
                session.setAttribute("logged", false);
                address = "/WEB-INF/results/login-signup.jsp";
            }

            else {
                boolean logged = (boolean) session.getAttribute("logged");

                if(!logged) {
                    address = "/WEB-INF/results/login-signup.jsp";
                }

                else {
                    UtenteBean utenteBean = (UtenteBean) session.getAttribute("user");

                    if (utenteBean.getId() == 1) {
                        address = "/WEB-INF/results/profilo-admin.jsp";
                    }

                    else {
                        address = "/WEB-INF/results/profilo.jsp";
                    }
                }
            }

            dispatcher = request.getRequestDispatcher(address);
            dispatcher.forward(request, response);
        }
    }
}
