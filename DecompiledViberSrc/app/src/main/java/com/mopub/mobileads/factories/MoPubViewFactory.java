package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.common.VisibleForTesting;
import com.mopub.mobileads.MoPubView;

public class MoPubViewFactory
{
  protected static MoPubViewFactory a = new MoPubViewFactory();

  public static MoPubView create(Context paramContext)
  {
    return a.a(paramContext);
  }

  @Deprecated
  @VisibleForTesting
  public static void setInstance(MoPubViewFactory paramMoPubViewFactory)
  {
    a = paramMoPubViewFactory;
  }

  protected MoPubView a(Context paramContext)
  {
    return new MoPubView(paramContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.factories.MoPubViewFactory
 * JD-Core Version:    0.6.2
 */