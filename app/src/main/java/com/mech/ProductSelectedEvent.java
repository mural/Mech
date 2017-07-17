package com.mech;

import android.app.Activity;

/**
 * Created by Agustin on 16/7/2017.
 */

public final class ProductSelectedEvent implements Event {

    private Activity activity;
    private Product product;

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
}

