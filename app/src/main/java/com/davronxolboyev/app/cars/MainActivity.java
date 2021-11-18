package com.davronxolboyev.app.cars;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.davronxolboyev.app.cars.model.CarCompany;
import com.davronxolboyev.app.cars.model.CarModels;
import com.davronxolboyev.app.cars.model.adapter.CarCompanyAdapter;
import com.davronxolboyev.app.cars.model.adapter.CarModelsAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CarCompanyAdapter adapter;

    public static List<CarModels> audi;
    public static List<CarModels> ferrari;
    public static List<CarModels> bmw;
    public static List<CarModels> lamborghini;
    public static List<CarModels> chevrolet;
    public static List<CarModels> lada;
    public static List<CarModels> wolksvagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        audi = new ArrayList<>();
        audi.add(new CarModels(1, 1, "Audi A5", "$54,250", R.drawable.audi_a5, getResources().getString(R.string.audi_a5)));
        audi.add(new CarModels(1, 2, "LeMans", "$150,000", R.drawable.audi_le_mans_quattro, getResources().getString(R.string.audi_lemans_quatro)));
        audi.add(new CarModels(1, 3, "Quatro", "$39,100", R.drawable.audi_quattro_concept, getResources().getString(R.string.audi_quatro)));
        audi.add(new CarModels(1, 4, "R8 v12", "$15000", R.drawable.audi_r8_v12, getResources().getString(R.string.audi_r8)));
        audi.add(new CarModels(1, 5, "Audi RSQ", "$114,500", R.drawable.audi_rsq, getResources().getString(R.string.audi_rsq)));

        ferrari = new ArrayList<>();
        ferrari.add(new CarModels(3, 1, "Superfast", "$316,300", R.drawable.ferrari_superfast, getResources().getString(R.string.ferrari_superfast)));
        ferrari.add(new CarModels(3, 2, "Ferrari F8", "$280,000", R.drawable.ferrari_f8, getResources().getString(R.string.ferrari_f8)));
        ferrari.add(new CarModels(3, 3, "Monza SP1", "$1.8M", R.drawable.ferrari_monza_sp1, getResources().getString(R.string.ferrari_monza)));
        ferrari.add(new CarModels(3, 4, "Portofino", "$215,000", R.drawable.ferrari_portofino, getResources().getString(R.string.ferrari_portofino)));
        ferrari.add(new CarModels(3, 5, "SF9 Stradale", "$625,000", R.drawable.ferrari_sf9_stradale, getResources().getString(R.string.ferrari_sf9)));

        bmw = new ArrayList<>();
        bmw.add(new CarModels(2, 1, "Gran Coute", "$35,700", R.drawable.bmw_grancoupe, getResources().getString(R.string.bmw_gran)));
        bmw.add(new CarModels(2, 2, "BMW G22", "$45,600", R.drawable.bmw_g22, getResources().getString(R.string.bmw_g22)));
        bmw.add(new CarModels(2, 3, "BMW F12", "$46,535.", R.drawable.bmw_f12, getResources().getString(R.string.bmw_f12)));
        bmw.add(new CarModels(2, 4, "BMW G15", "$15000", R.drawable.bmw_g14, getResources().getString(R.string.bmw_g14)));
        bmw.add(new CarModels(2, 5, "BMW i3", "$44,450", R.drawable.bmw_i3, getResources().getString(R.string.bmw_i3)));

        lamborghini = new ArrayList<>();
        lamborghini.add(new CarModels(5, 1, "Avendator", "$393,695", R.drawable.lamb_avendator, getResources().getString(R.string.lamb_avendator)));
        lamborghini.add(new CarModels(5, 2, "Diablo", "$194,085", R.drawable.lamb_diablo, getResources().getString(R.string.lamb_diablo)));
        lamborghini.add(new CarModels(5, 3, "Gallardo", "$151,429", R.drawable.lamb_gallardo, getResources().getString(R.string.lamb_gallardo)));
        lamborghini.add(new CarModels(5, 4, "Huracan", "$331,469", R.drawable.lamb_huracan, getResources().getString(R.string.lamb_huracan)));
        lamborghini.add(new CarModels(5, 5, "Urus", "$218,009", R.drawable.lamb_urus, getResources().getString(R.string.lamb_urus)));

        chevrolet = new ArrayList<>();
        chevrolet.add(new CarModels(4, 1, "Camaro", "$25,000", R.drawable.chev_camaro, getResources().getString(R.string.chev_camaro)));
        chevrolet.add(new CarModels(4, 2, "Corvette", "$60,900", R.drawable.chev_corvette, getResources().getString(R.string.chev_corvette)));
        chevrolet.add(new CarModels(4, 3, "Equinox", "$25,800", R.drawable.chev_equinox, getResources().getString(R.string.chev_equinox)));
        chevrolet.add(new CarModels(4, 4, "Menlo EV", "$23,000", R.drawable.chev_menlo_ev, getResources().getString(R.string.chev_menlo_ev)));
        chevrolet.add(new CarModels(4, 5, "Spark", "$15,500", R.drawable.chev_spark, getResources().getString(R.string.chev_spark)));

        lada = new ArrayList<>();
        lada.add(new CarModels(7, 1, "Granta", "$7107,04", R.drawable.lada_granta, getResources().getString(R.string.lada_granta)));
        lada.add(new CarModels(7, 2, "Largus", "$9437,98", R.drawable.lada_largus, getResources().getString(R.string.lada_largus)));
        lada.add(new CarModels(7, 3, "NIVA", "$4,730", R.drawable.lada_niva, getResources().getString(R.string.lada_niva)));
        lada.add(new CarModels(7, 4, "Vesta", "$15296,31", R.drawable.lada_vesta, getResources().getString(R.string.lada_vesta)));
        lada.add(new CarModels(7, 5, "Xray", "$15389,64", R.drawable.lada_xray, getResources().getString(R.string.lada_xray)));

        wolksvagen = new ArrayList<>();
        wolksvagen.add(new CarModels(6, 1, "Atlas", "$33,475", R.drawable.wolk_atlas, getResources().getString(R.string.wolk_atlas)));
        wolksvagen.add(new CarModels(6, 2, "Golf Sportsfan", "$11 000", R.drawable.wolk_golf, getResources().getString(R.string.wolk_golf)));
        wolksvagen.add(new CarModels(6, 3, "ID.6", "$37,445", R.drawable.wolk_id6, getResources().getString(R.string.wolk_id6)));
        wolksvagen.add(new CarModels(6, 4, "Passat", "$27,295", R.drawable.wolk_passat, getResources().getString(R.string.wolk_passat)));
        wolksvagen.add(new CarModels(6, 5, "Talagon", "$79,254", R.drawable.wolk_talagon, getResources().getString(R.string.wolk_talagon)));


        List<CarCompany> companies = new ArrayList<>();
        companies.add(new CarCompany(R.drawable.logo_audi, "Audi", new CarModelsAdapter(this, audi)));
        companies.add(new CarCompany(R.drawable.logo_bmw, "BMW", new CarModelsAdapter(this, bmw)));
        companies.add(new CarCompany(R.drawable.logo_ferrari, "Ferrari", new CarModelsAdapter(this, ferrari)));
        companies.add(new CarCompany(R.drawable.logo_chevrolet, "Chevrolet", new CarModelsAdapter(this, chevrolet)));
        companies.add(new CarCompany(R.drawable.logo_lamborghini, "Lamborghini", new CarModelsAdapter(this, lamborghini)));
        companies.add(new CarCompany(R.drawable.logo_volkswagen, "Wolksvagen", new CarModelsAdapter(this, wolksvagen)));
        companies.add(new CarCompany(R.drawable.logo_lada, "Lada", new CarModelsAdapter(this, lada)));
        recyclerView = findViewById(R.id.mainRecycler);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        adapter = new CarCompanyAdapter(this, companies);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_baseline_directions_car_24)
                .setTitle("Attention!")
                .setMessage("Do you want to exit the app?")
                .setPositiveButton("NO", (dialog, which) -> dialog.cancel())
                .setNegativeButton("YES", ((dialog, which) -> super.onBackPressed()));
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}