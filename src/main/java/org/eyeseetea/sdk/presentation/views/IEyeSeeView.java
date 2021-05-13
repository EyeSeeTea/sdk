package org.eyeseetea.sdk.presentation.views;

import android.content.Context;
import androidx.annotation.IdRes;
import android.util.AttributeSet;

public interface IEyeSeeView {

    void init(AttributeSet attrs, int defStyle);

    void setFontName(String fontName);

    Context getContext();

    void setTextTranslation(@IdRes int textId);

    void setHintTranslation(@IdRes int hintId);
}
