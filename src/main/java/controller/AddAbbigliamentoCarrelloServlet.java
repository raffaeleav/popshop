package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.CapoBean;
import model.CapoBeanDAO;
import model.Carrello;

import java.io.IOException;

@WebServlet("/add-abbigliamento")
public class AddAbbigliamentoCarrelloServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Carrello carrello;

        synchronized (session) {
            if (session.getAttribute("carrello") == null) {
                int id = Integer.parseInt(request.getParameter("id"));
                System.out.print(id);
                String size = request.getParameter("capo-size");

                CapoBeanDAO service = new CapoBeanDAO();
                CapoBean capoBean = service.doRetrieveById(id);
                capoBean.setSize(size);

                carrello = new Carrello();
                carrello.addCapo(capoBean);

                session.setAttribute("carrello", carrello);
            }

            else {
                int id = Integer.parseInt(request.getParameter("id"));
                String size = request.getParameter("capo-size");

                CapoBeanDAO service = new CapoBeanDAO();
                CapoBean capoBean = service.doRetrieveById(id);
                capoBean.setSize(size);

                carrello = (Carrello) session.getAttribute("carrello");
                carrello.addCapo(capoBean);

                session.setAttribute("carrello", carrello);
            }
        }
    }
}
