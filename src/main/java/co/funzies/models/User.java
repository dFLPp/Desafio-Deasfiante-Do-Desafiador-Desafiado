package co.funzies.models;

import java.util.ArrayList;
import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
// import io.quarkus.security.jpa.Password;
// import io.quarkus.security.jpa.UserDefinition;
// import io.quarkus.security.jpa.Username;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "users")
//@UserDefinition
public class User extends PanacheEntity {
    public User(){}
    
    public String name;

    @Column(unique=true)
    //@Username
    public String username;

    //@Password
    public String password;

    @OneToMany(mappedBy = "user")
    public List<Planet> planets = new ArrayList<Planet>();

    @OneToOne(mappedBy = "user")
    public JwtToken jwtToken = new JwtToken();

    public static User getUserByUsername(String username){
        return find("username", username).firstResult();
    }

    public String getName(){
        return this.name;
    }

    public static User getUserById(Long userId){
        return find("id", userId).firstResult();
    }

    public static void updateUser(Long UserId, String name){
        User existingUser = User.findById(UserId);
        if(existingUser != null)
            existingUser.name = name;
            existingUser.persist();
        
        //algumas nuancias para trocar a senha
        //teria q fazer validação pra trocar username pq ele é unico
    }

    public static void deleteUser(Long userId){
        User existingUser = User.findById(userId);
        if(existingUser != null && existingUser.isPersistent())
            existingUser.delete();
    }

    public static List<Planet> findPlanetsByUserId(Long userId) throws Exception{
        User user = find("id", userId).firstResult();
        if(user == null)
            throw new Exception("Usuário não existe");
        if(user.planets == null || user.planets.isEmpty())
            throw new Exception("Não existem planetas para esse usuário");
        return user.planets;
    }

    public static String getJwtFromUser(Long userId) throws Exception{
        User user = find("id", userId).firstResult();
        if(user == null)
            throw new Exception("Usuário não existe");
        if(user.jwtToken == null)
            throw new Exception("Não existem jwt para esse usuário");
        return user.jwtToken.token;
    }
}
