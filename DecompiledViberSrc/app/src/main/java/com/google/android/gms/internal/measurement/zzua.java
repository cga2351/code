package com.google.android.gms.internal.measurement;

import java.lang.reflect.Method;

final class zzua
{
  private static final Class<?> zzbvb = zzvn();

  private static final zzub zzge(String paramString)
    throws Exception
  {
    return (zzub)zzbvb.getDeclaredMethod(paramString, new Class[0]).invoke(null, new Object[0]);
  }

  private static Class<?> zzvn()
  {
    try
    {
      Class localClass = Class.forName("com.google.protobuf.ExtensionRegistry");
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    return null;
  }

  public static zzub zzvo()
  {
    if (zzbvb != null)
      try
      {
        zzub localzzub = zzge("getEmptyRegistry");
        return localzzub;
      }
      catch (Exception localException)
      {
      }
    return zzub.zzbvf;
  }

  static zzub zzvp()
  {
    Class localClass = zzbvb;
    Object localObject = null;
    if (localClass != null);
    try
    {
      zzub localzzub = zzge("loadGeneratedRegistry");
      localObject = localzzub;
      if (localObject == null)
        localObject = zzub.zzvp();
      if (localObject == null)
        localObject = zzvo();
      return localObject;
    }
    catch (Exception localException)
    {
      while (true)
        localObject = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzua
 * JD-Core Version:    0.6.2
 */