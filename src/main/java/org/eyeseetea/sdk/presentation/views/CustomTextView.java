package org.eyeseetea.sdk.presentation.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

import org.eyeseetea.sdk.R;

public class CustomTextView extends android.support.v7.widget.AppCompatTextView implements IEyeSeeView {

    public CustomTextView(Context context) {
        super(context);
        init(null, 0);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    public void init(AttributeSet attrs, int defStyle) {
        if (isInEditMode()) {
            return;
        }

        CustomViewFontHelper.setFontName(this,attrs,defStyle);
        CustomViewTranslationHelper.translateTextsViews(getContext(),attrs,this);
    }

    public void setFontName(String fontName) {
        CustomViewFontHelper.setFontName(this,fontName);
    }

    @Override
    public void translateText(int textId) {
        CustomViewTranslationHelper.translateText(textId, this);
    }

    @Override
    public void translateHint(int hintId) {
        CustomViewTranslationHelper.translateHint(hintId, this);
    }
}

