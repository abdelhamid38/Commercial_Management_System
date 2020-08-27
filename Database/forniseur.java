package DB;
import java.util.Date;

    public class forniseur {
    
       private int IDF;
       private String pre_nom;
       private String nom_for;
       private String nom_pro;
       private int num_tlf;
       private Date date;
    
    public forniseur(){
        super();
    }
    public forniseur(int ID,String pre_nom,String nom_for,String nom_pro,int num_tlf,Date date){
        this.IDF=ID;
        this.nom_for=nom_for;
        this.num_tlf=num_tlf;
        this.nom_pro=nom_pro;
        this.pre_nom=pre_nom;
        this.date=date;
        
    }
    public int getID() {
        return IDF;
    }
    public void setID(int ID) {
        this.IDF = ID;
    }
    public String getNom_for() {
        return nom_for;
    }
    public void setNom_for(String nom_for) {
        this.nom_for = nom_for;
    }
    public int getNum_tlf() {
        return num_tlf;
    }
    public void setNum_tlf(int num_tlf) {
        this.num_tlf = num_tlf;
    }
    public String getNom_pro() {
        return nom_pro;
    }
    public void setNom_pro(String nom_pro) {
        this.nom_pro = nom_pro;
    }
    public String getPre_nom() {
        return pre_nom;
    }
    public void setPre_nom(String pre_nom) {
        this.pre_nom = pre_nom;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }   
}
