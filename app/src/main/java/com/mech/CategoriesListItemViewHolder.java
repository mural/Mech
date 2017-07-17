package com.mech;

import android.view.View;
import android.widget.TextView;

/**
 * Created by Agustin on 15/7/2017.
 */

public class CategoriesListItemViewHolder extends ViewHolder<Category> {

    private Category mCategory;
    private TextView mNameLabel;

    public CategoriesListItemViewHolder(View view, CustomListAdapter adapter) {
        super(view, adapter);

        mNameLabel = (TextView) view.findViewById(R.id.item_name);
    }

    @Override
    public void showItem(Category category) {
        mNameLabel.setText(category.getName());
    }

    @Override
    public Category getItem() {
        return mCategory;
    }
}
