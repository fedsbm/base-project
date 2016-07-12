package org.uk.softs.sample.activity.base;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import java.io.IOException;

import org.uk.softs.sample.R;
import org.uk.softs.sample.api.BaseRetrofit;
import org.uk.softs.sample.api.SampleRetrofitService;
import retrofit2.Retrofit;

public abstract class RetrofitActivity extends BaseActivity {

    private Retrofit mRetrofit;

    private SampleRetrofitService mRetrofitService;

    public void showErrorDialog(Throwable throwable) {
        showErrorDialog(throwable, false);
    }

    @Override
    protected void initBaseValues() {
        super.initBaseValues();
        mRetrofit = new BaseRetrofit(this).getRetrofit();
        mRetrofitService = mRetrofit.create(SampleRetrofitService.class);
    }

    public SampleRetrofitService getRetrofitService() {
        return mRetrofitService;
    }

    public Retrofit getBaseRetrofit() {
        return mRetrofit;
    }

    public void showErrorDialog(Throwable throwable, boolean finishOnOk) {

        // As long as this is not a cancelled exception, it's a valid error
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this).setPositiveButton("OK", null);

        if (throwable instanceof IOException) {
            // Show no network dialog
            dialogBuilder.setTitle(R.string.error_no_network_title)
                    .setMessage(R.string.error_no_network_msg);

        } else {
            // Show some generic error message
            if (throwable != null && throwable.getCause().getMessage() != null &&
                    throwable.getCause().getMessage().equals("401 Unauthorized")) {

                dialogBuilder.setTitle(R.string.error_generic_title)
                        .setMessage(R.string.error_generic_credentials);

            } else {
                // Show some generic error message
                dialogBuilder.setTitle(R.string.error_generic_title)
                        .setMessage(R.string.error_generic_msg);
            }
        }

        if (finishOnOk) {
            dialogBuilder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {
                    finish();
                }
            });
        }

        dialogBuilder.show();

    }

}
