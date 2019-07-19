package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.mobileads.AdViewController;
import com.mopub.mobileads.MoPubView;

public class AdViewControllerFactory
{
  protected static AdViewControllerFactory a = new AdViewControllerFactory();

  public static AdViewController create(Context paramContext, MoPubView paramMoPubView)
  {
    return a.a(paramContext, paramMoPubView);
  }

  @Deprecated
  public static void setInstance(AdViewControllerFactory paramAdViewControllerFactory)
  {
    a = paramAdViewControllerFactory;
  }

  protected AdViewController a(Context paramContext, MoPubView paramMoPubView)
  {
    return new AdViewController(paramContext, paramMoPubView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.factories.AdViewControllerFactory
 * JD-Core Version:    0.6.2
 */