package com.mopub.common;

import android.app.Activity;

public abstract interface LifecycleListener
{
  public abstract void onBackPressed(Activity paramActivity);

  public abstract void onCreate(Activity paramActivity);

  public abstract void onDestroy(Activity paramActivity);

  public abstract void onPause(Activity paramActivity);

  public abstract void onRestart(Activity paramActivity);

  public abstract void onResume(Activity paramActivity);

  public abstract void onStart(Activity paramActivity);

  public abstract void onStop(Activity paramActivity);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.LifecycleListener
 * JD-Core Version:    0.6.2
 */