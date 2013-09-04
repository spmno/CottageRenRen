package com.spmno.cottagerenren.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.spmno.cottagerenren.R;

import java.util.jar.Attributes;

/**
 * Created by spmno on 13-8-26.
 */
public class TopNavbar extends FrameLayout {
    public TextView title;
    public LinearLayout back;

    public TopNavbar(Context context) {
        super(context);
        setupViews();
    }

    public TopNavbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setupViews();
    }

    private void setupViews() {
        final LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        RelativeLayout relativeLayout = (RelativeLayout)layoutInflater.inflate(R.layout.top_navbar, null);
        addView(relativeLayout);
        back = (LinearLayout)relativeLayout.findViewById(R.id.ll_back);
        title = (TextView)relativeLayout.findViewById(R.id.tv_title);
    }
}
