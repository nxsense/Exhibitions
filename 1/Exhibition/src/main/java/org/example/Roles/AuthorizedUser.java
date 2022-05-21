package org.example.Roles;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "authorizeduser")
public class AuthorizedUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank
    private String FirstName;
    @NotBlank
    private String LastName;
    @Email(regexp = ".+(@acme.com)$")
    @NotBlank
    private String Email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank
    private String Password;

    @ElementCollection
    private List<String> tickets;

    @JsonIgnore
    protected boolean accountNonExpired;
    @JsonIgnore
    protected boolean accountNonLocked;
    @JsonIgnore
    protected boolean credentialsNonExpired;
    @JsonIgnore
    protected boolean enabled;
    @JsonIgnore
    @ElementCollection(fetch = FetchType.EAGER)
    protected Set<GrantedAuthority> authorities;

    public AuthorizedUser(String firstName, String lastName, String email, String password, String[] tickets) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Email = email;
        this.Password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    @Override
    public String getUsername() {
        return Email;
    }

    @Override
    public String getPassword() {
        return Password;
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
}
