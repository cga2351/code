package com.mopub.common.util;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;

public class Views
{
  private static View a(Context paramContext)
  {
    if (!(paramContext instanceof Activity))
      return null;
    return ((Activity)paramContext).getWindow().getDecorView().findViewById(16908290);
  }

  private static View a(View paramView)
  {
    View localView1 = null;
    if (paramView == null);
    View localView2;
    do
    {
      do
      {
        return localView1;
        if (!ViewCompat.isAttachedToWindow(paramView))
          MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Attempting to call View#getRootView() on an unattached View." });
        localView2 = paramView.getRootView();
        localView1 = null;
      }
      while (localView2 == null);
      localView1 = localView2.findViewById(16908290);
    }
    while (localView1 != null);
    return localView2;
  }

  public static View getTopmostView(Context paramContext, View paramView)
  {
    View localView1 = a(paramContext);
    View localView2 = a(paramView);
    if (localView1 != null)
      return localView1;
    return localView2;
  }

  public static void removeFromParent(View paramView)
  {
    if ((paramView == null) || (paramView.getParent() == null));
    while (!(paramView.getParent() instanceof ViewGroup))
      return;
    ((ViewGroup)paramView.getParent()).removeView(paramView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.util.Views
 * JD-Core Version:    0.6.2
 */