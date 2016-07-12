package org.uk.softs.sample.util;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fernandomaia on 18/11/2015.
 */
public final class TextValidator {

    private static final String EMBEDDED_LINK_REGEX = "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";
    private static final String MENTIONS_REGEX = "@[A-Za-z0-9_-]*";

    private TextValidator() {

    }

    public static boolean isValidName(String name) {
        if (!TextUtils.isEmpty(name.trim())) {
            Pattern p = Pattern.compile("[^a-z ]", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(name);
            boolean b = m.find();

            if (!b) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidEmail(String emailText) {

        if (!TextUtils.isEmpty(emailText)) {
            return (emailText != null && android.util.Patterns.EMAIL_ADDRESS.matcher(emailText).matches());
        }
        return false;
    }

    public static boolean doPasswordsMatchAndAreValid(String passwordText1, String passwordText2) {
        if (isPasswordValid(passwordText1) && isPasswordValid(passwordText2)) {
            if (passwordText1.equals(passwordText2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPasswordValid(String passwordText) {
        if (passwordText.length() >= 6) {
/*
*       On the past at least one number was necessary to make a password, but no longer
* */
//            Pattern p = Pattern.compile("[0-9]");
//            Matcher m = p.matcher(passwordText);
//            boolean b = m.find();
//            if (b) {
//                return true;
//            }
            return true;
        }


        return false;
    }

    public static String extractEmbeddedLinkFromText(String text) {

        Pattern pattern = Pattern.compile(EMBEDDED_LINK_REGEX);
        Matcher m = pattern.matcher(text);

        while (m.find()) {
            return m.group(0);
        }

        return null;
    }

    public static String extractLastMentionedString(String text) {

        Pattern pattern = Pattern.compile(MENTIONS_REGEX);
        Matcher m = pattern.matcher(getLastWordInString(text));

        while (m.find()) {
            return m.group(0).replace("@", "");
        }

        return null;

    }

    public static String getLastWordInString(String sentence) {
        return sentence.substring(sentence.lastIndexOf(" ") + 1);
    }
}
