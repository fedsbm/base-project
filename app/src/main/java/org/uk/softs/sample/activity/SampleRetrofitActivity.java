package org.uk.softs.sample.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.util.List;

import org.uk.softs.sample.R;
import org.uk.softs.sample.activity.base.RetrofitActivity;
import org.uk.softs.sample.model.api.SampleResponseData;
import org.uk.softs.sample.model.api.SampleSendRetrofitData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by fernando on 11/07/2016.
 */
public class SampleRetrofitActivity extends RetrofitActivity {

    private TextView mResponseTextView;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_retrofit_request;
    }

    @Override
    protected void setViewReferences() {
        mResponseTextView = (TextView) findViewById(R.id.retrofit_result_text);
    }

    @Override
    protected void setupActivity(Bundle savedInstanceState) {
        showProgressBar();

        //Fake delay to show progress bar
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sampleCall();
            }
        }, 3000);

    }

    public static Intent getNewIntent(Context context) {
        Intent intent = new Intent(context, SampleRetrofitActivity.class);
        return intent;

    }

    private void sampleCall() {

        showProgressBar();

        SampleSendRetrofitData model = new SampleSendRetrofitData("sample_key_123"); //Send as @Body when the request requires

        final Call<List<SampleResponseData>> call =
                getRetrofitService().getExample(1);

        call.enqueue(new Callback<List<SampleResponseData>>() {
            @Override
            public void onResponse(Call<List<SampleResponseData>> call, Response<List<SampleResponseData>> response) {
                hideProgressBar();
                if (response.body() != null) {
                    mResponseTextView.setText("Size: " + response.body().size() + "\n" +
                            "Response: " + response.body().toString());
                } else {
                    //do something
                    mResponseTextView.setText("Response empty");
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
