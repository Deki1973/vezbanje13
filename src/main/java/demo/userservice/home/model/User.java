package demo.userservice.home.model;


import jakarta.persistence.*;


import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = true, unique = true)
    private String googleId;


    @Column(nullable = true, unique = true)
    private String email;


    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private Boolean active = true;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    public  String getEmail() {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName( String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }



    public User() {

    }

    public User(String email, String name, Role role) {
        this.email = email;
        this.name = name;
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {

        if(this==obj) return true;
        if(obj==null || getClass()!=obj.getClass()) return false;
        User user=(User) obj;
        return Objects.equals(id, user.id) && Objects.equals(googleId, user.googleId) && Objects.equals(email, user.email) && Objects.equals(name, user.name) && role == user.role && Objects.equals(active, user.active);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, googleId, email, name, role, active);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", googleId='" + googleId + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", active=" + active +
                '}';
    }
}
