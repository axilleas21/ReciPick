package com.app.recipick.data.Recipe;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Recipe {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name, desc, instr;
}
