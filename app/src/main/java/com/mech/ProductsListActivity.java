package com.mech;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.google.common.collect.Lists;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.List;

/**
 * Created by Agustin on 15/7/2017.
 */

@EActivity(R.layout.activity_products_list)
public class ProductsListActivity extends BaseActivity implements Subscriber {

    private static final String TAG = ProductsListActivity.class.getSimpleName();

    @ViewById(R.id.list_view)
    protected RecyclerView recyclerView;
    @ViewById(R.id.toolbar)
    protected Toolbar toolbar;

    private List<Product> productList;
    protected ProductsListAdapter productsListAdapter;

    private DividerItemDecoration dividerItemDecoration;
    protected LinearLayoutManagerWithSmoothScroller linearLayoutManagerWithSmoothScroller;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eventManager.register(this);
    }

    @Override
    protected void onDestroy() {
        eventManager.unregister(this);
        super.onDestroy();
    }

    @AfterInject
    protected void afterInject() {
        populateAdapter();
    }

    protected void populateAdapter() {
        productList = Lists.newArrayList();
        Product product1 = new Product();
        product1.setProductCode(1);
        product1.setName("Placa Melamina 13''");
        product1.setPictureId(R.drawable.melamina1);
        productList.add(product1);

        Product product2 = new Product();
        product2.setProductCode(2);
        product2.setName("Placa Melamina 15''");
        product2.setPictureId(R.drawable.melamina2);
        productList.add(product2);

        Product product3 = new Product();
        product3.setProductCode(3);
        product3.setName("Placa Melamina 18''");
        product3.setPictureId(R.drawable.melamina3);
        productList.add(product3);

        productsListAdapter = new ProductsListAdapter(productList);
//        productsListAdapter.initializeListeners(new FlexibleAdapter.OnItemClickListener() {
//            @Override
//            public boolean onItemClick(int position) {
////                ProductDetailsActivity_.intent(getActivity()).start();
//                eventManager.post(new ProductSelectedEvent(getActivity(), productsListAdapter.getModelItem(position).get()));
//                return false;
//            }
//        });
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

    //public void onEventMainThread(ProductSelectedEvent event) {
    public void onEvent(ProductSelectedEvent event) {
        Log.i(TAG, "ProductSelectedEvent received, updating menus...");
//        Intent intent = new Intent(this, ProductDetailsActivity_.class);
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, event.getView(), ViewCompat.getTransitionName(event.getView()));
//        Bundle bundle = options.toBundle();
//        bundle.putInt("productCodeExtra", event.getProduct().getProductCode());
//        startActivity(intent, bundle);

        ProductDetailsActivity_.intent(this).productCode(event.getProduct().getProductCode()).withOptions(options.toBundle()).start();
    }
}
