package com.google.ads.mediation.mopub;

import android.content.Context;
import com.mopub.common.ExternalViewabilitySessionManager.ViewabilityVendor;
import com.mopub.common.MoPub;
import com.mopub.common.MoPub.BrowserAgent;
import com.mopub.common.SdkConfiguration;
import com.mopub.common.SdkInitializationListener;
import java.util.ArrayList;
import java.util.List;

public class b
{
  private static volatile b a;
  private static boolean b;
  private List<SdkInitializationListener> c = new ArrayList();

  public static b a()
  {
    if (a == null);
    try
    {
      if (a == null)
        a = new b();
      return a;
    }
    finally
    {
    }
  }

  public void a(Context paramContext, SdkConfiguration paramSdkConfiguration, SdkInitializationListener paramSdkInitializationListener)
  {
    if (MoPub.isSdkInitialized())
      paramSdkInitializationListener.onInitializationFinished();
    do
    {
      return;
      this.c.add(paramSdkInitializationListener);
    }
    while (b);
    b = true;
    MoPub.setBrowserAgent(MoPub.BrowserAgent.NATIVE);
    MoPub.disableViewability(ExternalViewabilitySessionManager.ViewabilityVendor.ALL);
    MoPub.initializeSdk(paramContext, paramSdkConfiguration, new c(this));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.ads.mediation.mopub.b
 * JD-Core Version:    0.6.2
 */