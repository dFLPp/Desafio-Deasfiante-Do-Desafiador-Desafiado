package co.funzies.dtos;

import co.funzies.models.User;

public class UserDTO {
    private String name;
    private String username;
    private String password;

    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }

    public User toEntity(){
        User user = new User();
        user.name = this.getName();
        user.username = this.getUsername();
        user.password = this.getPassword();
        return user;
    }

    public UserDTO(){}

}
