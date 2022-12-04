package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CapoBean;
import model.CapoBeanDAO;

import java.io.*;

@WebServlet("/get-capo-picture")
public class GetCapoPictureServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        CapoBeanDAO service = new CapoBeanDAO();
        CapoBean capoBean = service.doRetrieveById(Integer.parseInt(id));

        String filePath = "C:\\PopShop\\catalogo\\" + File.separator + capoBean.getImage();
        File file = new File(filePath);

        // setto gli header della risposta per gestire il tipo
        response.reset();
        response.setBufferSize(10240);
        response.setContentType(getServletContext().getMimeType(file.getName()));
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");

        BufferedInputStream input = null;
        BufferedOutputStream output = null;

        try {
            input = new BufferedInputStream(new FileInputStream(file), 10240);
            output = new BufferedOutputStream(response.getOutputStream(), 10240);

            // scrivo contenuto del file nella risposta
            byte[] buffer = new byte[10240];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }

        } finally {
            close(output);
            close(input);
        }
    }

    private static void close(Closeable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
