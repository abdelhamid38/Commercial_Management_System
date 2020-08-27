package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class db_forniseur {
   static PreparedStatement ps;
   static ResultSet rs ;
   static Connection con ;
   static forniseur a=new  forniseur();
   public static forniseur getproduit(){
        try {
           con = DB.getConnection();
           String sql = "SELECT * FROM forniseur WHERE 1";
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           
           a.setID(rs.getInt(1)); 
           a.setPre_nom(rs.getString(2)); 
           a.setNom_for(rs.getString(3));
           a.setNom_pro(rs.getNString(4));
           a.setNum_tlf(rs.getInt(5));
           a.setDate(rs.getDate(6));
           
           con.close();
           ps.close();
           rs.close();
           
           } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } 
        return a;
    }
}
