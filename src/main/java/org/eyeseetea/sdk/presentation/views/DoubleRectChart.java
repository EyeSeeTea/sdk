package org.eyeseetea.sdk.presentation.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import org.eyeseetea.sdk.R;


public class DoubleRectChart extends FrameLayout {
    private FrameLayout chart;
    private LinearLayout externalRect, leftLine, rightLine;
    private CustomTextView score;

    public DoubleRectChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        inflate(context, R.layout.double_rect_chart, this);

        externalRect = (LinearLayout) findViewById(R.id.external_rect);
        chart = (FrameLayout) findViewById(R.id.double_rect_container);
        score = (CustomTextView) findViewById(R.id.score);
        leftLine = (LinearLayout) findViewById(R.id.left_line);
        rightLine = (LinearLayout) findViewById(R.id.right_line);

        int[] attrsArray = new int[]{
                android.R.attr.layout_width,
                android.R.attr.layout_height
        };
        TypedArray ta = context.obtainStyledAttributes(attributeSet, attrsArray);
        int layout_width = ta.getDimensionPixelSize(0, FrameLayout.LayoutParams.MATCH_PARENT);
        int layout_height = ta.getDimensionPixelSize(1, FrameLayout.LayoutParams.MATCH_PARENT);

        chart.setLayoutParams(new FrameLayout.LayoutParams(layout_width, layout_height));

    }

    public void createDoublePie(final String textScore, final int totalScore, int color,
            int leftColor, int rightColor, int textColor) {
        externalRect.setBackgroundColor(color);
        leftLine.setBackgroundColor(leftColor);
        rightLine.setBackgroundColor(rightColor);
        score.setText(textScore);
        score.setTextColor(textColor);

        float leftPercentage;
        leftPercentage = 100.0f - totalScore;

        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT,
                totalScore
        );
        rightLine.setLayoutParams(param);

        param = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT,
                leftPercentage
        );
        leftLine.setLayoutParams(param);
    }
}
