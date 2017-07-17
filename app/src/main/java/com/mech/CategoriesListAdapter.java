package com.mech;

import java.util.Collection;
import java.util.List;

/**
 * Created by Agustin on 15/7/2017.
 */

public class CategoriesListAdapter extends CustomListAdapter<CategoriesListAdapterItem, Category> {

    public CategoriesListAdapter(Collection<Category> categories) {
        super(categories);
    }

    public CategoriesListAdapter(List<Category> categories) {
        super(categories);
    }

    public CategoriesListAdapterItem createAdapterItem(Category category) {
        return new CategoriesListAdapterItem(category, this);
    }
}
