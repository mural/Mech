package com.mech;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Agustin on 15/7/2017.
 */

public class ProductsListItemViewHolder extends ViewHolder<Product> implements Subscriber {

    private EventManager eventManager = new EventManager();

    private Product mProduct;
    private TextView mNameLabel;

    public ProductsListItemViewHolder(View view, CustomListAdapter adapter) {
        super(view, adapter);
        eventManager.register(this);

        mNameLabel = (TextView) view.findViewById(R.id.item_name);
    }

    @Override
    public void showItem(Product product) {
        mProduct = product;
        mNameLabel.setText(product.getName());
    }

    @Override
    public Product getItem() {
        return mProduct;
    }

    //public void onEventMainThread(ProductSelectedEvent event) {
    public void onEvent(ProductSelectedEvent event) {
        //AviOnLogger.i(TAG, "UpdateCredentialsEvent received, updating menus...");
        if (event.getProduct().getName().equals(mProduct.getName())) {
            Intent intent = new Intent(event.getActivity(), ProductDetailsActivity_.class);
            ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation(event.getActivity(), mNameLabel, ViewCompat.getTransitionName(mNameLabel));
            event.getActivity().startActivity(intent, options.toBundle());
        }
    }
}
