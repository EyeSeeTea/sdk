package org.eyeseetea.sdk.presentation.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;

import org.eyeseetea.sdk.R;

public class CustomEditText extends EditText implements IEyeSeeView {

    private String mfontName = null;
    private TypedArray mTypedArray;

    public CustomEditText(Context context) {
        super(context);
        init(null, 0);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    public void init(AttributeSet attrs, int defStyle) {
        if (isInEditMode()) {
            return;
        }

        if (attrs != null) {
            mTypedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomFont, defStyle, 0);
            try {
                mfontName = mTypedArray.getString(R.styleable.CustomFont_font_name);
                if (mfontName != null) {
                    setTypeface(TypefaceCache.getInstance().getTypeface(mfontName, getContext()));
                }

            }
            finally {
                mTypedArray.recycle();
            }
        }
    }

    public String getFontName() {
        return mfontName;
    }

    public void setFontName(String mFontName) {
        this.mfontName = mfontName;
    }
}

