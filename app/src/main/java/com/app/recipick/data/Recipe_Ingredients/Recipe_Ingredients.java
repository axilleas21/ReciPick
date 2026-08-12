package com.app.recipick.data.Recipe_Ingredients;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import com.app.recipick.data.Ingredient.Ingredient;
import com.app.recipick.data.Recipe.Recipe;

@Entity(tableName = "Recipe_Ingredients", primaryKeys = {"recipeId","ingredientId"}, foreignKeys={@ForeignKey(entity = Recipe.class, parentColumns = "id", childColumns = "recipeId"), @ForeignKey(entity = Ingredient.class, parentColumns = "id", childColumns = "ingredientId")},indices = {@Index("recipeId"),@Index("ingredientId")})
public class Recipe_Ingredients {
    public int recipeId, ingredientId;
}