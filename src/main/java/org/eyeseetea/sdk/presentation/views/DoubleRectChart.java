package org.eyeseetea.sdk.presentation.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import org.eyeseetea.sdk.R;


public class DoubleRectChart extends FrameLayout {
    private LinearLayout externalRect, leftLine, rightLine;
    private CustomTextView score;

    public DoubleRectChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.double_rect_chart, this);
        
        externalRect = (LinearLayout) findViewById(R.id.external_rect);
        score = (CustomTextView) findViewById(R.id.score);
        leftLine = (LinearLayout) findViewById(R.id.left_line);
        rightLine = (LinearLayout) findViewById(R.id.right_line);
    }

    public void createDoubleRectChart(final String textScore, final int scorePercentage, int color,
            int leftColor, int rightColor, int textColor) {
        externalRect.setBackgroundColor(color);
        leftLine.setBackgroundColor(leftColor);
        rightLine.setBackgroundColor(rightColor);
        score.setText(textScore);
        score.setTextColor(textColor);

        float restOfPercentage;
        restOfPercentage = 100.0f - scorePercentage;

        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT,
                scorePercentage
        );
        rightLine.setLayoutParams(param);

        param = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT,
                restOfPercentage
        );
        leftLine.setLayoutParams(param);
    }
}
