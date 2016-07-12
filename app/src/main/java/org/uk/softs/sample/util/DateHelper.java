package org.uk.softs.sample.util;

import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by fernandomaia on 21/01/2016.
 */
public final class DateHelper {

    public static final String TIME_FORMAT = "dd MMMM 'at' HH:mm";
    public static final String YESTERDAY_TIME_FORMAT = "'Yesterday at' HH:mm";

    public static final String DAY_OF_WEEK_TEXT_FORMAT = "EEEE dd";
    public static final String TIME_HOURS_ONLY_FORMAT = "hh:mma";
    public static final String MONTH_OF_YEAR_FORMAT = "MMM";

    private static final int SECOND_MILLIS = 1000;
    private static final int MINUTE_MILLIS = 60 * SECOND_MILLIS;
    private static final int HOUR_MILLIS = 60 * MINUTE_MILLIS;
    private static final int DAY_MILLIS = 24 * HOUR_MILLIS;

    private static final String JUST_NOW = "Just Now";
    private static final String A_MINUTE_AGO = "1 min ago";
    private static final String N_MINUTES_AGO = " mins ago";
    private static final String AN_HOUR_AGO = "1 hour ago";
    private static final String N_HOURS_AGO = " hours ago";


    private DateHelper() {

    }

    private static String getFormattedDate(String format, Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.getDefault());
        return dateFormat.format(date);
    }


    /**
     * @param referenceDate the Date to reference with
     * @return a String with the formatted Date
     */
    public static String getTimeAgo(Date referenceDate) {
        long now = System.currentTimeMillis();
        long time = referenceDate.getTime();

        final long diff = now - time;
        if (diff < MINUTE_MILLIS) {
            return JUST_NOW;
        } else if (diff < 2 * MINUTE_MILLIS) {
            return A_MINUTE_AGO;
        } else if (diff < 59 * MINUTE_MILLIS) {
            return diff / MINUTE_MILLIS + N_MINUTES_AGO;
        } else if (diff < 119 * MINUTE_MILLIS) {
            return AN_HOUR_AGO;
        } else if (diff < 24 * HOUR_MILLIS) {
            return diff / HOUR_MILLIS + N_HOURS_AGO;
        } else if (diff < 48 * HOUR_MILLIS) {
            return DateHelper.getFormattedDate(DateHelper.YESTERDAY_TIME_FORMAT,
                    referenceDate);
        } else {
            return DateHelper.getFormattedDate(DateHelper.TIME_FORMAT,
                    referenceDate);
        }
    }

    public static boolean isSameDay(long dateA, long dateB) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTimeInMillis(dateA);
        cal2.setTimeInMillis(dateB);

        return DateUtils.isSameDay(cal1, cal2);
    }

    public static String getDateToString(long timestamp) {
        Calendar planCalendar = Calendar.getInstance();
        Calendar auxCalendar = Calendar.getInstance(); //Now set as default
        planCalendar.setTimeInMillis(timestamp);

        if (DateUtils.isSameDay(planCalendar, auxCalendar)) {
            return "Today";
        }

        auxCalendar.add(Calendar.DATE, 1);

        if (DateUtils.isSameDay(planCalendar, auxCalendar)) {
            return "Tomorrow";
        }

        return DateHelper.getFormattedDate(DateHelper.DAY_OF_WEEK_TEXT_FORMAT,
                planCalendar.getTime()) +
                getDayOfMonthSuffix(planCalendar.get(Calendar.DAY_OF_MONTH)) +
                " " +
                DateHelper.getFormattedDate(DateHelper.MONTH_OF_YEAR_FORMAT,
                        planCalendar.getTime());
    }

    public static String getTimeString(long timestamp) {
        Calendar planCalendar = Calendar.getInstance();
        planCalendar.setTimeInMillis(timestamp);

        return DateHelper.getFormattedDate(DateHelper.TIME_HOURS_ONLY_FORMAT,
                planCalendar.getTime())
                .toLowerCase()
                .replaceAll("\\.", "");
    }

    public static String getDateAndTimeString(long timestamp) {
        return DateHelper.getDateToString(timestamp)
                + " at "
                + DateHelper.getTimeString(timestamp);
    }

    private static String getDayOfMonthSuffix(final int n) {
        if (n >= 11 && n <= 13) {
            return "th";
        }
        switch (n % 10) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }

}
