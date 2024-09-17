package dao;

import bean.Owner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OwnerDao {
        Connection con = null;

  public   OwnerDao(Connection con) {
        this.con = con;

    }

    public int insert(Owner owner) throws Exception {

        String query = "INSERT INTO owners (oName, oFatherName,oCnic,oRemarks) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, owner.getoName());
        ps.setString(2, owner.getoFatherName());
        ps.setString(3, owner.getoCnic());
        ps.setString(4, owner.getoRemarks());

        int rows = ps.executeUpdate();
        return rows;
    }

    public ArrayList<Owner> getAll() throws Exception {
        ArrayList<Owner> ownerList = new ArrayList<>();
        String query = "SELECT * FROM owners";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Owner owner = new Owner();
            owner.setoName(rs.getString("oName"));
            owner.setoFatherName(rs.getString("oFatherName"));
            owner.setoCnic(rs.getString("OCnic"));
            owner.setoRemarks(rs.getString("oRemarks"));
            owner.setoId(rs.getInt("oId"));

            ownerList.add(owner);
        }

        return ownerList;
    }

    public Owner search(int id) throws Exception {
        Owner owner = new Owner();

        String query = "SELECT * FROM owners WHERE oid = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            owner.setoId(rs.getInt("oid"));

            owner.setoName(rs.getString("oName"));
            owner.setoFatherName(rs.getString("oFatherName"));
            owner.setoCnic(rs.getString("OCnic"));
            owner.setoRemarks(rs.getString("oRemarks"));


        }

        return owner;
    }
    // return null kayan tho ok aw


//haren detlete shuro kayan and update

        public int delete(int id) throws Exception {
            String query = "DELETE FROM owners WHERE oid = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            return rows;
        }


        public int update(Owner owner) throws Exception {
            String query = "UPDATE owners SET oName = ?, oFatherName = ?, oCnic = ?, oRemarks = ? WHERE oid = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, owner.getoName());
            ps.setString(2, owner.getoFatherName());
            ps.setString(3, owner.getoCnic());
            ps.setString(4, owner.getoRemarks());
            ps.setInt(5, owner.getoId());

            int rows = ps.executeUpdate();
            return rows;
        }
        public Owner searchCnic(String Cnic) throws Exception {
            Owner owner=null;
            String query = "select * FROM owners WHERE oCnic = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, Cnic);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                owner = new Owner();
                owner.setoId(rs.getInt("oid"));
                owner.setoName(rs.getString("oName"));
                owner.setoFatherName(rs.getString("oFatherName"));
                owner.setoCnic(rs.getString("OCnic"));
                owner.setoRemarks(rs.getString("oRemarks"));
            }

            return  owner;



        }



}
