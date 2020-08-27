package DB;

import java.util.Date;
public class produit {
    private int id;
    private String nom_pro;
    private String nom_for;
    private int prix;
    private int contity;
    private Date date;

    public produit() {
        super();
    }
    

    public produit(int ID, String nom_pro, String nom_for, int prix, int contity, Date date) {
        super();
        this.id = ID;
        this.nom_pro = nom_pro;
        this.nom_for = nom_for;
        this.prix = prix;
        this.contity = contity;
        this.date = date;
    }

    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = ID;
    }

    public String getNom_pro() {
        return nom_pro;
    }

    public void setNom_pro(String nom_pro) {
        this.nom_pro = nom_pro;
    }

    public String getNom_for() {
        return nom_for;
    }

    public void setNom_for(String nom_for) {
        this.nom_for = nom_for;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getContity() {
        return contity;
    }

    public void setContity(int contity) {
        this.contity = contity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public produit(int id, String nom_pro, int prix, int contity) {
        this.id = id;
        this.nom_pro = nom_pro;
        this.prix = prix;
        this.contity = contity;
    }
    
    
}
