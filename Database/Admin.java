package DB;
public class Admin {
    private int ID;
    private String username;
    private String password;
   
    
    public Admin(){
        super();
    }
    
    public Admin(int ID,String username,String password){
        super();
        this.ID=ID;
        this.username=username;
        this.password=password;
       
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }  
}