package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DishesController {

    @Autowired
    private DishService dishService;

    @GetMapping("/dishes")
    public Iterable<Dishes> getAllDishes(){
        return dishService.getAllDishes();
    }
    @GetMapping("/dishes/{id}")
    public Optional<Dishes> getDishById(@PathVariable(name = "id") Integer id){
        return dishService.getDishById(id);
    }

    @PostMapping("/addDish")
    public Dishes addDish(@RequestBody Dishes dish){
        return dishService.addDish(dish);
    }
    @PutMapping("/dishes/{id}")
    public Dishes updateDish(@PathVariable(name = "id") Integer id, @RequestBody Dishes dish){
        return dishService.updateDish(id,dish);
    }
    @DeleteMapping("/dishes/{id}")
    public Dishes deleteDish(@PathVariable(name = "id") Integer id){
        return dishService.deleteDish(id);
    }
}
