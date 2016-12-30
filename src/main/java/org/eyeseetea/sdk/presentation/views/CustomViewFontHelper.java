package org.eyeseetea.sdk.presentation.views;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import org.eyeseetea.sdk.R;

public class CustomViewFontHelper {
    public static void setFontName(IEyeSeeView eyeSeeView, AttributeSet attrs, int defStyle) {
        TypedArray mTypedArray;
        String fontName = null;

        if (attrs != null) {
            mTypedArray = eyeSeeView.getContext().obtainStyledAttributes(attrs,
                    R.styleable.CustomFont, defStyle, 0);
            try {
                fontName = mTypedArray.getString(R.styleable.CustomFont_font_name);
                if (fontName != null) {
                    ((TextView) eyeSeeView).setTypeface(
                            TypefaceCache.getInstance().getTypeface(fontName,
                                    eyeSeeView.getContext()));
                }
            } finally {
                mTypedArray.recycle();
            }
        }
    }

    public static void setFontName(IEyeSeeView eyeSeeView, String fontName) {
        ((TextView) eyeSeeView).setTypeface(
                TypefaceCache.getInstance().getTypeface(fontName,
                        eyeSeeView.getContext()));
    }
}
