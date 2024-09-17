package servlets;

import bean.Owner;
import bean.Vehicle;
import dao.OwnerDao;
import dao.VehicleDao;
import db.ConnectionProvider;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddRegister", value = "/AddRegister")
public class AddRegister extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String vRegister = request.getParameter("vRegister");
        String vMake=request.getParameter("vMake");
        String vEngineType=request.getParameter("vEngineType");
        String vFuelType = request.getParameter("vFuelType");
        String vColor = request.getParameter("vColor");
        String oId = request.getParameter("oId");




        HttpSession session = request.getSession();
        String msg = "";
        Vehicle vehicle=new Vehicle();
        vehicle.setVRegister(vRegister);
        vehicle.setVMake(vMake);
        vehicle.setVEngineType(vEngineType);
        vehicle.setVFuelType(vFuelType);
        vehicle.setVColor(vColor);
        vehicle.setOwnerId(Integer.parseInt(oId));

        VehicleDao vehicleDao = new VehicleDao(ConnectionProvider.getConnection());
        try {
            int rows = vehicleDao.insert(vehicle);
            if(rows >=1){
                System.out.println("Data Registered Successfully!");
                msg="Data Inseerted Successfully!";
            }else {
                System.out.println("Failed to Registered ");
                msg="Failed to INSERT ";
            }
        } catch (Exception e) {
            e.printStackTrace();

            msg =  "went wrong. Please check kayoo.";
        }

        session.setAttribute("msg",msg);
        response.sendRedirect("pages/Register.jsp");

    }
}
