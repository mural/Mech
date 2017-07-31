package com.mech;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Agustin on 15/7/2017.
 */

public class CategoriesListItemViewHolder extends ViewHolder<Category> {

    private Category mCategory;
    private TextView mNameLabel;
    private TextView mDetailLabel;
    private ImageView mPicture;

    public CategoriesListItemViewHolder(View view, CustomListAdapter adapter) {
        super(view, adapter);

        mNameLabel = (TextView) view.findViewById(R.id.item_name);
        mDetailLabel = (TextView) view.findViewById(R.id.item_detail);
        mPicture = (ImageView) view.findViewById(R.id.item_picture);
    }

    @Override
    public void showItem(Category category) {
        mNameLabel.setText(category.getName());
        mDetailLabel.setText(category.getDetail());
        Glide.with(MechApplication.getAppContext()).load(category.getPictureId()).into(mPicture);
    }

    @Override
    public Category getItem() {
        return mCategory;
    }
}
