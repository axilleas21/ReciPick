package com.app.recipick.data;
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.app.recipick.data.Ingredient.Ingredient;
import com.app.recipick.data.Ingredient.IngredientDao;
import com.app.recipick.data.Ingredient.IngredientFts;
import com.app.recipick.data.Recipe.Recipe;
import com.app.recipick.data.Recipe.RecipeDao;
import com.app.recipick.data.Recipe_Ingredients.Recipe_Ingredients;
import com.app.recipick.data.Recipe_Ingredients.Recipe_IngredientsDao;

@Database(entities = {Recipe.class, Ingredient.class, Recipe_Ingredients.class, IngredientFts.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract IngredientDao ingredientDao();
    public abstract Recipe_IngredientsDao recipeIngredientsDao();
    public abstract RecipeDao recipeDao();

    private static volatile AppDatabase INSTANCE;

    // 2. Thread-safe getter
    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(), // Use application context to avoid memory leaks
                                    AppDatabase.class,
                                    "recipickdb.db"
                            )
                            .createFromAsset("database/recipickdb.db") // If prepopulating
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}