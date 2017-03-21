package org.eyeseetea.sdk.presentation.styles;

import org.eyeseetea.sdk.R;

public enum FontStyle {
    XSmall(R.style.FontStyle_XSmall, "font_extra_small"),
    Small(R.style.FontStyle_Small, "font_small"),
    Medium(R.style.FontStyle_Medium, "font_medium"),
    Large(R.style.FontStyle_Large, "font_large"),
    XLarge(R.style.FontStyle_XLarge, "font_extra_large");

    private int resId;
    private String title;

    public int getResId() {
        return resId;
    }

    public String getTitle() {
        return title;
    }

    FontStyle(int resId, String title) {
        this.resId = resId;
        this.title = title;
    }
}
