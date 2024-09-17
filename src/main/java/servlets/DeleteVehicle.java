package servlets;

import dao.OwnerDao;
import dao.VehicleDao;
import db.ConnectionProvider;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteVehicle", value = "/DeleteVehicle")
public class DeleteVehicle extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vId = request.getParameter("id");

        HttpSession session = request.getSession();
        String msg = "";
        VehicleDao vehicleDao=new VehicleDao(ConnectionProvider.getConnection());


        try {
            int id = Integer.parseInt(vId);
            int rows = vehicleDao.delete(id);
            if (rows >= 1) {
                msg = "Data deleted Successfuly";
            } else {
                msg = "Failed to delete Vehicle.";
            }
        } catch (Exception e) {

            e.printStackTrace();
            msg =  "went wrong. Please check kayoo.";
        }

        session.setAttribute("msg",msg);
        response.sendRedirect("pages/Register.jsp");
    }
}
