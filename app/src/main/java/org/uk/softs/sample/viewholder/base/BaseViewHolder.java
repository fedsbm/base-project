package org.uk.softs.sample.viewholder.base;

import android.content.Context;
import android.view.View;

public abstract class BaseViewHolder<T> {

    private Context mContext;
    private View mView;

    public BaseViewHolder(Context context, View view) {
        mContext = context;
        mView = view;
        initialiseView(view);
    }

    protected abstract void initialiseView(View view);

    protected Context getContext() {
        return mContext;
    }

    protected View getView() {
        return mView;
    }

    public void bindView(T model) {

    }

    public void bindView(T model, boolean selected) {

    }
}
