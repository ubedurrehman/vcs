package servlets;

import bean.Owner;
import dao.OwnerDao;
import db.ConnectionProvider;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddOwner", value = "/AddOwner")
public class AddOwner extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      String ownerName =   request.getParameter("ownerName");
      String ownerFatherName = request.getParameter("ownerFname");
      String ownerCnic = request.getParameter("ownerCnic");
      String ownerRemarks = request.getParameter("ownerRemarks");

        HttpSession session = request.getSession();
        String msg = "";
        Owner owner = new Owner();
        owner.setoName(ownerName);
        owner.setoFatherName(ownerFatherName);
        owner.setoCnic(ownerCnic);
        owner.setoRemarks(ownerRemarks);


        OwnerDao ownerDao = new OwnerDao(ConnectionProvider.getConnection());
        try {
            int rows = ownerDao.insert(owner);
            if(rows >=1){
                System.out.println("Data Inseerted Successfully!");
                msg="Data Inseerted Successfully!";
            }else {
                System.out.println("Failed to INSERT ");
                msg="Failed to INSERT ";
            }
        } catch (Exception e) {
            e.printStackTrace();

            msg =  "went wrong. Please check kayoo.";
        }

        session.setAttribute("msg",msg);
        response.sendRedirect("pages/Owner.jsp");

    }
}
