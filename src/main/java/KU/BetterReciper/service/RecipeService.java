package KU.BetterReciper.service;

import KU.BetterReciper.dto.RecipeRequest;
import KU.BetterReciper.model.Recipe;
import KU.BetterReciper.repository.RecipeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.Instant;
import java.util.List;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Recipe> getAll() {
        return repository.findAll();
    }

    public void addRecipe(RecipeRequest request) {
        Recipe recipe = modelMapper.map(request, Recipe.class);
        recipe.setCreatedAt(Instant.now());
        repository.save(recipe);
    }
}
