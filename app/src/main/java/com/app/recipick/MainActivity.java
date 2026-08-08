package com.app.recipick;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;




public class MainActivity extends AppCompatActivity{
    private CheckBox cbEgg; private CheckBox cbBread; private CheckBox cbButter; private CheckBox cbPasta;
    private CheckBox cbTomato; private CheckBox cbCheese; private CheckBox cbChicken; private CheckBox cbRice;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        btnSearch.setOnClickListener(view->{
            ArrayList<String> selectedIngredients=new ArrayList<>();
            if (cbEgg.isChecked()) selectedIngredients.add("Egg");
            if (cbBread.isChecked()) selectedIngredients.add("Bread");
            if (cbButter.isChecked()) selectedIngredients.add("Butter");
            if (cbPasta.isChecked()) selectedIngredients.add("Pasta");
            if (cbTomato.isChecked()) selectedIngredients.add("Tomato");
            if (cbCheese.isChecked()) selectedIngredients.add("Cheese");
            if (cbChicken.isChecked()) selectedIngredients.add("Chicken");
            if (cbRice.isChecked()) selectedIngredients.add("Rice");

            Intent intent=new Intent(MainActivity.this,RecipeListActivity.class); // auto leei oti thelei na anoiksei to RecipeListActivity
            intent.putStringArrayListExtra("ingredients",selectedIngredients); // auto stelnei sto epomeno activity ta dedomena (ingredients dld)
            startActivity(intent); // auto anoigei ontws to activity
        });
    }

    private void initializeViews(){
        cbEgg= findViewById(R.id.cbEgg);
        cbBread=findViewById(R.id.cbBread);
        cbButter=findViewById(R.id.cbButter);
        cbPasta=findViewById(R.id.cbPasta);
        cbTomato=findViewById(R.id.cbTomato);
        cbCheese=findViewById(R.id.cbCheese);
        cbChicken=findViewById(R.id.cbChicken);
        cbRice=findViewById(R.id.cbRice);
        btnSearch=findViewById(R.id.btnSearch);
    }

}