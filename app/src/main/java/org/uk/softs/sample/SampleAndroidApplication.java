package org.uk.softs.sample;

import android.app.Application;

import org.uk.softs.sample.controller.FontManager;
import org.uk.softs.sample.controller.LoginManager;

/**
 * This is the default application class
 */
public class SampleAndroidApplication extends Application {

    private static SampleAndroidApplication sInstance;
    private LoginManager mLoginManager;

    private FontManager mFontManager;

    public static SampleAndroidApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        mLoginManager = new LoginManager();
        mFontManager = new FontManager(this);
    }

    public LoginManager getLoginManager() {
        return mLoginManager;
    }

    public FontManager getFontManager() {
        return mFontManager;
    }
}
