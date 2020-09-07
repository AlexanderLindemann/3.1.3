package web.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String password;
    @Column(unique = true)
    private String username;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private int weight;
    @Column(nullable = false)
    private int height;
    @JsonIgnore
    @Transient
    transient private String confirmPassword;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();


    public User() { }

    public User(String name, String password) {
        this.username = name;
        this.password = password;
    }

    public User(long id, String name, String password) {
        this.id = id;
        this.username = name;
        this.password = password;
    }

    public User(long id) {
        this.id = id;
    }

    public User(long id, String password, String username, String lastName, int weight, int height) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.lastName = lastName;
        this.weight = weight;
        this.height = height;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getStringRole() {
        StringBuilder stringBuilder = new StringBuilder();
        Object[] objects = roles.stream().map(Role::getRoleName).toArray();
        String[] roleArr = Arrays.copyOf(objects, objects.length, String[].class);
        for (int i = 0; i < roleArr.length; i++) {
            stringBuilder.append(roleArr[i]);
            if (roleArr.length > 1 && i < roleArr.length - 1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
