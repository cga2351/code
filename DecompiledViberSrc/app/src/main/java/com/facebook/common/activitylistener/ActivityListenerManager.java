package com.facebook.common.activitylistener;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.facebook.common.internal.Preconditions;
import java.lang.ref.WeakReference;

public class ActivityListenerManager
{
  public static void register(ActivityListener paramActivityListener, Context paramContext)
  {
    if ((!(paramContext instanceof ListenableActivity)) && ((paramContext instanceof ContextWrapper)));
    for (Context localContext = ((ContextWrapper)paramContext).getBaseContext(); ; localContext = paramContext)
    {
      if ((localContext instanceof ListenableActivity))
        ((ListenableActivity)localContext).addActivityListener(new Listener(paramActivityListener));
      return;
    }
  }

  private static class Listener extends BaseActivityListener
  {
    private final WeakReference<ActivityListener> mActivityListenerRef;

    public Listener(ActivityListener paramActivityListener)
    {
      this.mActivityListenerRef = new WeakReference(paramActivityListener);
    }

    private ActivityListener getListenerOrCleanUp(Activity paramActivity)
    {
      ActivityListener localActivityListener = (ActivityListener)this.mActivityListenerRef.get();
      if (localActivityListener == null)
      {
        Preconditions.checkArgument(paramActivity instanceof ListenableActivity);
        ((ListenableActivity)paramActivity).removeActivityListener(this);
      }
      return localActivityListener;
    }

    public void onActivityCreate(Activity paramActivity)
    {
      ActivityListener localActivityListener = getListenerOrCleanUp(paramActivity);
      if (localActivityListener != null)
        localActivityListener.onActivityCreate(paramActivity);
    }

    public void onDestroy(Activity paramActivity)
    {
      ActivityListener localActivityListener = getListenerOrCleanUp(paramActivity);
      if (localActivityListener != null)
        localActivityListener.onDestroy(paramActivity);
    }

    public void onPause(Activity paramActivity)
    {
      ActivityListener localActivityListener = getListenerOrCleanUp(paramActivity);
      if (localActivityListener != null)
        localActivityListener.onPause(paramActivity);
    }

    public void onResume(Activity paramActivity)
    {
      ActivityListener localActivityListener = getListenerOrCleanUp(paramActivity);
      if (localActivityListener != null)
        localActivityListener.onResume(paramActivity);
    }

    public void onStart(Activity paramActivity)
    {
      ActivityListener localActivityListener = getListenerOrCleanUp(paramActivity);
      if (localActivityListener != null)
        localActivityListener.onStart(paramActivity);
    }

    public void onStop(Activity paramActivity)
    {
      ActivityListener localActivityListener = getListenerOrCleanUp(paramActivity);
      if (localActivityListener != null)
        localActivityListener.onStop(paramActivity);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.activitylistener.ActivityListenerManager
 * JD-Core Version:    0.6.2
 */