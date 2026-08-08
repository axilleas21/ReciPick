package com.app.recipick.models;

public class Ingredient{
    private String name; private boolean selected;
    public Ingredient(String name){this.name=name;selected=false;}
    public String getName(){return name;}
    public boolean isSelected(){return selected;}
    public void setSelected(boolean selected){this.selected=selected;}
}
