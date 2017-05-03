package org.eyeseetea.sdk.presentation.views.dialogs;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.eyeseetea.sdk.R;
import org.eyeseetea.sdk.presentation.views.CustomNumberPicker;

import java.util.Calendar;

public class YearPicker extends DialogFragment {
    private int yearInterval = 200;

    private OnYearSelectedListener mOnYearSelectedListener;
    private CustomNumberPicker mNumberPicker;
    private Button ok, cancel;
    private int maxYear = 0, minYear = 0;
    private Context mContext;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();
        mContext = context;
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.fragment_year_picker);
        setMaxMinYears();
        initViews(dialog);
        return dialog;
    }

    private void initViews(final Dialog dialog) {
        mNumberPicker = (CustomNumberPicker) dialog.findViewById(R.id.year_picker);
        mNumberPicker.setMaxValue(maxYear);
        mNumberPicker.setMinValue(minYear);
        mNumberPicker.setValue(maxYear);
        ok = (Button) dialog.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnYearSelectedListener != null) {
                    mOnYearSelectedListener.onYearSelected(mNumberPicker.getValue());
                    dialog.cancel();
                }
            }
        });
        cancel = (Button) dialog.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
    }

    private void setMaxMinYears() {
        Calendar calendar = Calendar.getInstance();
        if (maxYear == 0) maxYear = calendar.get(Calendar.YEAR);
        if (minYear == 0) minYear = maxYear - yearInterval;
    }


    public void setOnYearSelectedListener(
            OnYearSelectedListener onYearSelectedListener) {
        mOnYearSelectedListener = onYearSelectedListener;
    }

    public interface OnYearSelectedListener {
        void onYearSelected(int year);
    }

    public void setButtonsFont(int font, int textSize) {
        Typeface type = Typeface.createFromAsset(mContext.getAssets(), mContext.getString(font));
        ok.setTypeface(type);
        ok.setTextSize(textSize);
        cancel.setTypeface(type);
        cancel.setTextSize(textSize);
    }

    public void setButtonsFontWithAttributeRefrenece(int font, int textSizeAttributeReference) {
        Typeface type = Typeface.createFromAsset(mContext.getAssets(), mContext.getString(font));
        int[] textSizeAttr = new int[]{textSizeAttributeReference};
        int indexOfAttrTextSize = 0;
        TypedArray a = mContext.obtainStyledAttributes(textSizeAttr);
        int textSize = a.getDimensionPixelSize(indexOfAttrTextSize, -1);
        a.recycle();

        ok.setTypeface(type);
        ok.setTextSize(textSize);
        cancel.setTypeface(type);
        cancel.setTextSize(textSize);
    }


    public void setYearInterval(int yearInterval) {
        this.yearInterval = yearInterval;
        setMaxMinYears();
    }

    public void setMaxMinYear(int maxYear, int minYear) {
        this.maxYear = maxYear;
        this.minYear = minYear;
    }

    public void setMaxtYear(int maxYear) {
        this.maxYear = maxYear;
    }

    public void setMinYear(int minYear) {
        this.minYear = minYear;
    }
}
