package com.kroshz.homework_3_4_2;


import android.app.Activity;
import android.content.Intent;



public class Utils
{
    private static int sTheme;

    public final static int THEME_LARGE = 3;
    public final static int THEME_MIDDLE = 4;
    public final static int THEME_SMALL = 5;

    /**
     * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
     */
    public static void changeToTheme(Activity activity, int theme)
    {
        sTheme = theme;
        activity.finish();

        activity.startActivity(new Intent(activity, activity.getClass()));

    }

    /** Set the theme of the activity, according to the configuration. */
    public static void onActivityCreateSetTheme(Activity activity)
    {
        switch (sTheme)
        {
            default:
            case THEME_LARGE:
                activity.setTheme(R.style.Margin10);
                break;
            case THEME_MIDDLE:
                activity.setTheme(R.style.Margin3);
                break;
            case THEME_SMALL:
                activity.setTheme(R.style.Margin1);
                break;
        }
    }
}
