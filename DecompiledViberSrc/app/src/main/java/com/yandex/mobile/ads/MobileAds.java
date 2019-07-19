package com.yandex.mobile.ads;

import com.yandex.mobile.ads.impl.es;
import com.yandex.mobile.ads.impl.fq;

public final class MobileAds
{
  public static void enableDebugErrorIndicator(boolean paramBoolean)
  {
    es.a().a(paramBoolean);
  }

  public static void enableLogging(boolean paramBoolean)
  {
    fq.a(paramBoolean);
  }

  public static String getLibraryVersion()
  {
    return "2.81";
  }

  public static void setUserConsent(boolean paramBoolean)
  {
    es.a().b(paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.MobileAds
 * JD-Core Version:    0.6.2
 */