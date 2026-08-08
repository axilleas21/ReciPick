package com.app.recipick.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Recipe implements Serializable{ // na mh vgaloume to implements Serializable gt xalaei full
    private String name;private String description; private ArrayList<String> ingredients;private String instructions;
    public Recipe(String name,String description,ArrayList<String> ingredients,String instructions){
        this.name=name; this.description=description;
        this.ingredients=ingredients; this.instructions=instructions;
    }
    public String getName(){return name;}
    public String getDescription(){return description;}
    public ArrayList<String> getIngredients(){return ingredients;}
    public String getInstructions(){return instructions;}
}
