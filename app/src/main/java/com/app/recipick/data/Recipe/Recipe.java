package com.app.recipick.data.Recipe;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Recipe {
    @PrimaryKey(autoGenerate = true) public int id;
    public String name, desc, instr;

    @Ignore
    public String getName(){return name;}
    @Ignore
    public String getDescription(){return desc;}
    @Ignore
    public String getInstructions(){return instr;}
}
