package KU.BetterReciper.controller;

import KU.BetterReciper.dto.RecipeRequest;
import KU.BetterReciper.model.Recipe;
import KU.BetterReciper.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "http://localhost:8080/api/recipe")
@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    @Autowired
    private RecipeService service;

    @GetMapping
    public List<Recipe> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody RecipeRequest recipe,
                                 BindingResult result) {

        if (result.hasErrors())
            return new ResponseEntity("Invalid request format", HttpStatus.UNPROCESSABLE_ENTITY);

        service.addRecipe(recipe);
        return new ResponseEntity(recipe, HttpStatus.OK);
    }
}
