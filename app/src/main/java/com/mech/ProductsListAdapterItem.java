package com.mech;

import android.view.View;

/**
 * Created by Agustin on 15/7/2017.
 */

public class ProductsListAdapterItem extends AdapterItem<Product, ProductsListItemViewHolder> {

    private ProductsListAdapter adapter;

    public ProductsListAdapterItem(Product product, ProductsListAdapter adapter) {
        super(product);
        this.adapter = adapter;
    }

    @Override
    protected ProductsListItemViewHolder createViewHolder(View view, CustomListAdapter adapter) {
        return new ProductsListItemViewHolder(view, adapter);
    }

    @Override
    public int getItemLayout() {
        return R.layout.products_list_item;
    }
}