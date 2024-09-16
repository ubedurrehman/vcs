package servlets;

import dao.OwnerDao;
import db.ConnectionProvider;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteOwner", value = "/DeleteOwner")
public class DeleteOwner extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ownerId = request.getParameter("id");

        HttpSession session = request.getSession();
          String msg = "";
        OwnerDao ownerDao = new OwnerDao(ConnectionProvider.getConnection());

        try {
            int id = Integer.parseInt(ownerId);
            int rows = ownerDao.delete(id);
            if (rows >= 1) {
            msg = "Data deleted Successfuly";
            } else {
                msg = "Failed to delete owner.";
            }
        } catch (Exception e) {

            e.printStackTrace();
            msg =  "went wrong. Please check kayoo.";
        }

        session.setAttribute("msg",msg);
        response.sendRedirect("pages/Owner.jsp");

    }



}
