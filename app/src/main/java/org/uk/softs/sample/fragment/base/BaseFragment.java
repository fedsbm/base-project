package org.uk.softs.sample.fragment.base;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.uk.softs.sample.R;
import org.uk.softs.sample.activity.base.BaseActivity;
import org.uk.softs.sample.util.Utils;


public abstract class BaseFragment extends Fragment {

    protected Resources mResources;

    private ProgressBar mContentProgressBar;
    private View mContentMainContainerView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResource(), container, false);
        mResources = this.getResources();
        mContentMainContainerView = view.findViewById(R.id.content_container_view);
        mContentProgressBar = (ProgressBar) view.findViewById(R.id.content_progress_bar);

        return view;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Always ensure this fragment comes from base activity
        if (!(activity instanceof BaseActivity)) {
            throw new ClassCastException(activity.toString() + " must be a " + BaseActivity.class.getSimpleName());
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setViewReferences();
        setupFragment(savedInstanceState);
    }

    protected abstract int getLayoutResource();

    /**
     * Sets up view references. Called in the {@link Fragment#onActivityCreated(Bundle)}
     */
    protected abstract void setViewReferences();

    /**
     * Generic setup of the fragment. Called in the {@link Fragment#onActivityCreated(Bundle)}
     * after the {@link BaseFragment#setViewReferences()} method.
     */
    protected abstract void setupFragment(Bundle savedInstanceState);

    protected void setTitle(int titleId) {
        getActivity().setTitle(titleId);
    }

    protected void setTitle(CharSequence title) {
        getActivity().setTitle(title);
    }

    protected boolean isNetworkConnectionUp() {
        if (!Utils.isNetworkConnectionAvailable(getActivity())) {
            Toast.makeText(getActivity(), "Network connection not available", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    protected void showProgressBar() {
        if (mContentProgressBar != null) {
            mContentProgressBar.setVisibility(View.VISIBLE);
        }
        if (mContentMainContainerView != null) {
            mContentMainContainerView.setVisibility(View.GONE);
        }
    }

    protected void hideProgressBar() {
        if (mContentProgressBar != null) {
            mContentProgressBar.setVisibility(View.GONE);
        }
        if (mContentMainContainerView != null) {
            mContentMainContainerView.setVisibility(View.VISIBLE);
        }
    }

    protected View findViewById(int id) {
        return getActivity().findViewById(id);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
