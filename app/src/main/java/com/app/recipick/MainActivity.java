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

import com.app.recipick.data.AppDatabase;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity{
    private CheckBox cbEgg;private CheckBox cbBread;private CheckBox cbButter;private CheckBox cbPasta;
    private CheckBox cbTomato;private CheckBox cbCheese;private CheckBox cbChicken;
    private CheckBox cbRice;private CheckBox cbCucumber;private CheckBox cbMilk;private CheckBox cbOnion;
    private CheckBox cbSugar;private CheckBox cbOliveOil;private CheckBox cbPotato;private CheckBox cbAvocado;
    private CheckBox cbLemon;private CheckBox cbApple;private CheckBox cbBanana;private CheckBox cbOrange;
    private CheckBox cbStrawberry;private CheckBox cbParmesan;private CheckBox cbYogurt;private CheckBox cbBacon;
    private CheckBox cbCannedTuna;private CheckBox cbShrimp;private CheckBox cbCinnamon;private CheckBox cbOregano;
    private CheckBox cbHoney;private CheckBox cbSalt;private CheckBox cbFlour;private CheckBox cbBakingPowder;
    private CheckBox cbNoodles;private CheckBox cbTortillas;private CheckBox cbCrackers;private CheckBox cbMayonnaise;
    private CheckBox cbVinegar;private CheckBox cbKetchup;private CheckBox cbMustard;private CheckBox cbOlives;
    private CheckBox cbPeanutButter;private CheckBox cbGarlic;private CheckBox cbSoySauce;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        AppDatabase db=((ReciPickApplication) getApplication()).getDatabase();
        btnSearch.setOnClickListener(view->{
            new Thread(()->{
                db.ingredientDao().updateSelection(0, cbEgg.isChecked()?1:0);
                db.ingredientDao().updateSelection(1, cbBread.isChecked()?1:0);
                db.ingredientDao().updateSelection(2, cbButter.isChecked()?1:0);
                db.ingredientDao().updateSelection(3, cbPasta.isChecked()?1:0);
                db.ingredientDao().updateSelection(4, cbTomato.isChecked()?1:0);
                db.ingredientDao().updateSelection(5, cbCheese.isChecked()?1:0);
                db.ingredientDao().updateSelection(6, cbChicken.isChecked()?1:0);
                db.ingredientDao().updateSelection(7, cbRice.isChecked()?1:0);
                db.ingredientDao().updateSelection(8, cbCucumber.isChecked()?1:0);
                db.ingredientDao().updateSelection(9, cbMilk.isChecked()?1:0);
                db.ingredientDao().updateSelection(10, cbOnion.isChecked()?1:0);
                db.ingredientDao().updateSelection(11, cbSugar.isChecked()?1:0);
                db.ingredientDao().updateSelection(12, cbOliveOil.isChecked()?1:0);
                db.ingredientDao().updateSelection(13, cbPotato.isChecked()?1:0);
                db.ingredientDao().updateSelection(14, cbAvocado.isChecked()?1:0);
                db.ingredientDao().updateSelection(15, cbLemon.isChecked()?1:0);
                db.ingredientDao().updateSelection(16, cbApple.isChecked()?1:0);
                db.ingredientDao().updateSelection(17, cbBanana.isChecked()?1:0);
                db.ingredientDao().updateSelection(18, cbOrange.isChecked()?1:0);
                db.ingredientDao().updateSelection(19, cbStrawberry.isChecked()?1:0);
                db.ingredientDao().updateSelection(20, cbParmesan.isChecked()?1:0);
                db.ingredientDao().updateSelection(21, cbYogurt.isChecked()?1:0);
                db.ingredientDao().updateSelection(22, cbBacon.isChecked()?1:0);
                db.ingredientDao().updateSelection(23, cbCannedTuna.isChecked()?1:0);
                db.ingredientDao().updateSelection(24, cbShrimp.isChecked()?1:0);
                db.ingredientDao().updateSelection(25, cbCinnamon.isChecked()?1:0);
                db.ingredientDao().updateSelection(26, cbOregano.isChecked()?1:0);
                db.ingredientDao().updateSelection(27, cbHoney.isChecked()?1:0);
                db.ingredientDao().updateSelection(28, cbSalt.isChecked()?1:0);
                db.ingredientDao().updateSelection(29, cbFlour.isChecked()?1:0);
                db.ingredientDao().updateSelection(30, cbBakingPowder.isChecked()?1:0);
                db.ingredientDao().updateSelection(31, cbNoodles.isChecked()?1:0);
                db.ingredientDao().updateSelection(32, cbTortillas.isChecked()?1:0);
                db.ingredientDao().updateSelection(33, cbCrackers.isChecked()?1:0);
                db.ingredientDao().updateSelection(34, cbMayonnaise.isChecked()?1:0);
                db.ingredientDao().updateSelection(35, cbVinegar.isChecked()?1:0);
                db.ingredientDao().updateSelection(36, cbKetchup.isChecked()?1:0);
                db.ingredientDao().updateSelection(37, cbMustard.isChecked()?1:0);
                db.ingredientDao().updateSelection(38, cbOlives.isChecked()?1:0);
                db.ingredientDao().updateSelection(39, cbPeanutButter.isChecked()?1:0);
                db.ingredientDao().updateSelection(40, cbGarlic.isChecked()?1:0);
                db.ingredientDao().updateSelection(41, cbSoySauce.isChecked()?1:0);
            }).start();

            Intent intent=new Intent(MainActivity.this,RecipeListActivity.class);
            startActivity(intent); // auto anoigei ontws to activity
        });
    }

    private void initializeViews(){
        cbEgg=findViewById(R.id.cbEgg);
        cbBread=findViewById(R.id.cbBread);
        cbButter=findViewById(R.id.cbButter);
        cbPasta=findViewById(R.id.cbPasta);
        cbTomato=findViewById(R.id.cbTomato);
        cbCheese=findViewById(R.id.cbCheese);
        cbChicken=findViewById(R.id.cbChicken);
        cbRice=findViewById(R.id.cbRice);
        cbCucumber=findViewById(R.id.cbCucumber);
        cbMilk=findViewById(R.id.cbMilk);
        cbOnion=findViewById(R.id.cbOnion);
        cbSugar=findViewById(R.id.cbSugar);
        cbOliveOil=findViewById(R.id.cbOliveOil);
        cbPotato=findViewById(R.id.cbPotato);
        cbAvocado=findViewById(R.id.cbAvocado);
        cbLemon=findViewById(R.id.cbLemon);
        cbApple=findViewById(R.id.cbApple);
        cbBanana=findViewById(R.id.cbBanana);
        cbOrange=findViewById(R.id.cbOrange);
        cbStrawberry=findViewById(R.id.cbStrawberry);
        cbParmesan=findViewById(R.id.cbParmesan);
        cbYogurt=findViewById(R.id.cbYogurt);
        cbBacon=findViewById(R.id.cbBacon);
        cbCannedTuna=findViewById(R.id.cbCannedTuna);
        cbShrimp=findViewById(R.id.cbShrimp);
        cbCinnamon=findViewById(R.id.cbCinnamon);
        cbOregano=findViewById(R.id.cbOregano);
        cbHoney=findViewById(R.id.cbHoney);
        cbSalt=findViewById(R.id.cbSalt);
        cbFlour=findViewById(R.id.cbFlour);
        cbBakingPowder=findViewById(R.id.cbBakingPowder);
        cbNoodles=findViewById(R.id.cbNoodles);
        cbTortillas=findViewById(R.id.cbTortillas);
        cbCrackers=findViewById(R.id.cbCrackers);
        cbMayonnaise=findViewById(R.id.cbMayonnaise);
        cbVinegar=findViewById(R.id.cbVinegar);
        cbKetchup=findViewById(R.id.cbKetchup);
        cbMustard=findViewById(R.id.cbMustard);
        cbOlives=findViewById(R.id.cbOlives);
        cbPeanutButter=findViewById(R.id.cbPeanutButter);
        cbGarlic=findViewById(R.id.cbGarlic);
        cbSoySauce=findViewById(R.id.cbSoySauce);
        btnSearch=findViewById(R.id.btnSearch);
    }

}