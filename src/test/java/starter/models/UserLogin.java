package starter.models;

public class UserLogin {
    private String typeUser;
    private String nameUser;
    private String user;
    private String password;

    public String getTypeUser() {
        return typeUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
