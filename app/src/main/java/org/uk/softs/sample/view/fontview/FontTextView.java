package org.uk.softs.sample.view.fontview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

import org.uk.softs.sample.R;
import org.uk.softs.sample.SampleAndroidApplication;

public class FontTextView extends TextView {

    public FontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (!isInEditMode()) {
            TypedArray styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.FontView);
            String fontName = styledAttrs.getString(R.styleable.FontView_typeface);
            styledAttrs.recycle();

            if (!TextUtils.isEmpty(fontName)) {
                SampleAndroidApplication.getInstance().getFontManager().setTypeface(this, fontName);
                setPaintFlags(getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
            }
        }
    }
}
