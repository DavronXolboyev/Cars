package com.davronxolboyev.app.cars;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.davronxolboyev.app.cars.game.LogoGame;
import com.davronxolboyev.app.cars.model.CarModels;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class InfoActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView tv;
    TextView carName;
    TextView carCost;
    MaterialToolbar toolbar;
    DrawerLayout drawerLayout;
    ImageView carImage;
    int id;
    TextView headerTitle;
    View headerView;
    ImageView headerImage;
    NavigationView nav_view;
    List<CarModels> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Bundle bundle = getIntent().getExtras();

        // kirgandagi ma`lumotlar
        tv = findViewById(R.id.infotv);
        tv.setText(bundle.get("description").toString());
        carName = findViewById(R.id.infoCar);
        carCost = findViewById(R.id.costCar);

        //navigationdraver bilan bogliq barcha narsa
        nav_view = findViewById(R.id.nav_view);
        id = bundle.getInt("idCompany");
        //headerdagi rasm va so'zni o'zgartirish
        changeHeader(id, bundle.getString("carName"), bundle.getString("carCost"));
        //menu nomlarini o'zgartirish
        changeMenuItem(id);

        nav_view.setNavigationItemSelectedListener(this);
        // Kirgandagi mashina rasmi
        carImage = findViewById(R.id.infoImage);
        carImage.setImageResource(bundle.getInt("image"));


        //toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void changeMenuItem(int id) {
        Menu menu = nav_view.getMenu();
        MenuItem item1 = menu.findItem(R.id.item1);
        MenuItem item2 = menu.findItem(R.id.item2);
        MenuItem item3 = menu.findItem(R.id.item3);
        MenuItem item4 = menu.findItem(R.id.item4);
        MenuItem item5 = menu.findItem(R.id.item5);
        switch (id) {
            case 1: {
                item1.setTitle("Audi A5");
                item2.setTitle("LeMans Quatro");
                item3.setTitle("Quatro");
                item4.setTitle("R8 v12");
                item5.setTitle("Audi RSQ");
                models = MainActivity.audi;
                break;
            }
            case 2: {
                item1.setTitle("Gran Coute");
                item2.setTitle("BMW G22");
                item3.setTitle("BMW F12");
                item4.setTitle("BMW G15");
                item5.setTitle("BMW i3");
                models = MainActivity.bmw;
                break;
            }
            case 3: {
                item1.setTitle("Superfast");
                item2.setTitle("Ferrari F8");
                item3.setTitle("Monza SP1");
                item4.setTitle("Portofino");
                item5.setTitle("SF9 Stradale");
                models = MainActivity.ferrari;
                break;
            }
            case 4: {
                item1.setTitle("Camaro");
                item2.setTitle("Corvette");
                item3.setTitle("Equinox");
                item4.setTitle("Menlo EV");
                item5.setTitle("Spark");
                models = MainActivity.chevrolet;
                break;
            }
            case 5: {
                item1.setTitle("Avendator");
                item2.setTitle("Diablo");
                item3.setTitle("Gallardo");
                item4.setTitle("Huracan");
                item5.setTitle("Urus");
                models = MainActivity.lamborghini;
                break;
            }
            case 6: {
                item1.setTitle("Atlas");
                item2.setTitle("Golf Sportsfan");
                item3.setTitle("ID.6");
                item4.setTitle("Passat");
                item5.setTitle("Talagon");
                models = MainActivity.wolksvagen;
                break;
            }
            case 7: {
                item1.setTitle("Granta");
                item2.setTitle("Largus");
                item3.setTitle("NIVA");
                item4.setTitle("Vesta");
                item5.setTitle("Xray");
                models = MainActivity.lada;
                break;
            }
        }
    }

    private void changeHeader(int id, String carName, String costCar) {
        headerView = nav_view.getHeaderView(0);
        headerTitle = headerView.findViewById(R.id.tv_header);
        headerTitle.setText(carName);
        this.carName.setText(carName);
        this.carCost.setText(costCar);
        headerImage = headerView.findViewById(R.id.image_header);
        switch (id) {
            case 1:
                headerImage.setImageResource(R.drawable.logo_audi);
                break;
            case 2:
                headerImage.setImageResource(R.drawable.logo_bmw);
                break;
            case 3:
                headerImage.setImageResource(R.drawable.logo_ferrari);
                break;
            case 4:
                headerImage.setImageResource(R.drawable.logo_chevrolet);
                break;
            case 5:
                headerImage.setImageResource(R.drawable.logo_lamborghini);
                break;
            case 6:
                headerImage.setImageResource(R.drawable.logo_volkswagen);
                break;
            case 7:
                headerImage.setImageResource(R.drawable.logo_lada);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            finish();
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1: {
                setTexts(0);
                changeHeader(id, models.get(0).getCarName(), models.get(0).getCarCost());
                break;
            }
            case R.id.item2: {
                setTexts(1);
                changeHeader(id, models.get(1).getCarName(), models.get(1).getCarCost());
                break;
            }
            case R.id.item3: {
                setTexts(2);
                changeHeader(id, models.get(2).getCarName(), models.get(2).getCarCost());
                break;
            }
            case R.id.item4: {
                setTexts(3);
                changeHeader(id, models.get(3).getCarName(), models.get(3).getCarCost());
                break;
            }
            case R.id.item5: {
                setTexts(4);
                changeHeader(id, models.get(4).getCarName(), models.get(4).getCarCost());
                break;
            }

            case R.id.audiMenu: {
                changeMenuItem(1);
                changeHeader(1, models.get(0).getCarName(), models.get(0).getCarCost());
                setTexts(0);
                break;
            }
            case R.id.bmwMenu: {
                changeMenuItem(2);
                changeHeader(2, models.get(0).getCarName(), models.get(0).getCarCost());
                setTexts(0);
                break;
            }
            case R.id.ferrariMenu: {
                changeMenuItem(3);
                changeHeader(3, models.get(0).getCarName(), models.get(0).getCarCost());
                setTexts(0);
                break;
            }
            case R.id.chevroletMenu: {
                changeMenuItem(4);
                changeHeader(4, models.get(0).getCarName(), models.get(0).getCarCost());
                setTexts(0);
                break;
            }
            case R.id.lamborghiniMenu: {
                changeMenuItem(5);
                changeHeader(5, models.get(0).getCarName(), models.get(0).getCarCost());
                setTexts(0);
                break;
            }
            case R.id.wolksvagenMenu: {
                changeMenuItem(6);
                changeHeader(6, models.get(0).getCarName(), models.get(0).getCarCost());
                setTexts(0);
                break;
            }
            case R.id.ladaMenu: {
                changeMenuItem(7);
                changeHeader(7, models.get(0).getCarName(), models.get(0).getCarCost());
                setTexts(0);
                break;
            }

        }
        onBackPressed();
        return true;
    }

    public void setTexts(int i) {
        tv.setText(models.get(i).getDescription());
        carImage.setImageResource(models.get(i).getCarImage());
    }


    @SuppressLint("QueryPermissionsNeeded")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.shareM) {
            String message = "Assalomu alaykum!\nMen sizga GITA Dasturchilar Akademiyasi tomonidan o'tkazilgan marafonda tayyorlangan ilovani taqdim etmoqchiman!\nShu link ustiga bosib ilovani yuklab olishiz mumkin\nhttps://t.me/davron_xolboyev_apps/34";
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, message);
            intent.setType("text/plain");
            if (intent.resolveActivity(getPackageManager()) != null) startActivity(intent);
        } else {
            Intent game = new Intent(this, LogoGame.class);
            startActivity(game);
        }
        return super.onOptionsItemSelected(item);
    }
}