package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AccessorioBean;
import model.CapoBean;
import model.Carrello;
import model.FootwearBean;

import java.io.IOException;
import java.util.List;

@WebServlet("/show-carrello")
public class ShowCarrelloServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String address;
        RequestDispatcher dispatcher;

        synchronized (session) {
            if (session.getAttribute("carrello") == null) {
                address = "/WEB-INF/results/carrello-vuoto.jsp";
            }

            else {
                Carrello carrello = (Carrello) session.getAttribute("carrello");
                List<CapoBean> listaAbbigliamento = carrello.getListaCapi();
                List<FootwearBean> listaFootwear = carrello.getListaFootwear();
                List<AccessorioBean> listaAccessori = carrello.getListaAccessori();

                request.setAttribute("listaCapi", listaAbbigliamento);
                request.setAttribute("listaFoot", listaFootwear);
                request.setAttribute("listaAcc", listaAccessori);

                address = "/WEB-INF/results/carrello.jsp";
            }

            dispatcher = request.getRequestDispatcher(address);
            dispatcher.forward(request, response);
        }
    }

}
