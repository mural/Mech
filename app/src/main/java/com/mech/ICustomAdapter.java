package com.mech;

import android.support.v7.widget.RecyclerView;

import eu.davidea.flexibleadapter.items.IHeader;
import eu.davidea.flexibleadapter.items.ISectionable;

/**
 * Created by Agustin on 15/7/2017.
 */

public interface ICustomAdapter<VH extends RecyclerView.ViewHolder, HEADER extends IHeader> extends ISectionable<VH, HEADER> {

    int getItemLayout();

}