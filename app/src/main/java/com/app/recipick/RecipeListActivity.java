package com.app.recipick;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.app.recipick.adapters.TheAdapter;
import com.app.recipick.data.AppDatabase;
import com.app.recipick.data.Recipe.Recipe;
import androidx.sqlite.db.SupportSQLiteDatabase;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

public class RecipeListActivity extends AppCompatActivity{
    private static final String TAG="RecipeListActivity";
    private RecyclerView recyclerRecipes;private TheAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        try{
            setContentView(R.layout.activity_recipe_list);
            AppDatabase db=AppDatabase.getInstance(this);
            if(db==null){return;}
            recyclerRecipes=findViewById(R.id.recyclerRecipes);
            TextView txtNoRecipes=findViewById(R.id.txtNoRecipes);
            if(recyclerRecipes==null||txtNoRecipes==null){return;}
            recyclerRecipes.setLayoutManager(new LinearLayoutManager(this));

            new Thread(()->{
                try{
                    SupportSQLiteDatabase sdb=db.getOpenHelper().getReadableDatabase();
                    List<Recipe> matchingRecipes=new ArrayList<>();
                    String query="SELECT Recipe.* FROM Recipe " +
                                  "WHERE NOT EXISTS ( " +
                                  "    SELECT 1 " +
                                  "    FROM Recipe_Ingredients ri " +
                                  "    JOIN Ingredient i ON i.id=ri.ingredientId " +
                                  "    WHERE ri.recipeId=Recipe.id " +
                                  "    AND i.selected=0 " +
                                  ")";
                    
                    try (Cursor cursor=sdb.query(query,new Object[0])){
                        while (cursor.moveToNext()){
                            Recipe r=new Recipe();
                            r.id=cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                            r.name=cursor.getString(cursor.getColumnIndexOrThrow("name"));
                            r.desc=cursor.getString(cursor.getColumnIndexOrThrow("desc"));
                            r.instr=cursor.getString(cursor.getColumnIndexOrThrow("instr"));
                            matchingRecipes.add(r);
                        }
                    }
                    runOnUiThread(() ->{
                        if (matchingRecipes.isEmpty()){
                            txtNoRecipes.setVisibility(View.VISIBLE);
                            recyclerRecipes.setVisibility(View.GONE);
                        } else{
                            txtNoRecipes.setVisibility(View.GONE);
                            recyclerRecipes.setVisibility(View.VISIBLE);
                            adapter=new TheAdapter(matchingRecipes,recipe->{
                                Intent intent=new Intent(RecipeListActivity.this,RecipeDetailsActivity.class);
                                intent.putExtra("recipe",recipe);
                                startActivity(intent);
                            });
                            recyclerRecipes.setAdapter(adapter);
                        }
                    });
                }catch(Throwable t){}
            }).start();
        }catch (Exception e){}
    }
}
