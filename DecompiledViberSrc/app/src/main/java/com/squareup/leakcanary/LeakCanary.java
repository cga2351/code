package com.squareup.leakcanary;

import android.app.Application;
import android.content.Context;

public final class LeakCanary
{
  private LeakCanary()
  {
    throw new AssertionError();
  }

  public static RefWatcher install(Application paramApplication)
  {
    return RefWatcher.DISABLED;
  }

  public static boolean isInAnalyzerProcess(Context paramContext)
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.squareup.leakcanary.LeakCanary
 * JD-Core Version:    0.6.2
 */