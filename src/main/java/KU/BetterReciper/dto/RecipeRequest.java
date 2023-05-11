package KU.BetterReciper.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class RecipeRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String imgUrl;
    private List<String> steps;
    private List<String> ingredients;
}
