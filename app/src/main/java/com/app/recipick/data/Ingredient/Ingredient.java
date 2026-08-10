package com.app.recipick.data.Ingredient;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Ingredient {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public boolean selected=false;
}
