package com.app.recipick.data.Ingredient;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Ingredient {
    @PrimaryKey(autoGenerate = true) public int id;
    public String name;
    public boolean selected=false;

    @Ignore
    public String getName(){return name;}
    @Ignore
    public boolean isSelected(){return selected;}
    @Ignore
    public void setSelected(boolean selected){this.selected=selected;}
}
