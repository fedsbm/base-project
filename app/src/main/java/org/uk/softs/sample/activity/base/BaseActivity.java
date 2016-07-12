package org.uk.softs.sample.activity.base;

import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.uk.softs.sample.R;
import org.uk.softs.sample.SampleAndroidApplication;
import org.uk.softs.sample.util.Utils;

/**
 * this is the base activity for all activities
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ProgressBar mContentProgressBar;
    private View mContentMainContainerView;

    protected abstract int getLayoutResource();

    protected abstract void setViewReferences();

    protected abstract void setupActivity(Bundle savedInstanceState);

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());

        mContentMainContainerView = findViewById(R.id.content_container_view);
        mContentProgressBar = (ProgressBar) findViewById(R.id.content_progress_bar);
        initBaseValues();
        setupToolbar();
        setViewReferences();
        setupActivity(savedInstanceState);
    }

    protected void initBaseValues() {
//        To be over Override internally
    }

    protected Toolbar getToolbar() {
        return mToolbar;
    }

    protected void setupActionBar(ActionBar actionBar) {
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    protected boolean isNetworkConnectionUp() {
        if (!Utils.isNetworkConnectionAvailable(getBaseContext())) {
            Toast.makeText(this, "Network connection not available", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    private void setupToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            setupActionBar(getSupportActionBar());
            setupTitle();
        }
    }

    @Override
    public void setTitle(int titleId) {
        setTitle(getString(titleId));
    }

    @Override
    public void setTitle(CharSequence title) {
        if (title != null && getSupportActionBar() != null) {
            getSupportActionBar().setTitle(SampleAndroidApplication.getInstance().getFontManager()
                    .getFontSpannableString(R.string.font_regular, title.toString()));
        }
    }

    private void setupTitle() {
        String activityLabel;

        try {
            activityLabel = getString(getPackageManager().getActivityInfo(getComponentName(),
                    0).labelRes);
        } catch (PackageManager.NameNotFoundException | Resources.NotFoundException e) {
            activityLabel = null;
        }

        setTitle(activityLabel);
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

    public boolean isDevBuild() {
        return getResources().getBoolean(R.bool.dev_build);
    }

}
