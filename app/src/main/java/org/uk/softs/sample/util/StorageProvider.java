package org.uk.softs.sample.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashSet;
import java.util.Set;

import org.uk.softs.sample.SampleAndroidApplication;


public final class StorageProvider {

    private static final String PREFS_NAME = "sample_project";

    private StorageProvider() {

    }

    /**
     * Returns the shared preferences.
     *
     * @return Shared prefs.
     */
    public static SharedPreferences getPreferences() {

        return SampleAndroidApplication.getInstance().getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
    }

    /**
     * Saves the preference.
     *
     * @param key   Key for preference.
     * @param value Value for preference store.
     */
    public static void savePreferences(String key, String value) {

        SharedPreferences sharedPreferences = getPreferences();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * Saves the preference.
     *
     * @param key   Key for preference.
     * @param value Value for preference store.
     */
    public static void savePreferences(String key, Boolean value) {

        SharedPreferences sharedPreferences = getPreferences();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * Saves the preference.
     *
     * @param key   Key for preference.
     * @param value Value for preference store.
     */
    public static void savePreferences(String key, int value) {

        SharedPreferences sharedPreferences = getPreferences();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    /**
     * Saves the preference.
     *
     * @param key   Key for preference.
     * @param value Value for preference store.
     */
    public static void savePreferences(String key, long value) {

        SharedPreferences sharedPreferences = getPreferences();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    /**
     * Saves the preference.
     *
     * @param key   Key for preference.
     * @param value Value for preference store.
     */
    public static void savePreferences(String key, HashSet<Integer> value) {

        SharedPreferences sharedPreferences = getPreferences();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        HashSet<String> stringSet = new HashSet<>();
        for (Integer i : value) {
            stringSet.add(String.valueOf(i));
        }

        editor.putStringSet(key, stringSet);
        editor.commit();
    }

    /**
     * retrieve a string saved preference.
     *
     * @param key
     * @return
     */
    public static String getPreferencesString(String key) {
        return getPreferencesString(key, null);
    }

    /**
     * retrieve a string saved preference.
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getPreferencesString(String key, String defaultValue) {
        return getPreferences().getString(key, defaultValue);
    }

    /**
     * retrieve an int saved preference.
     *
     * @param key
     * @return
     */
    public static int getPreferencesInt(String key) {
        return getPreferences().getInt(key, 0);
    }

    /**
     * retrieve a boolean saved preference.
     *
     * @param key
     * @return
     */
    public static boolean getPreferencesBoolean(String key) {
        return getPreferences().getBoolean(key, false);
    }

    /**
     * retrieve a long saved preference.
     *
     * @param key
     * @return
     */
    public static long getPreferencesLong(String key) {
        return getPreferences().getLong(key, 0);
    }

    /**
     * retrieve an Integer Hash Set from saved preference.
     *
     * @param key
     * @return
     */
    public static HashSet<Integer> getPreferencesIntegerHashSet(String key) {

        Set<String> stringSet = getPreferences().getStringSet(key, null);
        HashSet<Integer> integerSet = new HashSet<>();

        if (stringSet != null) {
            for (String s : stringSet) {
                if (s != null) {
                    integerSet.add(Integer.parseInt(s));
                }
            }
        }

        return integerSet;
    }

    public static void deletePreferences(String key) {
        SharedPreferences sharedPreferences = getPreferences();
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.remove(key);
        editor.commit();
    }
}
