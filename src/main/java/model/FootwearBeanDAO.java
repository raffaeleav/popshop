package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FootwearBeanDAO {

    public FootwearBean doRetrieveById(int id) {
        try (Connection connection = ConPool.getConnection()) {
            PreparedStatement ps =
                    connection.prepareStatement("SELECT idscarpe, nome, marca, prezzo, immagine FROM scarpe WHERE idscarpe=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                FootwearBean footwearBean = new FootwearBean();
                footwearBean.setId(rs.getInt(1));
                footwearBean.setName(rs.getString(2));
                footwearBean.setBrand(rs.getString(3));
                footwearBean.setPrice(rs.getDouble(4));
                footwearBean.setImage(rs.getString(5));

                return footwearBean;
            }

            return null;
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<FootwearBean> doRetrieveAll(){
        List<FootwearBean> list = new ArrayList<>();
        FootwearBean footwearBean;
        Statement st;
        ResultSet rs;

        try (Connection con = ConPool.getConnection()) {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM scarpe WHERE 1=1");

            while(rs.next()) {
                footwearBean = new FootwearBean();

                footwearBean.setId(rs.getInt(1));
                footwearBean.setName(rs.getString(2));
                footwearBean.setBrand(rs.getString(3));
                footwearBean.setPrice(rs.getDouble(4));
                footwearBean.setImage(rs.getString(6));

                list.add(footwearBean);
            }

            con.close();
            return list;
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(FootwearBean footwearBean){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO scarpe(nome,marca,prezzo,immagine) VALUES(?,?,?,?)");

            ps.setString(1, footwearBean.getName());
            ps.setString(2, footwearBean.getBrand());
            ps.setString(3, String.valueOf(footwearBean.getPrice()));
            ps.setString(4, footwearBean.getImage());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
