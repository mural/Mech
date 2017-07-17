package com.mech;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.IHeader;

/**
 * Created by Agustin on 15/7/2017.
 */

public abstract class CustomListAdapter<ADAPTER_ITEM extends ICustomAdapter, ITEM> extends FlexibleAdapter {

    private static final String TAG = CustomListAdapter.class.getSimpleName();
    private List<ITEM> modelItems = Lists.newArrayList();
    protected ITEM selectedItem;

    public abstract ADAPTER_ITEM createAdapterItem(ITEM item);

    public CustomListAdapter(Collection<ITEM> items) {
        super(null);
        for (ITEM item : items) {
            addItem(item);
        }
    }

    public CustomListAdapter(Collection<ITEM> items, BasicHeader header) {
        super(null);
        for (ITEM item : items) {
            addItem(item, header);
        }
    }

    public List<ITEM> getModelItems() {
        return modelItems;
    }

    public int getPosition(ITEM item) {
        return modelItems.indexOf(item);
    }

    public int getPosition(ADAPTER_ITEM adapter_item, ITEM item) {
        int adjustPosition = 0;
        if (adapter_item.getHeader() != null) {
            IHeader headerItem = getHeaderOf(adapter_item);
            int headerItemIndex = getHeaderItems().indexOf(headerItem);
            if (headerItemIndex >= 0) {
                adjustPosition = headerItemIndex + 1;
            }
        }
        return modelItems.indexOf(item) + adjustPosition;
    }

    public Optional<ITEM> getModelItem(int position) {
        Optional<ITEM> itemOptional = Optional.of(modelItems.get(position));
        return itemOptional;
    }

    public boolean addItem(ITEM item) {
        addItem(getItemCount(), createAdapterItem(item));
        return modelItems.add(item);
    }

    public boolean addItem(ITEM item, BasicHeader header) {
        ADAPTER_ITEM adapter_item = createAdapterItem(item);
        adapter_item.setHeader(header);
        addItem(getItemCount(), adapter_item);
        return modelItems.add(item);
    }

    public boolean removeItem(ITEM item) {
        ADAPTER_ITEM adapter_item = createAdapterItem(item);
        removeItem(getPosition(adapter_item, item));
        return modelItems.remove(item);
    }

    public boolean contains(ITEM item) {
        return modelItems.contains(item);
    }

    public void updateItem(ITEM item) {
        ADAPTER_ITEM adapter_item = createAdapterItem(item);
        updateItem(getPosition(adapter_item, item), adapter_item, item);
        modelItems.set(getPosition(item), item);
    }

    public void setItems(Collection<ITEM> items) {
        removeRange(0, getItemCount()); //clear all
        modelItems.clear();
        for (ITEM item : items) {
            addItem(item);
        }
    }

    @Override
    public void swapItems(List list, int fromPosition, int toPosition) {
        super.swapItems(list, fromPosition, toPosition);
        //TODO AviOnLogger.d(TAG, "fromPosition: " + fromPosition + " toPosition: " + toPosition);
        Collections.swap(modelItems, fromPosition, toPosition);
    }

    public void setSelectedItem(ITEM selected) {
        this.selectedItem = selected;
    }

    public ITEM getSelectedItem() {
        return this.selectedItem;
    }
}