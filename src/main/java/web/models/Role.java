package web.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    public Role() {
    }

    public Role(long id) {
        this.id = id;
    }

    public Role(long id, Set<User> users) {
        this.id = id;
        this.users = users;
    }

    public Role(long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Role(long id, String roleName, Set<User> users) {
        this.id = id;
        this.roleName = roleName;
        this.users = users;
    }

    public Role(Set<User> users) {
        this.users = users;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String roleName;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role(String role) {
        this.roleName = role;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRole(String role) {
        this.roleName = role;
    }

    @Override
    public String getAuthority() {
        return getRoleName();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
