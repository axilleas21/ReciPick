package com.app.recipick.data.Recipe_Ingredients;
import android.content.Context;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.app.recipick.data.GeneralDao;
import com.app.recipick.data.Ingredient.Ingredient;
import com.app.recipick.data.Ingredient.IngredientDao;
import com.app.recipick.data.Ingredient.IngredientFts;
import com.app.recipick.data.Recipe.Recipe;
import com.app.recipick.data.Recipe.RecipeDao;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface Recipe_IngredientsDao extends GeneralDao<Recipe_Ingredients> {

    @Query("SELECT Ingredient.name FROM Ingredient " +
            "JOIN Recipe_Ingredients ON Ingredient.id = Recipe_Ingredients.ingredientId " +
            "WHERE Recipe_Ingredients.recipeId = :id")
    List<String> getIngredientNamesForRecipe(int id);

    /**
     * Finds recipes where the user has ALL the required ingredients selected.
     * (i.e., you can cook this recipe right now).
     */
    @Query("SELECT Recipe.* FROM Recipe " +
            "WHERE NOT EXISTS ( " +
            "    SELECT 1 " +
            "    FROM Recipe_Ingredients ri " +
            "    JOIN Ingredient i ON i.id = ri.ingredientId " +
            "    WHERE ri.recipeId = Recipe.id " +
            "    AND i.selected = 0 " +
            ")")
    List<Recipe> getRecipesMatchingAllSelected();
}