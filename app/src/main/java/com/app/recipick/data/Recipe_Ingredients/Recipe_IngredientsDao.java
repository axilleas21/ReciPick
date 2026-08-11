package com.app.recipick.data.Recipe_Ingredients;
import androidx.room.Dao;
import androidx.room.Query;
import com.app.recipick.data.GeneralDao;
import com.app.recipick.data.Ingredient.Ingredient;
import com.app.recipick.data.Recipe.Recipe;
import java.util.ArrayList;
import java.util.List;

@Dao
public interface Recipe_IngredientsDao extends GeneralDao<Recipe_Ingredients> {

    @Query( "SELECT Ingredient.* FROM Ingredient " +
            "JOIN Recipe_Ingredients ON Ingredient.id = Recipe_Ingredients.ingredientId " +
            "WHERE Recipe_Ingredients.recipeId = :id")
    ArrayList<Ingredient> getIngredients(int id);

    /**
     * Finds recipes that contain ALL of the currently selected ingredients.
     * 
     * How it works:
     * 1. Count how many ingredients are currently selected.
     * 2. Join Recipe with Recipe_Ingredients and Ingredient.
     * 3. Filter for only selected ingredients.
     * 4. Group by Recipe so we can count matches.
     * 5. The HAVING clause ensures the count of matching ingredients in that recipe 
     *    is equal to the total number of selected ingredients.
     */
    @Query("SELECT Recipe.* FROM Recipe " +
           "JOIN Recipe_Ingredients ON Recipe.id = Recipe_Ingredients.recipeId " +
           "JOIN Ingredient ON Ingredient.id = Recipe_Ingredients.ingredientId " +
           "WHERE Ingredient.selected = 1 " +
           "GROUP BY Recipe.id " +
           "HAVING COUNT(Ingredient.id) = (SELECT COUNT(*) FROM Ingredient WHERE selected = 1)")
    List<Recipe> getRecipesMatchingAllSelected();
}
