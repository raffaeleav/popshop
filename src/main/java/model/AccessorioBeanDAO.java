package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccessorioBeanDAO {

    public AccessorioBean doRetrieveById(int id) {
        try (Connection connection = ConPool.getConnection()) {
            PreparedStatement ps =
                    connection.prepareStatement("SELECT idaccessorio, nome, marca, prezzo, immagine FROM accessorio WHERE idaccessorio=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                AccessorioBean accessorioBean = new AccessorioBean();
                accessorioBean.setId(rs.getInt(1));
                accessorioBean.setName(rs.getString(2));
                accessorioBean.setBrand(rs.getString(3));
                accessorioBean.setPrice(rs.getDouble(4));
                accessorioBean.setImage(rs.getString(5));

                return accessorioBean;
            }

            return null;
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<AccessorioBean> doRetrieveAll(){
        List<AccessorioBean> list = new ArrayList<>();
        AccessorioBean accessorioBean;
        Statement st;
        ResultSet rs;

        try (Connection con = ConPool.getConnection()) {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM accessorio WHERE 1=1");

            while(rs.next()) {
                accessorioBean = new AccessorioBean();

                accessorioBean.setId(rs.getInt(1));
                accessorioBean.setName(rs.getString(2));
                accessorioBean.setBrand(rs.getString(3));
                accessorioBean.setPrice(rs.getDouble(4));
                accessorioBean.setImage(rs.getString(5));

                list.add(accessorioBean);
            }

            con.close();
            return list;
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(AccessorioBean accessorioBean){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO accessorio(nome,marca,prezzo,immagine) VALUES(?,?,?,?)");

            ps.setString(1, accessorioBean.getName());
            ps.setString(2, accessorioBean.getBrand());
            ps.setString(3, String.valueOf(accessorioBean.getPrice()));
            ps.setString(4, accessorioBean.getImage());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
