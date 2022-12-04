package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CapoBean;
import model.CapoBeanDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/show-abbigliamento")
public class ShowAbbigliamentoServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1 e' il valore iniziale degli attributi sql con autoincrement
        int i = 1;
        CapoBeanDAO service = new CapoBeanDAO();
        List<CapoBean> list = new ArrayList<>();
        CapoBean capoBean;

        while( (capoBean = service.doRetrieveById(i) ) != null){
            list.add(capoBean);
            i++;
        }

        request.setAttribute("listaCapi", list);

        String address = "/WEB-INF/results/abbigliamento.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
