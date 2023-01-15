package eu.jev.controller;

import eu.jev.service.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anySet;

class IndexControllerTest {

    IndexController indexController;

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        indexController = new IndexController(recipeService);
    }

    @Test
    void getIndexPage() {
        String viewName = indexController.getIndexPage(model);

        assertEquals("index", viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), anySet());
    }
}