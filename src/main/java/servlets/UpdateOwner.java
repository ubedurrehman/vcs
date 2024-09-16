package servlets;

import bean.Owner;
import dao.OwnerDao;
import db.ConnectionProvider;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateOwner", value = "/UpdateOwner")
public class UpdateOwner extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String oid = request.getParameter("id");

        String ownerName =   request.getParameter("ownerName");
        String ownerFatherName = request.getParameter("ownerFname");
        String ownerCnic = request.getParameter("ownerCnic");
        String ownerRemarks = request.getParameter("ownerRemarks");

        int id = Integer.parseInt(oid);


        Owner owner = new Owner();
        owner.setoId(id);
        owner.setoName(ownerName);
        owner.setoFatherName(ownerFatherName);
        owner.setoCnic(ownerCnic);
        owner.setoRemarks(ownerRemarks);

        OwnerDao ownerDao = new OwnerDao(ConnectionProvider.getConnection());

        HttpSession session = request.getSession();
        String msg;

        try {

            int rows = ownerDao.update(owner);
            if (rows > 0) {
                msg = "Owner updated successfully ok aw";
            } else {
                msg = " not  update owner failed. masla aw";
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "went wrong. Please check kayoo";
        }


        session.setAttribute("msg", msg);
        response.sendRedirect("pages/Owner.jsp");
    }
}
