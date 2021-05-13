package org.eyeseetea.sdk.presentation.views;

import android.content.Context;
import android.util.AttributeSet;

public class CustomEditText extends androidx.appcompat.widget.AppCompatEditText implements
        IEyeSeeView {

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

        CustomViewFontHelper.setFontName(this, attrs, defStyle);

        CustomViewTranslationHelper.translateTextsViews(getContext(),attrs,this);
    }

    public void setFontName(String fontName) {
        CustomViewFontHelper.setFontName(this, fontName);
    }

    @Override
    public void setTextTranslation(int textId) {
        CustomViewTranslationHelper.translateText(textId, this);
    }

    @Override
    public void setHintTranslation(int hintId) {
        CustomViewTranslationHelper.translateHint(hintId, this);
    }
}

