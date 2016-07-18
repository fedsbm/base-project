package org.uk.softs.sample.fragment.base;

import android.app.Activity;

import org.uk.softs.sample.activity.base.RetrofitActivity;
import org.uk.softs.sample.api.RetrofitService;

public abstract class RetrofitFragment extends BaseFragment {

    private RetrofitService mRetrofitService;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Always ensure this fragment comes from spice activity
        if (!(activity instanceof RetrofitActivity)) {
            throw new ClassCastException(activity.toString() + " must be a " + RetrofitActivity.class.getSimpleName());
        }

        mRetrofitService = ((RetrofitActivity) activity).getRetrofitService();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    protected RetrofitService getRetrofitService() {
        return mRetrofitService;
    }

    protected RetrofitActivity getRetrofitActivity() {
        return (RetrofitActivity) getActivity();
    }

    public void showErrorDialog(Throwable throwable) {
        getRetrofitActivity().showErrorDialog(throwable);
    }

    public void showErrorDialog(Throwable throwable, boolean finishOnOk) {
        getRetrofitActivity().showErrorDialog(throwable, finishOnOk);
    }

}
