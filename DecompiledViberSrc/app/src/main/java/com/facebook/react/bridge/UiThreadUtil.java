package com.facebook.react.bridge;

import android.os.Handler;
import android.os.Looper;
import javax.annotation.Nullable;

public class UiThreadUtil
{

  @Nullable
  private static Handler sMainHandler;

  public static void assertNotOnUiThread()
  {
    if (!isOnUiThread());
    for (boolean bool = true; ; bool = false)
    {
      SoftAssertions.assertCondition(bool, "Expected not to run on UI thread!");
      return;
    }
  }

  public static void assertOnUiThread()
  {
    SoftAssertions.assertCondition(isOnUiThread(), "Expected to run on UI thread!");
  }

  public static boolean isOnUiThread()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }

  public static void runOnUiThread(Runnable paramRunnable)
  {
    try
    {
      if (sMainHandler == null)
        sMainHandler = new Handler(Looper.getMainLooper());
      sMainHandler.post(paramRunnable);
      return;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.UiThreadUtil
 * JD-Core Version:    0.6.2
 */