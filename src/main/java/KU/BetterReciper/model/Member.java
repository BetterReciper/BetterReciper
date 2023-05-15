package KU.BetterReciper.model;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.Column;

@Entity
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition="VARBINARY(256)")
    @ColumnTransformer(
            read = "cast(AES_DECRYPT(username, UNHEX('key')) as char(255))",
            write = "AES_ENCRYPT(?, UNHEX('key'))"
    )
    private String username;
    private String password;
    @Column(columnDefinition="VARBINARY(256)")
    @ColumnTransformer(
            read = "cast(AES_DECRYPT(username, UNHEX('key')) as char(255))",
            write = "AES_ENCRYPT(?, UNHEX('key'))"
    )
    private String firstName;
    private String lastName;
    private String email;

    // .... generate getter/setter for all attributes

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
