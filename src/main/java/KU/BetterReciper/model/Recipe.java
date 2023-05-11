package KU.BetterReciper.model;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.Instant;
import java.util.*;

@Data
@NoArgsConstructor
@Entity
public class Recipe {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String imgUrl;

    @ElementCollection
    private List<String> steps = new ArrayList<>();

    @ElementCollection
    private List<String> ingredients = new ArrayList<>();
    private Instant createdAt;
}
