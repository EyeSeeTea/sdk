package org.eyeseetea.sdk.presentation.styles;

import org.eyeseetea.sdk.R;

public enum FontStyle {
    XSmall(R.style.FontStyle_Small, "XSmall"),
    Small(R.style.FontStyle_Small, "Small"),
    Medium(R.style.FontStyle_Medium, "Medium"),
    Large(R.style.FontStyle_Large, "Large"),
    XLarge(R.style.FontStyle_Small, "XLarge");

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
