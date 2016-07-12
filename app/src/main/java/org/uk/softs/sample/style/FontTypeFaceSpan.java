package org.uk.softs.sample.style;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

public class FontTypeFaceSpan extends TypefaceSpan {

    private Typeface mTypeface;

    public FontTypeFaceSpan(Typeface typeface) {
        super("");
        mTypeface = typeface;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setTypeface(mTypeface);
    }
}
