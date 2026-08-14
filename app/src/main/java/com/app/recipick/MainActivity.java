package com.app.recipick;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.widget.Button;
import android.widget.CheckBox;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.app.recipick.data.AppDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
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
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO); //permanent light mode
        setContentView(R.layout.activity_main);

        initializeViews();
       if(btnSearch==null){return;}

        AppDatabase db=null;
       if(getApplication() instanceof ReciPickApplication){db=((ReciPickApplication)getApplication()).getDatabase();}
       if(db==null){return;}

        final AppDatabase finalDb=db;
        btnSearch.setOnClickListener(view->{
            boolean[]states=new boolean[42];
           if(cbEgg!=null)states[0]=cbEgg.isChecked();
           if(cbBread!=null)states[1]=cbBread.isChecked();
           if(cbButter!=null)states[2]=cbButter.isChecked();
           if(cbPasta!=null)states[3]=cbPasta.isChecked();
           if(cbTomato!=null)states[4]=cbTomato.isChecked();
           if(cbCheese!=null)states[5]=cbCheese.isChecked();
           if(cbChicken!=null)states[6]=cbChicken.isChecked();
           if(cbRice!=null)states[7]=cbRice.isChecked();
           if(cbCucumber!=null)states[8]=cbCucumber.isChecked();
           if(cbMilk!=null)states[9]=cbMilk.isChecked();
           if(cbOnion!=null)states[10]=cbOnion.isChecked();
           if(cbSugar!=null)states[11]=cbSugar.isChecked();
           if(cbOliveOil!=null)states[12]=cbOliveOil.isChecked();
           if(cbPotato!=null)states[13]=cbPotato.isChecked();
           if(cbAvocado!=null)states[14]=cbAvocado.isChecked();
           if(cbLemon!=null)states[15]=cbLemon.isChecked();
           if(cbApple!=null)states[16]=cbApple.isChecked();
           if(cbBanana!=null)states[17]=cbBanana.isChecked();
           if(cbOrange!=null)states[18]=cbOrange.isChecked();
           if(cbStrawberry!=null)states[19]=cbStrawberry.isChecked();
           if(cbParmesan!=null)states[20]=cbParmesan.isChecked();
           if(cbYogurt !=null)states[21]=cbYogurt.isChecked();
           if(cbBacon!=null)states[22]=cbBacon.isChecked();
           if(cbCannedTuna!=null)states[23]=cbCannedTuna.isChecked();
           if(cbShrimp!=null)states[24]=cbShrimp.isChecked();
           if(cbCinnamon!=null)states[25]=cbCinnamon.isChecked();
           if(cbOregano!=null)states[26]=cbOregano.isChecked();
           if(cbHoney!=null)states[27]=cbHoney.isChecked();
           if(cbSalt!=null)states[28]=cbSalt.isChecked();
           if(cbFlour!=null)states[29]=cbFlour.isChecked();
           if(cbBakingPowder!=null)states[30]=cbBakingPowder.isChecked();
           if(cbNoodles!=null)states[31]=cbNoodles.isChecked();
           if(cbTortillas!=null)states[32]=cbTortillas.isChecked();
           if(cbCrackers!=null)states[33]=cbCrackers.isChecked();
           if(cbMayonnaise!=null)states[34]=cbMayonnaise.isChecked();
           if(cbVinegar!=null)states[35]=cbVinegar.isChecked();
           if(cbKetchup!=null)states[36]=cbKetchup.isChecked();
           if(cbMustard!=null)states[37]=cbMustard.isChecked();
           if(cbOlives!=null)states[38]=cbOlives.isChecked();
           if(cbPeanutButter!=null)states[39]=cbPeanutButter.isChecked();
           if(cbGarlic!=null)states[40]=cbGarlic.isChecked();
           if(cbSoySauce!=null)states[41]=cbSoySauce.isChecked();

            new Thread(()->{
                try{
                    int selectedCount=0;
                    for(boolean s:states)if(s) selectedCount++;

                    SupportSQLiteDatabase sdb=finalDb.getOpenHelper().getWritableDatabase();
                    sdb.beginTransaction();
                    try{
                        sdb.execSQL("UPDATE Ingredient SET selected=0");
                        for (int i=0;i<states.length;i++){if(states[i]){sdb.execSQL("UPDATE Ingredient SET selected=1 WHERE id="+i);}}
                        sdb.setTransactionSuccessful();
                    }finally{sdb.endTransaction();}

                    runOnUiThread(()->{
                        Intent intent=new Intent(MainActivity.this,RecipeListActivity.class);
                        startActivity(intent);
                    });
                }catch(Exception ignored){}
            }).start();
        });
    }

    private void initializeViews(){
        try{
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
            checkViewsInitialized();
        }catch(Exception e){android.util.Log.e("MainActivity","Error in initializeViews",e);}
    }

    private void checkViewsInitialized(){
       if(cbEgg==null)android.util.Log.e("MainActivity","cbEgg is null");
       if(cbBread==null)android.util.Log.e("MainActivity","cbBread is null");
       if(cbButter==null)android.util.Log.e("MainActivity","cbButter is null");
       if(cbPasta==null)android.util.Log.e("MainActivity","cbPasta is null");
       if(cbTomato==null)android.util.Log.e("MainActivity","cbTomato is null");
       if(cbCheese==null)android.util.Log.e("MainActivity","cbCheese is null");
       if(cbChicken==null)android.util.Log.e("MainActivity","cbChicken is null");
       if(cbRice==null)android.util.Log.e("MainActivity","cbRice is null");
       if(cbCucumber==null)android.util.Log.e("MainActivity","cbCucumber is null");
       if(cbMilk==null)android.util.Log.e("MainActivity","cbMilk is null");
       if(cbOnion==null)android.util.Log.e("MainActivity","cbOnion is null");
       if(cbSugar==null)android.util.Log.e("MainActivity","cbSugar is null");
       if(cbOliveOil==null)android.util.Log.e("MainActivity","cbOliveOil is null");
       if(cbPotato==null)android.util.Log.e("MainActivity","cbPotato is null");
       if(cbAvocado==null)android.util.Log.e("MainActivity","cbAvocado is null");
       if(cbLemon==null)android.util.Log.e("MainActivity","cbLemon is null");
       if(cbApple==null)android.util.Log.e("MainActivity","cbApple is null");
       if(cbBanana==null)android.util.Log.e("MainActivity","cbBanana is null");
       if(cbOrange==null)android.util.Log.e("MainActivity","cbOrange is null");
       if(cbStrawberry==null)android.util.Log.e("MainActivity","cbStrawberry is null");
       if(cbParmesan==null)android.util.Log.e("MainActivity","cbParmesan is null");
       if(cbYogurt==null)android.util.Log.e("MainActivity","cbYogurt is null");
       if(cbBacon==null)android.util.Log.e("MainActivity","cbBacon is null");
       if(cbCannedTuna==null)android.util.Log.e("MainActivity","cbCannedTuna is null");
       if(cbShrimp==null)android.util.Log.e("MainActivity","cbShrimp is null");
       if(cbCinnamon==null)android.util.Log.e("MainActivity","cbCinnamon is null");
       if(cbOregano==null)android.util.Log.e("MainActivity","cbOregano is null");
       if(cbHoney==null)android.util.Log.e("MainActivity","cbHoney is null");
       if(cbSalt==null)android.util.Log.e("MainActivity","cbSalt is null");
       if(cbFlour==null)android.util.Log.e("MainActivity","cbFlour is null");
       if(cbBakingPowder==null)android.util.Log.e("MainActivity","cbBakingPowder is null");
       if(cbNoodles==null)android.util.Log.e("MainActivity","cbNoodles is null");
       if(cbTortillas==null)android.util.Log.e("MainActivity","cbTortillas is null");
       if(cbCrackers==null)android.util.Log.e("MainActivity","cbCrackers is null");
       if(cbMayonnaise==null)android.util.Log.e("MainActivity","cbMayonnaise is null");
       if(cbVinegar==null)android.util.Log.e("MainActivity","cbVinegar is null");
       if(cbKetchup==null)android.util.Log.e("MainActivity","cbKetchup is null");
       if(cbMustard==null)android.util.Log.e("MainActivity","cbMustard is null");
       if(cbOlives==null)android.util.Log.e("MainActivity","cbOlives is null");
       if(cbPeanutButter==null)android.util.Log.e("MainActivity","cbPeanutButter is null");
       if(cbGarlic==null)android.util.Log.e("MainActivity","cbGarlic is null");
       if(cbSoySauce==null)android.util.Log.e("MainActivity","cbSoySauce is null");
       if(btnSearch==null)android.util.Log.e("MainActivity","btnSearch is null");
    }

}