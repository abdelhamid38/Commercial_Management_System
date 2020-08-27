package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class db_produit {
   static PreparedStatement ps;
   static ResultSet rs ;
   static Connection con ;
   static produit a=new produit();
    public static produit getproduit() throws ClassNotFoundException, SQLException{
        
           con = DB.getConnection();
           String sql = "SELECT * FROM produits WHERE 1";
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           rs.next();
           
           a.setID(rs.getInt(1));
           a.setNom_pro(rs.getString(2));
           a.setPrix(rs.getInt(3));
           a.setNom_for(rs.getString(4));
           a.setContity(rs.getInt(5));
           a.setDate(rs.getDate(6));
           
           con.close();
        return a;
    }
}