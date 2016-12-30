/*
 * Copyright (c) 2015.
 *
 * This file is part of QIS Surveillance App.
 *
 *  QIS Surveillance App App is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  QIS Surveillance App App is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with QIS Surveillance App.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.eyeseetea.sdk.presentation.views;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;
import java.util.Map;

public class TypefaceCache {
    public static final String FONTS_PATH = "fonts/";
    private static TypefaceCache instance;

    private Map<String, Typeface> fontsCache;

    TypefaceCache() {
        fontsCache = new HashMap<>();
    }

    public static TypefaceCache getInstance() {
        if (instance == null) {
            instance = new TypefaceCache();
        }
        return instance;
    }

    public Typeface getTypeface(String fontName, Context context) {
        Typeface typeface = fontsCache.get(fontName);
        if (typeface == null) {
            typeface = Typeface.createFromAsset(context.getAssets(), FONTS_PATH + fontName);
            fontsCache.put(fontName, typeface);
        }
        return typeface;
    }
}
