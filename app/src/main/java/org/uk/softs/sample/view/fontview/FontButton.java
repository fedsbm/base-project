package org.uk.softs.sample.view.fontview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.util.AttributeSet;

import org.uk.softs.sample.R;
import org.uk.softs.sample.SampleAndroidApplication;


public class FontButton extends AppCompatButton {

    public FontButton(Context context, AttributeSet attrs) {
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
