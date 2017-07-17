package com.mech;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractHeaderItem;
import eu.davidea.viewholders.FlexibleViewHolder;

/**
 * Created by Agustin on 15/7/2017.
 */

public class BasicHeader extends AbstractHeaderItem {

    private String title;

    public BasicHeader(String title) {
        super();
        this.title = title;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.section_list_header;
    }

    @Override
    public RecyclerView.ViewHolder createViewHolder(FlexibleAdapter adapter, LayoutInflater inflater, ViewGroup parent) {
        return new SectionViewHolder(inflater.inflate(getLayoutRes(), parent, false), adapter);
    }

    @Override
    public void bindViewHolder(FlexibleAdapter adapter, RecyclerView.ViewHolder holder, int position, List payloads) {
        ((SectionViewHolder) holder).title.setText(title);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof BasicHeader) {
            return ((BasicHeader) o).title.equals(title);
        }
        return false;
    }

    static class SectionViewHolder extends FlexibleViewHolder {
        TextView title;

        public SectionViewHolder(View view, FlexibleAdapter adapter) {
            super(view, adapter, true); // true for enable sticky headers!
            title = (TextView) view.findViewById(R.id.section_view);
        }
    }

}
