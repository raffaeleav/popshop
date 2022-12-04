package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.FootwearBean;
import model.FootwearBeanDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/show-footwear")
public class ShowFootwearServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1 e' il valore iniziale degli attributi sql con autoincrement
        int i = 1;
        FootwearBeanDAO service = new FootwearBeanDAO();
        List<FootwearBean> list = new ArrayList<>();
        FootwearBean footwearBean;

        while( (footwearBean = service.doRetrieveById(i) ) != null){
            list.add(footwearBean);
            i++;
        }

        request.setAttribute("listaFoot", list);

        String address = "/WEB-INF/results/footwear.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
