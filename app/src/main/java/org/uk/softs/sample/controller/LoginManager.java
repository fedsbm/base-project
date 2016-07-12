package org.uk.softs.sample.controller;

import android.text.TextUtils;

import org.uk.softs.sample.util.StorageProvider;


public class LoginManager {
    public static final String GCM_TOKEN_STORAGE_KEY = "gcm_token";
    private static final String AUTH_TOKEN_STORAGE_KEY = "auth_token";
    private static final String MY_PROFILE_ID_STORAGE_KEY = "my_profile_id";

    private String mAuthToken;
    private String mGcmToken;
    private int mMyProfileId;

    public LoginManager() {
        mAuthToken = StorageProvider.getPreferencesString(AUTH_TOKEN_STORAGE_KEY);
        mGcmToken = StorageProvider.getPreferencesString(GCM_TOKEN_STORAGE_KEY);
        mMyProfileId = StorageProvider.getPreferencesInt(MY_PROFILE_ID_STORAGE_KEY);
    }

    public String getAuthToken() {
        return mAuthToken;
    }

    public String getGcmToken() {
        return mGcmToken;
    }

    public void setAuthToken(String token) {
        mAuthToken = token;
        updateStoredAuthToken();
    }

    public void setGcmToken(String token) {
        mGcmToken = token;
        updateStoredGcmToken();
    }

    public void deleteAuthToken() {
        setAuthToken(null);
    }

    public boolean isAuthTokenAvailable() {
        if (!TextUtils.isEmpty(mAuthToken)) {
            return true;
        }
        return false;
    }

    public boolean isGcmTokenAvailable() {
        if (!TextUtils.isEmpty(mGcmToken)) {
            return true;
        }
        return false;
    }

    public int getMyProfileId() {
        return mMyProfileId;
    }

    public void setMyProfileId(int myProfileId) {
        mMyProfileId = myProfileId;
        updateStoredMyProfile();
    }

    public boolean hasUserEverLoggedIn() {
        // If we have a profile id, the user has previously logged in
        if (mMyProfileId != 0) {
            return true;
        }
        return false;
    }

    private void updateStoredAuthToken() {
        if (!TextUtils.isEmpty(mAuthToken)) {
            StorageProvider.savePreferences(AUTH_TOKEN_STORAGE_KEY, mAuthToken);
        } else {
            StorageProvider.deletePreferences(AUTH_TOKEN_STORAGE_KEY);
        }
    }

    private void updateStoredGcmToken() {
        if (!TextUtils.isEmpty(mGcmToken)) {
            StorageProvider.savePreferences(GCM_TOKEN_STORAGE_KEY, mGcmToken);
        } else {
            StorageProvider.deletePreferences(GCM_TOKEN_STORAGE_KEY);
        }
    }

    private void updateStoredMyProfile() {
        StorageProvider.savePreferences(MY_PROFILE_ID_STORAGE_KEY, mMyProfileId);
    }
}