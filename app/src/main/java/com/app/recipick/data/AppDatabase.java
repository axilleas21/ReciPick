package com.app.recipick.data;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.app.recipick.data.Ingredient.Ingredient;
import com.app.recipick.data.Ingredient.IngredientDao;
import com.app.recipick.data.Ingredient.IngredientFts;
import com.app.recipick.data.Recipe.Recipe;
import com.app.recipick.data.Recipe_Ingredients.Recipe_Ingredients;

@Database(entities = {Recipe.class, Ingredient.class, Recipe_Ingredients.class, IngredientFts.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract IngredientDao ingredientDao();
}
