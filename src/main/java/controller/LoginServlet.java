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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest  request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtenteBeanDAO service = new UtenteBeanDAO();
        UtenteBean utenteBean;
        List<UtenteBean> list = service.doRetrieveAll();
        String address, email = request.getParameter("log-mail");
        int id = 0;
        boolean found = false;

        int i;
        for(i = 0; i < list.size(); i++){
            if(list.get(i).getEmail().equals(email)) {
                found = true;
                id = list.get(i).getId();
            }
        }

        if(!found){
            address = "/WEB-INF/results/errore-login.jsp";
        }

        else {
            utenteBean = service.doRetrieveById(id);
            String passw = request.getParameter("log-passw");

            if (id == 1) {

                if (passw.equals(utenteBean.getPassword())) {
                    HttpSession session = request.getSession();

                    synchronized (session) {
                        session.setAttribute("logged", true);
                        session.setAttribute("user", utenteBean);
                    }

                    address = "/WEB-INF/results/profilo-admin.jsp";
                }

                else {
                    address = "/WEB-INF/results/errore-login.jsp";
                }
            }

            else {

                if (passw.equals(utenteBean.getPassword())) {
                    HttpSession session = request.getSession();

                    synchronized (session) {
                        session.setAttribute("logged", true);
                        session.setAttribute("user", utenteBean);
                    }

                    address = "/WEB-INF/results/profilo.jsp";
                }

                else {
                    address = "/WEB-INF/results/errore-login.jsp";
                }
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
