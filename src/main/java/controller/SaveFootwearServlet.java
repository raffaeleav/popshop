package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/save-footwear")
@MultipartConfig(
        fileSizeThreshold   = 0,  //0 MegaByte
        maxFileSize         = 10 * 1024 * 1024, //10 MB
        maxRequestSize      = 50 * 1024 * 1024 //50 MB
)
public class SaveFootwearServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FootwearBean footwearBean = new FootwearBean();
        FootwearBeanDAO service = new FootwearBeanDAO();
        String address;

        String name = request.getParameter("add-foot-name");
        String brand = request.getParameter("add-foot-brand");
        double price = Double.parseDouble(request.getParameter("add-foot-price"));
        String image = "footwear/" + name + ".jpg";

        boolean found = false;
        List<FootwearBean> list = service.doRetrieveAll();
        for(FootwearBean footwearBean1 : list){
            if(name.equals(footwearBean.getName()))
                found = true;
        }

        Part part = request.getPart("add-foot-file");
        if(part != null && !found) {
            part.write("C:\\Immagini PopShop\\catalogo\\" + image);

            footwearBean.setName(name);
            footwearBean.setBrand(brand);
            footwearBean.setPrice(price);
            footwearBean.setImage(image);

            service.doSave(footwearBean);

            address = "/WEB-INF/results/profilo-admin.jsp";
        }
        else {
            address = "/WEB-INF/results/errore-upload.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
