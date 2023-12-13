package co.funzies.models;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="jwt_tokens")
public class JwtToken extends PanacheEntity {
    public String token;
    public LocalDate creationDate;
    public LocalDate ExpiresDate;

    @OneToOne(cascade = CascadeType.ALL)
    public User user;

    public JwtToken(){}
}
