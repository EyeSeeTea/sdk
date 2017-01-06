package org.eyeseetea.sdk.presentation.views;

import android.content.Context;
import android.util.AttributeSet;

public interface IEyeSeeView {

    void init(AttributeSet attrs, int defStyle);

    void setFontName(String fontName);

    Context getContext();
}
