package com.app.recipick.data;

import com.app.recipick.models.Recipe;
import java.util.ArrayList;

public class FakeRepo{
    private static ArrayList<Recipe> recipes;
    public static ArrayList<Recipe> getRecipes(){
        if(recipes==null){
            recipes=new ArrayList<>();

            ArrayList<String> ingredients1=new ArrayList<>();
            ingredients1.add("Egg");
            ingredients1.add("Bread");
            ingredients1.add("Butter");
            recipes.add(new Recipe("Egg Toast","Quick and simple breakfast!",ingredients1,"Toast the bread, fry the egg in a pan and enjoy!"));

            ArrayList<String> ingredients2=new ArrayList<>();
            ingredients2.add("Pasta");
            ingredients2.add("Tomato");
            ingredients2.add("Cheese");
            recipes.add(new Recipe("Pasta","Easy pasta recipe.",ingredients2,"Boil pasta, add tomato sauce and serve with cheese on top."));

            ArrayList<String> ingredients3=new ArrayList<>();
            ingredients3.add("Chicken");
            ingredients3.add("Rice");
            recipes.add(new Recipe("Chicken and Rice","Simple lunch full fo protein!",ingredients3,"Cook the chicken and serve with rice."));
        }
        return recipes;
    }

    public static ArrayList<Recipe> searchRecipes(ArrayList<String> availableIngredients){
        ArrayList<Recipe> results=new ArrayList<>();
        for(Recipe recipe:getRecipes()){
            boolean matches=true;
            // elegxei ta recipes me matching ingredients
            for(String ingredient:recipe.getIngredients()){if(!availableIngredients.contains(ingredient)){matches=false; break;}}
            if(matches){results.add(recipe);} // oti vrei matching to emfanizei
        }
        return results;
    }
}





