package org.eyeseetea.sdk.presentation.views;

import android.util.AttributeSet;

public interface IEyeSeeView {

    void init(AttributeSet attrs, int defStyle);

    void setFontName(String mFontName);

    String getFontName();
}
