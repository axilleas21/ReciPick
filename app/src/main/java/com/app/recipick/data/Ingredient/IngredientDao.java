package com.app.recipick.data.Ingredient;
import androidx.room.Dao;
import androidx.room.Query;
import com.app.recipick.data.GeneralDao;
import java.util.List;

@Dao
public interface IngredientDao extends GeneralDao<Ingredient>{
    @Query("UPDATE Ingredient SET selected=:isSelected WHERE id=:id")
    void updateSelection(int id, int isSelected);
}