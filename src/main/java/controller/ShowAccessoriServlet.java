package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AccessorioBean;
import model.AccessorioBeanDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/show-accessori")
public class ShowAccessoriServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1 e' il valore iniziale degli attributi sql con autoincrement
        int i = 1;
        AccessorioBeanDAO service = new AccessorioBeanDAO();
        List<AccessorioBean> list = new ArrayList<>();
        AccessorioBean accessorioBean;

        while( (accessorioBean = service.doRetrieveById(i) ) != null){
            list.add(accessorioBean);
            i++;
        }

        request.setAttribute("listaAcc", list);

        String address = "/WEB-INF/results/accessori.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
