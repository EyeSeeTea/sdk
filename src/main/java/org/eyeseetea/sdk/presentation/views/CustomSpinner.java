package org.eyeseetea.sdk.presentation.views;

import android.content.Context;
import android.util.AttributeSet;

public class CustomSpinner extends androidx.appcompat.widget.AppCompatSpinner {
    public CustomSpinner(Context context) {
        super(context);
    }

    public CustomSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // set the ceaseFireOnItemClickEvent argument to true to avoid firing an event
    public void setSelection(int position, boolean animate, boolean ceaseFireOnItemClickEvent) {
        OnItemSelectedListener l = getOnItemSelectedListener();
        if (ceaseFireOnItemClickEvent) {
            setOnItemSelectedListener(null);
        }

        super.setSelection(position, animate);

        if (ceaseFireOnItemClickEvent) {
            setOnItemSelectedListener(l);
        }
    }
}