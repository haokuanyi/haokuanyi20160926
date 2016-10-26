package com.bawei.y;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by haokuanyi on 2016/9/26.
 */
public class MyListView extends ListView {
    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
