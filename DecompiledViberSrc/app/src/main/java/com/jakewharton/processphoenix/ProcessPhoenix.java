package com.jakewharton.processphoenix;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class ProcessPhoenix extends Activity
{
  public static void a(Context paramContext, Intent[] paramArrayOfIntent)
  {
    Intent localIntent = new Intent(paramContext, ProcessPhoenix.class);
    localIntent.addFlags(268435456);
    localIntent.putParcelableArrayListExtra("phoenix_restart_intents", new ArrayList(Arrays.asList(paramArrayOfIntent)));
    paramContext.startActivity(localIntent);
    if ((paramContext instanceof Activity))
      ((Activity)paramContext).finish();
    Runtime.getRuntime().exit(0);
  }

  public static boolean a(Context paramContext)
  {
    int i = Process.myPid();
    List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        if ((localRunningAppProcessInfo.pid == i) && (localRunningAppProcessInfo.processName.endsWith(":phoenix")))
          return true;
      }
    }
    return false;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ArrayList localArrayList = getIntent().getParcelableArrayListExtra("phoenix_restart_intents");
    startActivities((Intent[])localArrayList.toArray(new Intent[localArrayList.size()]));
    finish();
    Runtime.getRuntime().exit(0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.jakewharton.processphoenix.ProcessPhoenix
 * JD-Core Version:    0.6.2
 */