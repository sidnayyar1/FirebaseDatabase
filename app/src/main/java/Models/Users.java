package Models;

public class Users {

    private String id;
    private String username;
    private String imageURL;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Users(String id, String username, String imageURL){
        this.id=id;
        this.imageURL=imageURL;
        this.username=username;
    }


}
