package com.mech;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.google.common.collect.Lists;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;

/**
 * Created by Agustin on 15/7/2017.
 */

@EActivity(R.layout.activity_products_list)
public class ProductsListActivity extends BaseActivity {

    private static final String TAG = ProductsListActivity.class.getSimpleName();

    @ViewById(R.id.list_view)
    protected RecyclerView recyclerView;
    @ViewById(R.id.toolbar)
    protected Toolbar toolbar;

    private List<Product> productList;
    protected ProductsListAdapter productsListAdapter;

    private DividerItemDecoration dividerItemDecoration;
    protected LinearLayoutManagerWithSmoothScroller linearLayoutManagerWithSmoothScroller;

    @AfterInject
    protected void afterInject() {
        populateAdapter();
    }

    protected void populateAdapter() {
        productList = Lists.newArrayList();
        Product product1 = new Product();
        product1.setName("Placa Melamina 13''");
        productList.add(product1);

        Product product2 = new Product();
        product2.setName("Placa Melamina 15''");
        productList.add(product2);

        Product product3 = new Product();
        product3.setName("Placa Melamina 18''");
        productList.add(product3);

        productsListAdapter = new ProductsListAdapter(productList);
        productsListAdapter.initializeListeners(new FlexibleAdapter.OnItemClickListener() {
            @Override
            public boolean onItemClick(int position) {
//                ProductDetailsActivity_.intent(getActivity()).start();
                eventManager.post(new ProductSelectedEvent(getActivity(), productsListAdapter.getModelItem(position).get()));
                return false;
            }
        });
    }

    @AfterViews
    protected void afterViews() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView.setAdapter(productsListAdapter);
        recyclerView.setHasFixedSize(true);
        linearLayoutManagerWithSmoothScroller = new LinearLayoutManagerWithSmoothScroller(this);
        dividerItemDecoration = new DividerItemDecoration(getResources().getDrawable(R.drawable.divider_list));
        recyclerView.setLayoutManager(linearLayoutManagerWithSmoothScroller);
        recyclerView.addItemDecoration(dividerItemDecoration);

        setupView();
    }

    private void setupView() {
        refreshList();
    }

    @UiThread
    protected void refreshList() {
        productsListAdapter.setItems(productList);
        productsListAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
