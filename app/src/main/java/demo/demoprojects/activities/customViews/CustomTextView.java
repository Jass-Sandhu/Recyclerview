package demo.demoprojects.activities.customViews;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by epi-i5-gold on 2/4/2019.
 */

public class CustomTextView extends TextView {
    public CustomTextView(Context context) {
        super(context);

    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

    }


    @Override
    public void setTypeface(Typeface tf) {
        super.setTypeface(tf);


    }
}
