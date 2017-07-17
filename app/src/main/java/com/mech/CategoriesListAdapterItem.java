package com.mech;

import android.view.View;

/**
 * Created by Agustin on 15/7/2017.
 */

public class CategoriesListAdapterItem extends AdapterItem<Category, CategoriesListItemViewHolder> {

    private CategoriesListAdapter adapter;

    public CategoriesListAdapterItem(Category category, CategoriesListAdapter adapter) {
        super(category);
        this.adapter = adapter;
    }

    @Override
    protected CategoriesListItemViewHolder createViewHolder(View view, CustomListAdapter adapter) {
        return new CategoriesListItemViewHolder(view, adapter);
    }

    @Override
    public int getItemLayout() {
        return R.layout.categories_list_item;
    }
}