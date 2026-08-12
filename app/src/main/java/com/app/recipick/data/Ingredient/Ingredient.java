package com.app.recipick.data.Ingredient;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Ingredient {
    @PrimaryKey public int id;
    public String name;
    public boolean selected=false;

    @Ignore
    public String getName(){return name;}
    @Ignore
    public boolean isSelected(){return selected;}
}
