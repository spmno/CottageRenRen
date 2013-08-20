package com.spmno.cottagerenren;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public abstract class AppBaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((RenrenApplication)(this.getApplication())).addActivity(this);
        setContentView(getLayoutId());
        setupView();
        initData();
    }

    protected abstract int getLayoutId();
    protected abstract void setupView();
    protected abstract void initData();

    protected void show(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}
