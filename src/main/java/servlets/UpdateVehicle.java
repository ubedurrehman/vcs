package servlets;

import bean.Vehicle;
import dao.VehicleDao;
import db.ConnectionProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(name = "UpdateVehicle", value = "/UpdateVehicle")
public class UpdateVehicle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String vId = request.getParameter("id");
        String vRegister = request.getParameter("vRegister");
        String vMake=request.getParameter("vMake");
        String vEngineType=request.getParameter("vEngineType");
        String vFuelType = request.getParameter("vFuelType");
        String vColor = request.getParameter("vColor");

        int id = Integer.parseInt(vId);
        Vehicle vehicle=new Vehicle();
        vehicle.setVRegister(vRegister);
        vehicle.setVMake(vMake);
        vehicle.setVEngineType(vEngineType);
        vehicle.setVFuelType(vFuelType);
        vehicle.setVColor(vColor);
        vehicle.setOwnerId(Integer.parseInt(vId));

        VehicleDao vehicleDao=new VehicleDao(ConnectionProvider.getConnection());
        HttpSession session=request.getSession();
        String msg="";

        try{
            int rows =vehicleDao.update(vehicle);
            if(rows > 0){
                msg="Vehicle Updated Successfully";
            }else {
                msg="not updated vehicle failed !";

            }

        }catch (Exception e){
            e.printStackTrace();
            msg="Went Wrong Please Check Kayo";
        }
        session.setAttribute("msg",msg);
        response.sendRedirect("pages/UpdateVehicle.jsp");


    }
}


