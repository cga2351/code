package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.mobileads.VastManager;

public class VastManagerFactory
{
  protected static VastManagerFactory a = new VastManagerFactory();

  public static VastManager create(Context paramContext)
  {
    return a.internalCreate(paramContext, true);
  }

  public static VastManager create(Context paramContext, boolean paramBoolean)
  {
    return a.internalCreate(paramContext, paramBoolean);
  }

  @Deprecated
  public static void setInstance(VastManagerFactory paramVastManagerFactory)
  {
    a = paramVastManagerFactory;
  }

  public VastManager internalCreate(Context paramContext, boolean paramBoolean)
  {
    return new VastManager(paramContext, paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.factories.VastManagerFactory
 * JD-Core Version:    0.6.2
 */