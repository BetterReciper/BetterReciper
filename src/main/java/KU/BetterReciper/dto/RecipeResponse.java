package KU.BetterReciper.dto;

import lombok.Data;

import java.util.List;

@Data
public class RecipeResponse {
    private String name;
    private String imgUrl;
    private List<String> steps;
    private List<String> ingredients;
}
