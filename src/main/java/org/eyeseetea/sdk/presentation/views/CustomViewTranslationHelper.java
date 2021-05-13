package org.eyeseetea.sdk.presentation.views;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.annotation.StringRes;
import android.util.AttributeSet;
import android.widget.TextView;

import org.eyeseetea.sdk.common.EyeSeeTeaSdk;
import org.eyeseetea.sdk.common.Transaltor;

public class CustomViewTranslationHelper {
    public static void translateTextsViews(Context context, AttributeSet attrs, TextView view) {
        Transaltor transaltor = EyeSeeTeaSdk.getInstance().getTranslator();
        if (transaltor != null) {
            int[] set = {
                    android.R.attr.text,
                    android.R.attr.hint
            };
            TypedArray a = context.obtainStyledAttributes(attrs, set);

            int textId = a.getResourceId(0, -1);
            if (textId != -1) {
                view.setText(getTranslatedString(textId, context, transaltor));
            }

            int hintId = a.getResourceId(1, -1);
            if (hintId != -1) {
                view.setHint(getTranslatedString(hintId, context, transaltor));
            }
        }
    }

    public static void translateText(int textId, TextView textView) {
        Transaltor transaltor = EyeSeeTeaSdk.getInstance().getTranslator();
        if (transaltor != null) {
            textView.setText(getTranslatedString(textId, textView.getContext(), transaltor));
        }
    }

    public static void translateHint(int hintId, TextView textView) {
        Transaltor transaltor = EyeSeeTeaSdk.getInstance().getTranslator();
        if (transaltor != null) {
            textView.setHint(getTranslatedString(hintId, textView.getContext(), transaltor));
        }
    }

    private static String getTranslatedString(@StringRes int stringId, Context context,
            Transaltor transaltor) {
        String textKey = context.getResources().getResourceEntryName(stringId);
        return transaltor.getTranslation(textKey, context);
    }
}
