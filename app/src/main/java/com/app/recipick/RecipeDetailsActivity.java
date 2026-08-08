package com.app.recipick;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.app.recipick.models.Recipe;
public class RecipeDetailsActivity extends AppCompatActivity{
    private TextView txtRecipeName;private TextView txtDescription;
    private TextView txtIngredients;private TextView txtInstructions;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        initializeViews();
        Recipe recipe=(Recipe) getIntent().getSerializableExtra("recipe");
        if(recipe!=null){
            txtRecipeName.setText(recipe.getName());                 // me auta emfanizontai sto ui
            txtDescription.setText(recipe.getDescription());
            StringBuilder ingredientsText=new StringBuilder();       // ftoiaxnei th lista
            for(String ingredient:recipe.getIngredients()){
                ingredientsText.append("- ").append(ingredient).append("\n");
            }
            txtIngredients.setText(ingredientsText.toString());
            txtInstructions.setText(recipe.getInstructions());
        }
    }

    private void initializeViews(){
        txtRecipeName=findViewById(R.id.txtRecipeName);
        txtDescription=findViewById(R.id.txtDescription);
        txtIngredients=findViewById(R.id.txtIngredients);
        txtInstructions=findViewById(R.id.txtInstructions);
    }
}
