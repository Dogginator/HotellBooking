
package hotellbooking;

public class PassWord {
    
    private String passName;
    private String passKey;
    private String adress;
    
    
    
    public PassWord(String passName, String passKey, String adress){
        this.passName = passName;
        this.passKey = passKey;
        this.adress = adress;
    }

    public String getPassName() {
        return passName;
    }

    public void setPassName(String passName) {
        this.passName = passName;
    }

    public String getPassKey() {
        return passKey;
    }

    public void setPassKey(String passKey) {
        this.passKey = passKey;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
    
    
    
}
