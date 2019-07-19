package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.common.AdReport;
import com.mopub.common.VisibleForTesting;
import com.mopub.mraid.MraidController;
import com.mopub.mraid.PlacementType;

public class MraidControllerFactory
{
  protected static MraidControllerFactory a = new MraidControllerFactory();

  public static MraidController create(Context paramContext, AdReport paramAdReport, PlacementType paramPlacementType)
  {
    return a.a(paramContext, paramAdReport, paramPlacementType);
  }

  @VisibleForTesting
  public static void setInstance(MraidControllerFactory paramMraidControllerFactory)
  {
    a = paramMraidControllerFactory;
  }

  protected MraidController a(Context paramContext, AdReport paramAdReport, PlacementType paramPlacementType)
  {
    return new MraidController(paramContext, paramAdReport, paramPlacementType);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.factories.MraidControllerFactory
 * JD-Core Version:    0.6.2
 */