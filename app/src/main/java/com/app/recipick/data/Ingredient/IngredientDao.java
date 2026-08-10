package com.app.recipick.data.Ingredient;

import androidx.room.Dao;
import androidx.room.Query;

import com.app.recipick.data.GeneralDao;

import java.util.List;

@Dao
public interface IngredientDao extends GeneralDao<Ingredient> {
    @Query("SELECT * FROM Ingredient JOIN ingredients_fts ON Ingredient.id = ingredients_fts.rowid WHERE ingredients_fts.name MATCH :query")
    List<Ingredient> search(String query);
}
