package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.content.pm.FeatureInfo;

public abstract class hi
{
  protected abstract hj a(FeatureInfo paramFeatureInfo);

  public hj b(FeatureInfo paramFeatureInfo)
  {
    if (paramFeatureInfo.name == null)
    {
      if (paramFeatureInfo.reqGlEsVersion == 0)
        return a(paramFeatureInfo);
      return new hj("openGlFeature", paramFeatureInfo.reqGlEsVersion, c(paramFeatureInfo));
    }
    return a(paramFeatureInfo);
  }

  boolean c(FeatureInfo paramFeatureInfo)
  {
    return (0x1 & paramFeatureInfo.flags) != 0;
  }

  public static class a extends hi
  {
    @TargetApi(24)
    public hj a(FeatureInfo paramFeatureInfo)
    {
      return new hj(paramFeatureInfo.name, paramFeatureInfo.version, c(paramFeatureInfo));
    }
  }

  public static class b extends hi
  {
    public hj a(FeatureInfo paramFeatureInfo)
    {
      return new hj(paramFeatureInfo.name, c(paramFeatureInfo));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.hi
 * JD-Core Version:    0.6.2
 */