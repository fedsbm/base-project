package org.uk.softs.sample.controller;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.TextView;

import java.util.HashMap;

import org.uk.softs.sample.style.FontTypeFaceSpan;


public class FontManager {

    private Context mContext;
    private HashMap<String, Typeface> mFontCache = new HashMap<>();

    public FontManager(Context context) {
        mContext = context;
    }

    public void setTypeface(TextView view, String font) {
        if (TextUtils.isEmpty(font)) {
            return;
        }
        view.setTypeface(getTypeface(font));
    }

    public Typeface getTypeface(int fontResId) {
        return getTypeface(mContext.getString(fontResId));
    }

    public Typeface getTypeface(String fontRes) {

        Typeface typeface = null;

        if (mFontCache.containsKey(fontRes)) {
            typeface = mFontCache.get(fontRes);
        } else {
            typeface = Typeface.createFromAsset(mContext.getAssets(), fontRes);
            mFontCache.put(fontRes, typeface);
        }

        return typeface;
    }

    public SpannableString getFontSpannableString(int fontId, String text) {
        SpannableString ss = new SpannableString(text);
        ss.setSpan(new FontTypeFaceSpan(getTypeface(fontId)), 0, ss.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ss;
    }
}
