package com.mech;

import android.app.Activity;
import android.view.View;

/**
 * Created by Agustin on 16/7/2017.
 */

public final class ProductSelectedEvent implements Event {

    private Activity activity;
    private Product product;

    private View view;

    ProductSelectedEvent(Product product, View view) {
        this.product = product;
        this.view = view;
    }

    ProductSelectedEvent(Activity activity, Product product) {
        this.activity = activity;
        this.product = product;
    }

    public Activity getActivity() {
        return this.activity;
    }

    public Product getProduct() {
        return this.product;
    }


    public View getView() {
        return this.view;
    }
}

