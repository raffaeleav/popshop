package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/add-accessorio")
public class AddAccessorioCarrelloServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Carrello carrello;

        synchronized (session) {
            if (session.getAttribute("carrello") == null) {
                int id = Integer.parseInt(request.getParameter("id"));
                String size = request.getParameter("acc-size");

                AccessorioBeanDAO service = new AccessorioBeanDAO();
                AccessorioBean accessorioBean = service.doRetrieveById(id);

                carrello = new Carrello();
                carrello.addAcc(accessorioBean);

                session.setAttribute("carrello", carrello);
            }

            else {
                int id = Integer.parseInt(request.getParameter("id"));
                String size = request.getParameter("acc-size");

                AccessorioBeanDAO service = new AccessorioBeanDAO();
                AccessorioBean accessorioBean = service.doRetrieveById(id);

                carrello = (Carrello) session.getAttribute("carrello");
                carrello.addAcc(accessorioBean);

                session.setAttribute("carrello", carrello);
            }
        }
    }
}
