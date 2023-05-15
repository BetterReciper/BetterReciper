package KU.BetterReciper.model;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;
import org.hibernate.annotations.ColumnTransformer;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Data
@NoArgsConstructor
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
    private Boolean isConsent;
}
