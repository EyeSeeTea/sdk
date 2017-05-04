package org.eyeseetea.sdk.presentation.views;

import static android.R.attr.textSize;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;

import org.eyeseetea.sdk.R;


public class CustomNumberPicker extends NumberPicker {

    public CustomNumberPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void addView(View child) {
        super.addView(child);
        updateView(child);
    }

    @Override
    public void addView(View child, int index,
            android.view.ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        updateView(child);
    }

    @Override
    public void addView(View child, android.view.ViewGroup.LayoutParams params) {
        super.addView(child, params);
        updateView(child);
    }

    private void updateView(View view) {
        int[] textSizeAttr = new int[]{R.attr.font_small};
        int indexOfAttrTextSize = 0;
        TypedArray a = getContext().obtainStyledAttributes(textSizeAttr);
        int textSize = a.getDimensionPixelSize(indexOfAttrTextSize, -1);
        a.recycle();
            if (textSize > 0) {
                ((EditText) view).setTextSize(textSize);
            }

    }
}
