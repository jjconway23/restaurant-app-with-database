package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    public Dishes addDish(Dishes dish) {
        return dishRepository.save(dish);
    }

    public Iterable<Dishes> getAllDishes(){
        return dishRepository.findAll();
    }

    public Optional<Dishes> getDishById(Integer id){
        return dishRepository.findById(id);
    }

    public Dishes updateDish(Integer id, Dishes dish){
        Optional<Dishes> dishToUpdateOptional = dishRepository.findById(id);
        if(!dishToUpdateOptional.isPresent()){
            return null;
        }
        Dishes dishToUpdate = dishToUpdateOptional.get();
        if(dish.getIsLiked() != null){
            dishToUpdate.setIsLiked(dish.getIsLiked());
        }
        if(dish.getDishName() !=null){
            dishToUpdate.setDishName(dish.getDishName());
        }
        if(dish.getDishType() !=null){
            dishToUpdate.setDishType(dish.getDishType());
        }
        if(dish.getPrice() != null){
            dishToUpdate.setPrice(dish.getPrice());
        }
        Dishes updatedDish = dishRepository.save(dishToUpdate);
        return updatedDish;
    }
    public Dishes deleteDish(Integer id){
        Optional<Dishes> dishToDeleteOptional = dishRepository.findById(id);
        if(!dishToDeleteOptional.isPresent()){
            return null;
        }
        Dishes dishToDelete = dishToDeleteOptional.get();
        dishRepository.delete(dishToDelete);
        return dishToDelete;
    }
}
