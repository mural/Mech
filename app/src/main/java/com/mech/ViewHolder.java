package com.mech;

import android.view.View;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.viewholders.FlexibleViewHolder;

/**
 * Created by Agustin on 15/7/2017.
 */

public abstract class ViewHolder<T> extends FlexibleViewHolder implements View.OnClickListener, View.OnLongClickListener {

    protected T item;

    protected ViewHolder(View itemView, FlexibleAdapter adapter) {
        super(itemView, adapter);
    }

    public abstract void showItem(T item);

    public abstract T getItem();

}
