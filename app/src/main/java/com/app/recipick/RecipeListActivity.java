package com.app.recipick;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.app.recipick.adapters.TheAdapter;
import com.app.recipick.data.FakeRepo;
import com.app.recipick.models.Recipe;
import java.util.ArrayList;

public class RecipeListActivity extends AppCompatActivity{
    private RecyclerView recyclerRecipes;private TheAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        recyclerRecipes=findViewById(R.id.recyclerRecipes);  // kanei ksana kai ksana to item tou recipe
        ArrayList<String> ingredients=getIntent().getStringArrayListExtra("ingredients"); // lamvanei ta dedomena apo to MainActivity
        if(ingredients==null){ingredients=new ArrayList<>();} // gia na mh crasharei
        ArrayList<Recipe> matchingRecipes=FakeRepo.searchRecipes(ingredients);

        // AUTO EINAI GIA AMA DEN EXEI RESULTS NA KANEI HIDE TO ENA TXT LAYOUT KAI NA  EMFANIZEI TO NO RESULTS LAYOUT
        TextView txtNoRecipes=findViewById(R.id.txtNoRecipes);
        if(matchingRecipes.isEmpty()){txtNoRecipes.setVisibility(View.VISIBLE);recyclerRecipes.setVisibility(View.GONE);}
        else{txtNoRecipes.setVisibility(View.GONE);recyclerRecipes.setVisibility(View.VISIBLE);}

        // to adapter ginetai triggered otan kanei click ena recipe
        adapter=new TheAdapter(matchingRecipes,recipe->{
            Intent intent=new Intent(RecipeListActivity.this,RecipeDetailsActivity.class);
            intent.putExtra("recipe",recipe); // stelnei to dialegmeno recipe sto RecipeDetailsActivity
            startActivity(intent);
        });

        recyclerRecipes.setLayoutManager(new LinearLayoutManager(this));
        recyclerRecipes.setAdapter(adapter);
    }
}