package com.mopub.nativeads.factories;

import com.mopub.common.Preconditions;
import com.mopub.nativeads.CustomEventNative;
import com.mopub.nativeads.MoPubCustomEventNative;
import java.lang.reflect.Constructor;

public class CustomEventNativeFactory
{
  protected static CustomEventNativeFactory a = new CustomEventNativeFactory();

  public static CustomEventNative create(String paramString)
    throws Exception
  {
    if (paramString != null)
    {
      Class localClass = Class.forName(paramString).asSubclass(CustomEventNative.class);
      return a.a(localClass);
    }
    return new MoPubCustomEventNative();
  }

  @Deprecated
  public static void setInstance(CustomEventNativeFactory paramCustomEventNativeFactory)
  {
    Preconditions.checkNotNull(paramCustomEventNativeFactory);
    a = paramCustomEventNativeFactory;
  }

  protected CustomEventNative a(Class<? extends CustomEventNative> paramClass)
    throws Exception
  {
    Preconditions.checkNotNull(paramClass);
    Constructor localConstructor = paramClass.getDeclaredConstructor((Class[])null);
    localConstructor.setAccessible(true);
    return (CustomEventNative)localConstructor.newInstance(new Object[0]);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.factories.CustomEventNativeFactory
 * JD-Core Version:    0.6.2
 */