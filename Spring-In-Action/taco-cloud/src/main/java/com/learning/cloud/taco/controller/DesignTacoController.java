package com.learning.cloud.taco.controller;

import com.learning.cloud.taco.domain.Ingredient;
import com.learning.cloud.taco.domain.Order;
import com.learning.cloud.taco.domain.Taco;
import com.learning.cloud.taco.repository.IngredientRepository;
import com.learning.cloud.taco.repository.TacoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientRepository ingredients;
    private final TacoRepository tacos;

    @ModelAttribute("order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute("taco")
    public Taco taco() {
        return new Taco();
    }

    @Autowired
    public DesignTacoController(IngredientRepository ingredients, TacoRepository tacos) {

        this.ingredients = ingredients;
        this.tacos = tacos;

    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        this.ingredients.findAll().forEach(ingredients::add);

        Ingredient.Type[] allTypes = Ingredient.Type.values();
        for (Ingredient.Type type : allTypes) {
            model.addAttribute(type.toString().toLowerCase(), filterIngredientsByType(ingredients, type));

        }

        model.addAttribute("design", new Taco());

        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Taco design, @ModelAttribute Order order, Errors formErrors) {

        if (formErrors.hasErrors()) {
            return "design";
        }

        /*
         * Let's save the design.
         */
        Taco saved = this.tacos.save(design);
        order.addDesign(saved);

        log.info("Processing Design: " + design);
        return "redirect:/orders/current";

    }

    private List<Ingredient> filterIngredientsByType(List<Ingredient> allIngredients, Ingredient.Type type) {

        return allIngredients.stream()
                .filter(ingredient -> ingredient.getType().equals(type))
                .collect(Collectors.toList());

    }

}