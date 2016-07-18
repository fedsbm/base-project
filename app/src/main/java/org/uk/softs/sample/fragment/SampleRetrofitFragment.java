package org.uk.softs.sample.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.uk.softs.sample.R;
import org.uk.softs.sample.fragment.base.RetrofitFragment;
import org.uk.softs.sample.model.api.SampleResponseData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by fernando on 18/07/2016.
 */
public class SampleRetrofitFragment extends RetrofitFragment {

    private ImageView mCloseImageView;
    private TextView mResultTextView;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_retrofit_request;
    }

    @Override
    protected void setViewReferences() {
        mCloseImageView = (ImageView) findViewById(R.id.sample_fragment_close);
        mResultTextView = (TextView) findViewById(R.id.retrofit_fragment_result_text);
    }

    @Override
    protected void setupFragment(Bundle savedInstanceState) {
        hideProgressBar();
        mCloseImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showProgressBar();
                //Fake delay to show progress bar
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadSampleData();
                    }
                }, 1500);

            }
        });
    }

    private void loadSampleData() {
        final Call<List<SampleResponseData>> call =
                getRetrofitService().getExample(1);

        call.enqueue(new Callback<List<SampleResponseData>>() {
            @Override
            public void onResponse(Call<List<SampleResponseData>> call, Response<List<SampleResponseData>> response) {
                hideProgressBar();
                if (response.body() != null) {
                    mResultTextView.setText("Size: " + response.body().size() + "\n" +
                            "Response: " + response.body().toString());
                    mResultTextView.setMovementMethod(new ScrollingMovementMethod());
                } else {
                    //do something
                    mResultTextView.setText("Response empty");
                }
            }

            @Override
            public void onFailure(Call<List<SampleResponseData>> call, Throwable t) {
                hideProgressBar();
                Boolean finishOnOk = true;
                showErrorDialog(t, finishOnOk);
            }
        });
    }
}
