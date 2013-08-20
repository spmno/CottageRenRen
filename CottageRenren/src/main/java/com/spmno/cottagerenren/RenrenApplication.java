package com.spmno.cottagerenren;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;

/**
 * Created by spmno on 13-8-19.
 */
public class RenrenApplication extends Application{
    private ArrayList<Activity> activities = new ArrayList<Activity>();

    public void addActivity(Activity activity) {
        String className = activity.getClass().getName();
        for (Activity activityItem : activities) {
            if (className.equals(activityItem.getClass().getName())) {
                activities.remove(activityItem);
                break;
            }
        }
        activities.add(activity);
    }

    @Override
    public void onTerminate() {
        for (Activity activity : activities) {
            activity.finish();
        }
    }
}
