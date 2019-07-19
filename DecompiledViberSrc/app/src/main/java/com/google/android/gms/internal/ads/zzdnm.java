package com.google.android.gms.internal.ads;

import java.lang.reflect.Method;

final class zzdnm
{
  private static final Class<?> zzhdy = zzawz();

  private static Class<?> zzawz()
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

  public static zzdnn zzaxa()
  {
    if (zzhdy != null)
      try
      {
        zzdnn localzzdnn = zzgz("getEmptyRegistry");
        return localzzdnn;
      }
      catch (Exception localException)
      {
      }
    return zzdnn.zzhec;
  }

  static zzdnn zzaxb()
  {
    Class localClass = zzhdy;
    Object localObject = null;
    if (localClass != null);
    try
    {
      zzdnn localzzdnn = zzgz("loadGeneratedRegistry");
      localObject = localzzdnn;
      if (localObject == null)
        localObject = zzdnn.zzaxb();
      if (localObject == null)
        localObject = zzaxa();
      return localObject;
    }
    catch (Exception localException)
    {
      while (true)
        localObject = null;
    }
  }

  private static final zzdnn zzgz(String paramString)
    throws Exception
  {
    return (zzdnn)zzhdy.getDeclaredMethod(paramString, new Class[0]).invoke(null, new Object[0]);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdnm
 * JD-Core Version:    0.6.2
 */