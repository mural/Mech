package com.mech;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final int INFO = 0;
    private static final int PRODUCTS = 1;

    private int activeFragment = INFO;
    protected InfoFragment infoFragment;
    protected CategoriesListFragment productsFragment;

    @ViewById(R.id.toolbar_title)
    protected TextView toolbarTitle;
    @ViewById(R.id.toolbar)
    protected Toolbar toolbar;
    @ViewById(R.id.toolbar_layout)
    protected CollapsingToolbarLayout collapsingToolbarLayout;
    @ViewById(R.id.app_bar)
    protected AppBarLayout appBarLayout;
    @ViewById(R.id.fab)
    protected FloatingActionButton fab;
    @ViewById(R.id.drawer_layout)
    protected DrawerLayout drawer;
    @ViewById(R.id.nav_view)
    protected NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    protected void afterViews() {
        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Ir a contacto...", Snackbar.LENGTH_LONG)
                        .setAction("Email", null).show();
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        initListFragment();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_info) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment, infoFragment).commit();
            appBarLayout.setExpanded(true);
            toolbarTitle.setText(R.string.promotor);
        } else if (id == R.id.nav_products) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment, productsFragment).commit();
            appBarLayout.setExpanded(false);
            toolbarTitle.setText(R.string.title_categories_fragment);
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initListFragment() {
        infoFragment = InfoFragment_.builder().build();
        productsFragment = CategoriesListFragment_.builder().build();

        getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment, infoFragment).commit();
        appBarLayout.setExpanded(true);
        toolbarTitle.setText(R.string.promotor);
    }
}
