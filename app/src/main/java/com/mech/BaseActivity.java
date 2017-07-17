package com.mech;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Agustin on 16/7/2017.
 */

public class BaseActivity extends AppCompatActivity implements Subscriber {

    protected EventManager eventManager = new EventManager();

    protected AppCompatActivity getActivity() {
        return this;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //eventManager.register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //eventManager.unregister(this);
    }
}
