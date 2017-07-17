package com.mech;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;
import eu.davidea.flexibleadapter.items.IHeader;

/**
 * Created by Agustin on 15/7/2017.
 */

public abstract class AbstractAdapterItem<VH extends RecyclerView.ViewHolder, HEADER extends IHeader> extends AbstractFlexibleItem<VH> implements ICustomAdapter<VH, HEADER> {

    protected abstract void bindViewHolder(VH holder);

    protected abstract VH createViewHolder(CustomListAdapter adapter, LayoutInflater inflater, ViewGroup parent);

    @Override
    public VH createViewHolder(FlexibleAdapter adapter, LayoutInflater inflater, ViewGroup parent) {
        return createViewHolder((CustomListAdapter) adapter, inflater, parent);
    }

    @Override
    public void bindViewHolder(FlexibleAdapter adapter, VH holder, int position, List payloads) {
        bindViewHolder(holder);
    }

}
