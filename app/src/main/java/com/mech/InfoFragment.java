package com.mech;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Agustin on 16/7/2017.
 */

@EFragment(R.layout.fragment_info)
public class InfoFragment extends Fragment {

    @ViewById(R.id.toolbar)
    protected Toolbar toolbar;
    @ViewById(R.id.fab)
    protected FloatingActionButton fab;

    @AfterViews
    protected void afterViews() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }


}
