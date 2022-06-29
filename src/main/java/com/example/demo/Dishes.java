package com.example.demo;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table(name="Dishes")
@Data
public class Dishes {

    @Id
    @Column(name = "dish_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dishId;

    @Column(name = "dish_name",nullable = false)
    private String dishName;

    @Column(name = "price",nullable = false)
    private Double price;

    @Column(name = "is_liked")
    private Boolean isLiked;

    @Column(name = "dish_type")
    private String dishType;



}
