package me.iacn.mbestyle.ui.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

import java.util.Calendar;

import me.iacn.mbestyle.R;

/**
 * Implementation of App Widget functionality.
 */
public class AppClockWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.clock);
        updateViews(views);
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    private static void updateViews(RemoteViews views) {
        Calendar calendar = Calendar.getInstance();
        int y = calendar.get(Calendar.YEAR);
        String year = String.valueOf(y);
        int M = calendar.get(Calendar.MONTH) + 1;
        String month = getDisplayMonth(M);
        int d = calendar.get(Calendar.DAY_OF_MONTH);
        String day = d >= 10 ? String.valueOf(d) : "0" + d;
        String date = month + "." + day + "." + year;
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        String week = getDisplayWeek(w);
        views.setTextViewText(R.id.date, date);
        views.setTextViewText(R.id.week, week);
    }

    private static String getDisplayWeek(int w) {
        switch (w){
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 0:
                return "Sunday";
        }
        return "Null...";
    }

    private static String getDisplayMonth(int m) {
        switch (m){
            case 1:
                return "Jan";
            case 2:
                return "Feb";
            case 3:
                return "Mar";
            case 4:
                return "Apr";
            case 5:
                return "May";
            case 6:
                return "Jun";
            case 7:
                return "Jul";
            case 8:
                return "Aug";
            case 9:
                return "Sept";
            case 10:
                return "Oct";
            case 11:
                return "Nov";
            case 12:
                return "Dec";
        }
        return "Null";
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }
}

