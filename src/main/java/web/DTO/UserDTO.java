package web.DTO;

import org.springframework.stereotype.Component;
import web.models.Role;
import web.models.User;

import java.util.Arrays;

public class UserDTO {
    private Long id;
    private String password;
    private String username;
    private String lastName;
    private int weight;
    private int height;
    private String[] roles;

    public UserDTO(User user) {
        this.id = user.getId();
        this.password = user.getPassword();
        this.username = user.getUsername();
        this.lastName = user.getLastName();
        this.weight = user.getWeight();
        this.height = user.getHeight();
        Object[] objects = user.getRoles().stream().map(Role::getRoleName).toArray();
        this.roles = Arrays.copyOf(objects, objects.length, String[].class);
    }

    public UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}
