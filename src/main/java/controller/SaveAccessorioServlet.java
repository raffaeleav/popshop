package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.AccessorioBean;
import model.AccessorioBeanDAO;
import model.CapoBean;
import model.CapoBeanDAO;

import java.io.IOException;
import java.util.List;

@WebServlet("/save-accessorio")
@MultipartConfig(
        fileSizeThreshold   = 0,  //0 MegaByte
        maxFileSize         = 10 * 1024 * 1024, //10 MB
        maxRequestSize      = 50 * 1024 * 1024 //50 MB
)
public class SaveAccessorioServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccessorioBean accessorioBean = new AccessorioBean();
        AccessorioBeanDAO service = new AccessorioBeanDAO();
        String address;

        String name = request.getParameter("add-acc-name");
        String brand = request.getParameter("add-acc-brand");
        double price = Double.parseDouble(request.getParameter("add-acc-price"));
        String image = "accessori/" + name + ".jpg";

        boolean found = false;
        List<AccessorioBean> list = service.doRetrieveAll();
        for(AccessorioBean accessorioBean1 : list){
            if(name.equals(accessorioBean1.getName()))
                found = true;
        }

        Part part = request.getPart("add-acc-file");
        if(part != null && !found) {
            part.write("C:\\Immagini PopShop\\catalogo\\" + image);

            accessorioBean.setName(name);
            accessorioBean.setBrand(brand);
            accessorioBean.setPrice(price);
            accessorioBean.setImage(image);

            service.doSave(accessorioBean);

            address = "/WEB-INF/results/profilo-admin.jsp";
        }
        else {
            address = "/WEB-INF/results/errore-upload.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
