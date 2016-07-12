package org.uk.softs.sample.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.uk.softs.sample.R;
import org.uk.softs.sample.activity.base.BaseActivity;

public class ShowRandomNumberActivity extends BaseActivity {

    private static final String RANDOM_NUMBER_KEY = "random_number";

    private TextView mNumberTextView;

    public static Intent getNewIntent(Context context, int randomNumber) {
        Intent intent = new Intent(context, ShowRandomNumberActivity.class);
        intent.putExtra(RANDOM_NUMBER_KEY, randomNumber);
        return intent;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_show_random_number;
    }

    @Override
    protected void setViewReferences() {
        mNumberTextView = (TextView) findViewById(R.id.show_random_number_text_view);
    }

    @Override
    protected void setupActivity(Bundle savedInstanceState) {
        int randomNumber = getIntent().getIntExtra(RANDOM_NUMBER_KEY, 0);
        mNumberTextView.setText(String.valueOf(randomNumber));
    }
}
