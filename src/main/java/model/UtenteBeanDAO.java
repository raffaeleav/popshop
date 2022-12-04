package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtenteBeanDAO {

    public UtenteBean doRetrieveById(int id) {
        try (Connection connection = ConPool.getConnection()) {
            PreparedStatement ps =
                    connection.prepareStatement("SELECT idutente, nome, cognome, email, passw, indirizzo, cartacr FROM utente WHERE idutente=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                UtenteBean utenteBean = new UtenteBean();
                utenteBean.setId(rs.getInt(1));
                utenteBean.setName(rs.getString(2));
                utenteBean.setSurname(rs.getString(3));
                utenteBean.setEmail(rs.getString(4));
                utenteBean.setPassword(rs.getString(5));
                utenteBean.setAddress(rs.getString(6));
                utenteBean.setCreditCard(rs.getString(7));

                return utenteBean;
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<UtenteBean> doRetrieveAll(){
        List<UtenteBean> list = new ArrayList<>();
        UtenteBean utenteBean;
        Statement st;
        ResultSet rs;

        try (Connection con = ConPool.getConnection()) {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM utente WHERE 1=1");

            while(rs.next()) {
                utenteBean = new UtenteBean();

                utenteBean.setId(rs.getInt(1));
                utenteBean.setName(rs.getString(2));
                utenteBean.setSurname(rs.getString(3));
                utenteBean.setEmail(rs.getString(4));
                utenteBean.setPassword(rs.getString(5));
                utenteBean.setAddress(rs.getString(6));
                utenteBean.setCreditCard(rs.getString(7));

                list.add(utenteBean);
            }

            con.close();
            return list;
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(UtenteBean utenteBean) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO utente(nome,cognome,email,passw,indirizzo,cartacr) VALUES(?,?,?,?,?,?)");

            ps.setString(1, utenteBean.getName());
            ps.setString(2, utenteBean.getSurname());
            ps.setString(3, utenteBean.getEmail());
            ps.setString(4, utenteBean.getPassword());
            ps.setString(5, utenteBean.getAddress());
            ps.setString(6, utenteBean.getCreditCard());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
