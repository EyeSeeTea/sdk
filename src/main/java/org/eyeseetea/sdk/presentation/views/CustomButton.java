/*
 * Copyright (c) 2015.
 *
 * This file is part of QIS Surveillance App.
 *
 *  QIS Surveillance App is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  QIS Surveillance App is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with QIS Surveillance App.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.eyeseetea.sdk.presentation.views;

import android.content.Context;
import android.util.AttributeSet;

public class CustomButton extends android.support.v7.widget.AppCompatButton implements IEyeSeeView {
    public CustomButton(Context context) {
        super(context);
        init(null, 0);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    public void init(AttributeSet attrs, int defStyle) {
        if (isInEditMode()) {
            return;
        }

        CustomViewTranslationHelper.translateTextsViews(getContext(), attrs, this);

        CustomViewFontHelper.setFontName(this, attrs, defStyle);
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

