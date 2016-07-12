package org.uk.softs.sample.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.uk.softs.sample.R;
import org.uk.softs.sample.util.RandomNumberHelper;
import org.uk.softs.sample.activity.base.BaseActivity;


public class MainActivity extends BaseActivity {

    private TextView mVersionValueTextView;
    private TextView mDevBuildMessageTextView;
    private Button mShowRandomNumberButton;
    private Button mRetrofitRequestButton;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupActionBar(ActionBar actionBar) {
        // Do nothing as we don't want to do anything else with the actionbar
    }

    @Override
    protected void setViewReferences() {
        mVersionValueTextView = (TextView) findViewById(R.id.main_version_value_text_view);
        mDevBuildMessageTextView = (TextView) findViewById(R.id.main_dev_build_msg_text_view);
        mShowRandomNumberButton = (Button) findViewById(R.id.main_show_random_number_button);
        mRetrofitRequestButton = (Button) findViewById(R.id.main_retrofit_button);
    }

    @Override
    protected void setupActivity(Bundle savedInstanceState) {

        mVersionValueTextView.setText(getVersionName());
        if (getResources().getBoolean(R.bool.dev_build)) {
            mDevBuildMessageTextView.setVisibility(View.VISIBLE);
        } else {
            mDevBuildMessageTextView.setVisibility(View.GONE);
        }

        mShowRandomNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchShowRandomNumberActivity();
            }
        });

        mRetrofitRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchRetrofitActivity();
            }
        });
    }

    private void launchRetrofitActivity() {
        startActivity(SampleRetrofitActivity.getNewIntent(this));
    }

    private String getVersionName() {

        String versionName;

        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            versionName = "";
        }

        return versionName;
    }

    private void launchShowRandomNumberActivity() {

        // This example demonstrates how to get an activity intent (also passing values)
        int randomNumber = RandomNumberHelper.getRandomNumber();
        startActivity(ShowRandomNumberActivity.getNewIntent(this, randomNumber));
    }


}
