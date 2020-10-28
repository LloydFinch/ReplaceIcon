package com.lloydfinch.mmkvdemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import java.util.List;

/**
 * Name: ReplaceIconUtils
 * Author: lloydfinch
 * Function: ReplaceIconUtils
 * Date: 2020-10-28 11:13
 * Modify: lloydfinch 2020-10-28 11:13
 */
public class ReplaceIconUtils {

    public static void replaceBy11(Context context) {
        PackageManager packageManager = context.getPackageManager();
        //旧的不可用
        ComponentName componentNameOld = new ComponentName(context, getLauncherComponentName(context));
        packageManager.setComponentEnabledSetting(componentNameOld, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);


        //新的可用
        ComponentName componentName = new ComponentName(context, context.getPackageName() + ".Activity_11");
        packageManager.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
    }

    public static void replaceBy22(Context context) {
        PackageManager packageManager = context.getPackageManager();
        //旧的不可用
        ComponentName componentNameOld = new ComponentName(context, getLauncherComponentName(context));
        packageManager.setComponentEnabledSetting(componentNameOld, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);


        //新的可用
        ComponentName componentName = new ComponentName(context, context.getPackageName() + ".Activity_22");
        packageManager.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
    }

    public static String getLauncherComponentName(Context context) {
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> resolveInfos = context.getPackageManager().queryIntentActivities(intent, 0);
        if (resolveInfos != null) return resolveInfos.get(0).activityInfo.name;
        return null;
    }
}