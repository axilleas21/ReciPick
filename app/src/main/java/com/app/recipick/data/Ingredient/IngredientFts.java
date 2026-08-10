package com.app.recipick.data.Ingredient;
import androidx.room.Entity;
import androidx.room.Fts4;

@Fts4(contentEntity = Ingredient.class)
@Entity(tableName = "ingredients_fts")
public class IngredientFts {
    public String name;
}
