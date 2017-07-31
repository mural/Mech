package com.mech;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_product_details)
public class ProductDetailsActivity extends BaseActivity {


    @Extra
    protected int productCode;

    @ViewById(R.id.app_bar)
    protected AppBarLayout appBarLayout;
    @ViewById(R.id.toolbar)
    protected Toolbar toolbar;
    @ViewById(R.id.fab)
    protected FloatingActionButton fab;
    @ViewById(R.id.product_name)
    protected TextView productName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    protected void afterViews() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Agregar y Ver Mi Pedido", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        String name = "Placa Melamina 13''";
        if (productCode == 1) {
            appBarLayout.setBackground(getResources().getDrawable(R.drawable.melamina1));
            name = "Placa Melamina 13''";
        } else if (productCode == 2) {
            appBarLayout.setBackground(getResources().getDrawable(R.drawable.melamina2));
            name = "Placa Melamina 15''";
        } else if (productCode == 3) {
            appBarLayout.setBackground(getResources().getDrawable(R.drawable.melamina3));
            name = "Placa Melamina 18''";
        }
        productName.setText(name);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
