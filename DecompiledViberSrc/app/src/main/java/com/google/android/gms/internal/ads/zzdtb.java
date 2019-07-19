package com.google.android.gms.internal.ads;

public abstract class zzdtb
{
  public static zzdtb zzm(Class paramClass)
  {
    if (System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik"))
      return new zzdsw(paramClass.getSimpleName());
    return new zzdsy(paramClass.getSimpleName());
  }

  public abstract void zzhc(String paramString);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdtb
 * JD-Core Version:    0.6.2
 */