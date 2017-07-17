package com.mech;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Agustin on 15/7/2017.
 */

public abstract class AdapterItem<I, VH extends ViewHolder<I>> extends AbstractAdapterItem<VH, BasicHeader> {

    protected I item;

    protected BasicHeader header;

    protected abstract VH createViewHolder(View view, CustomListAdapter adapter);

    public AdapterItem(I item) {
        this.item = item;
    }

    public VH createViewHolder(CustomListAdapter adapter, LayoutInflater inflater, ViewGroup parent) {
        View itemView = inflater.inflate(getItemLayout(), parent, false);
        return createViewHolder(itemView, adapter);
    }

    public void bindViewHolder(VH holder) {
        holder.showItem(item);
    }

    @Override
    public boolean equals(Object inObject) {
        if (inObject instanceof AdapterItem) {
            AdapterItem inItem = (AdapterItem) inObject;
            return this.getItemLayout() == inItem.getItemLayout();
        }
        return false;
    }

    @Override
    public BasicHeader getHeader() {
        return header;
    }

    @Override
    public void setHeader(BasicHeader header) {
        this.header = header;
    }

}