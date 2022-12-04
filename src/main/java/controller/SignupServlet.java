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

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest  request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    public void doGet(HttpServletRequest  request, HttpServletResponse response) throws ServletException, IOException {
        UtenteBeanDAO service = new UtenteBeanDAO();
        UtenteBean utenteBean = new UtenteBean();
        List<UtenteBean> list = service.doRetrieveAll();
        String address, email = request.getParameter("reg-mail");
        boolean found = false;

        int i;
        for(i = 0; i < list.size(); i++){
            if(list.get(i).getEmail().equals(email))
                found = true;
        }

        if(found){
            address = "/WEB-INF/results/errore-registrazione.jsp";
        }

        else {
            utenteBean.setName(request.getParameter("reg-name"));
            utenteBean.setSurname(request.getParameter("reg-surname"));
            utenteBean.setEmail(email);
            utenteBean.setPassword(request.getParameter("reg-passw"));
            utenteBean.setAddress(request.getParameter("reg-address"));
            utenteBean.setCreditCard(request.getParameter("reg-credit"));

            service.doSave(utenteBean);

            address="/WEB-INF/results/profilo.jsp";

            HttpSession session = request.getSession();

            synchronized (session){
                session.setAttribute("logged",true);
                session.setAttribute("user", utenteBean);
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
