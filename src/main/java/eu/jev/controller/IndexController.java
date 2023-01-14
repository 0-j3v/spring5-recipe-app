package eu.jev.controller;

import eu.jev.domain.Category;
import eu.jev.domain.UnitOfMeasure;
import eu.jev.repository.CategoryRepository;
import eu.jev.repository.UnitOfMeasureRepository;
import eu.jev.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.Optional;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
