package dao;

import bean.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class VehicleDao {
    Connection con = null;

    public VehicleDao(Connection con) {
        this.con = con;
    }


    public int insert(Vehicle vehicle) throws Exception {
        String query = "INSERT INTO vehicle (vRegister, vMake, vEngineType, vFuelType, vColor) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, vehicle.getVRegister());
        ps.setString(2, vehicle.getVMake());
        ps.setString(3, vehicle.getVEngineType());
        ps.setString(4, vehicle.getVFuelType());
        ps.setString(5, vehicle.getVColor());

        int rows = ps.executeUpdate();
        return rows;
    }


    public ArrayList<Vehicle> getAll() throws Exception {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        String query = "SELECT * FROM vehicle";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Vehicle vehicle = new Vehicle();
            vehicle.setVId(rs.getInt("vId"));
            vehicle.setVRegister(rs.getString("vRegister"));
            vehicle.setVMake(rs.getString("vMake"));
            vehicle.setVEngineType(rs.getString("vEngineType"));
            vehicle.setVFuelType(rs.getString("vFuelType"));
            vehicle.setVColor(rs.getString("vColor"));

            vehicleList.add(vehicle);
        }

        return vehicleList;
    }


    public Vehicle search(int id) throws Exception {
        Vehicle vehicle = new Vehicle();
        String query = "SELECT * FROM vehicle WHERE vId = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            vehicle.setVId(rs.getInt("vId"));
            vehicle.setVRegister(rs.getString("vRegister"));
            vehicle.setVMake(rs.getString("vMake"));
            vehicle.setVEngineType(rs.getString("vEngineType"));
            vehicle.setVFuelType(rs.getString("vFuelType"));
            vehicle.setVColor(rs.getString("vColor"));
        }

        return vehicle;
    }


    public int delete(int id) throws Exception {
        String query = "DELETE FROM vehicle WHERE vId = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();
        return rows;
    }


    public int update(Vehicle vehicle) throws Exception {
        String query = "UPDATE vehicle SET vRegister = ?, vMake = ?, vEngineType = ?, vFuelType = ?, vColor = ? WHERE vId = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, vehicle.getVRegister());
        ps.setString(2, vehicle.getVMake());
        ps.setString(3, vehicle.getVEngineType());
        ps.setString(4, vehicle.getVFuelType());
        ps.setString(5, vehicle.getVColor());
        ps.setInt(6, vehicle.getVId());

        int rows = ps.executeUpdate();
        return rows;
    }


    public Vehicle searchByRegister(String register) throws Exception {
        Vehicle vehicle = null;
        String query = "SELECT * FROM vehicle WHERE vRegister = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, register);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            vehicle = new Vehicle();
            vehicle.setVId(rs.getInt("vId"));
            vehicle.setVRegister(rs.getString("vRegister"));
            vehicle.setVMake(rs.getString("vMake"));
            vehicle.setVEngineType(rs.getString("vEngineType"));
            vehicle.setVFuelType(rs.getString("vFuelType"));
            vehicle.setVColor(rs.getString("vColor"));
        }

        return vehicle;
    }
}
