package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.CapoBean;
import model.CapoBeanDAO;

import java.io.IOException;
import java.util.List;

@WebServlet("/save-abbigliamento")
@MultipartConfig(
        fileSizeThreshold   = 0,  //0 MegaByte
        maxFileSize         = 10 * 1024 * 1024, //10 MB
        maxRequestSize      = 50 * 1024 * 1024 //50 MB
)
public class SaveAbbigliamentoServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CapoBean capoBean = new CapoBean();
        CapoBeanDAO service = new CapoBeanDAO();
        String address;

        String name = request.getParameter("add-capo-name");
        String brand = request.getParameter("add-capo-brand");
        double price = Double.parseDouble(request.getParameter("add-capo-price"));
        String image = "abbigliamento/" + name + ".jpg";

        boolean found = false;
        List<CapoBean> list = service.doRetrieveAll();
        for(CapoBean capoBean1 : list){
            if(name.equals(capoBean1.getName()))
                found = true;
        }

        Part part = request.getPart("add-capo-file");
        if(part != null && !found) {
            part.write("C:\\PopShop\\catalogo\\" + image);

            capoBean.setName(name);
            capoBean.setBrand(brand);
            capoBean.setPrice(price);
            capoBean.setImage(image);

            service.doSave(capoBean);

            address = "/WEB-INF/results/profilo-admin.jsp";
        }
        else {
            address = "/WEB-INF/results/errore-upload.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

}
