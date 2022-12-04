package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CapoBeanDAO {

    public CapoBean doRetrieveById(int id) {
        try (Connection connection = ConPool.getConnection()) {
            PreparedStatement ps =
                    connection.prepareStatement("SELECT idcapo, nome, marca, prezzo, immagine FROM capo WHERE idcapo=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                CapoBean capoBean = new CapoBean();
                capoBean.setId(rs.getInt(1));
                capoBean.setName(rs.getString(2));
                capoBean.setBrand(rs.getString(3));
                capoBean.setPrice(rs.getDouble(4));
                capoBean.setImage(rs.getString(5));

                return capoBean;
            }

            return null;
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<CapoBean> doRetrieveAll(){
        List<CapoBean> list = new ArrayList<>();
        CapoBean capoBean;
        Statement st;
        ResultSet rs;

        try (Connection con = ConPool.getConnection()) {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM capo WHERE 1=1");

            while(rs.next()) {
                capoBean = new CapoBean();

                capoBean.setId(rs.getInt(1));
                capoBean.setName(rs.getString(2));
                capoBean.setBrand(rs.getString(3));
                capoBean.setPrice(rs.getDouble(4));
                capoBean.setImage(rs.getString(6));

                list.add(capoBean);
            }

            con.close();
            return list;
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(CapoBean capoBean){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO capo(nome,marca,prezzo,immagine) VALUES(?,?,?,?)");

            ps.setString(1, capoBean.getName());
            ps.setString(2, capoBean.getBrand());
            ps.setString(3, String.valueOf(capoBean.getPrice()));
            ps.setString(4, capoBean.getImage());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
