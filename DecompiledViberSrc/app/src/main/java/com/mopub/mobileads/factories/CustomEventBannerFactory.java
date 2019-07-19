package com.mopub.mobileads.factories;

import com.mopub.mobileads.CustomEventBanner;
import java.lang.reflect.Constructor;

public class CustomEventBannerFactory
{
  private static CustomEventBannerFactory a = new CustomEventBannerFactory();

  public static CustomEventBanner create(String paramString)
    throws Exception
  {
    return a.a(paramString);
  }

  @Deprecated
  public static void setInstance(CustomEventBannerFactory paramCustomEventBannerFactory)
  {
    a = paramCustomEventBannerFactory;
  }

  protected CustomEventBanner a(String paramString)
    throws Exception
  {
    Constructor localConstructor = Class.forName(paramString).asSubclass(CustomEventBanner.class).getDeclaredConstructor((Class[])null);
    localConstructor.setAccessible(true);
    return (CustomEventBanner)localConstructor.newInstance(new Object[0]);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.factories.CustomEventBannerFactory
 * JD-Core Version:    0.6.2
 */