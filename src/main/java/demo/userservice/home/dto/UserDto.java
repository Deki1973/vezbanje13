package demo.userservice.home.dto;

public class UserDto {
    // vezbamo branchovanje
    // vidi https://graphite.dev/guides/how-to-sync-git-branch-with-main
    
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    private String role;
    private Boolean active;
}
