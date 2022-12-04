package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/show-ricerca")
public class ShowRicercaServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("search-text"), address;

        CapoBeanDAO serviceCapo = new CapoBeanDAO();
        FootwearBeanDAO serviceFootwear = new FootwearBeanDAO();
        AccessorioBeanDAO serviceAccessorio = new AccessorioBeanDAO();
        List<CapoBean> capoBeanList = new ArrayList<>();
        List<FootwearBean> footwearBeanList = new ArrayList<>();
        List<AccessorioBean> accessorioBeanList = new ArrayList<>();

        for(CapoBean capo: serviceCapo.doRetrieveAll()){
            if(capo.getName().equalsIgnoreCase(text) || capo.getBrand().equalsIgnoreCase(text))
                capoBeanList.add(capo);
        }

        for(FootwearBean foot: serviceFootwear.doRetrieveAll()){
            if(foot.getName().equalsIgnoreCase(text) || foot.getBrand().equalsIgnoreCase(text))
                footwearBeanList.add(foot);
        }

        for(AccessorioBean acc: serviceAccessorio.doRetrieveAll()){
            if(acc.getName().equalsIgnoreCase(text) || acc.getBrand().equalsIgnoreCase(text))
                accessorioBeanList.add(acc);
        }

        if(capoBeanList.isEmpty() && footwearBeanList.isEmpty() && accessorioBeanList.isEmpty()){
            address = "/WEB-INF/results/ricerca-vuoto.jsp";
        }

        else{
            request.setAttribute("searchListCapi", capoBeanList);
            request.setAttribute("searchListFootwear", footwearBeanList);
            request.setAttribute("searchListAccessori", accessorioBeanList);

            address = "/WEB-INF/results/ricerca-risultati.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

}
