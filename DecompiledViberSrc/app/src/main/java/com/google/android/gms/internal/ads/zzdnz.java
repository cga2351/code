package com.google.android.gms.internal.ads;

final class zzdnz
  implements zzdpi
{
  private static final zzdnz zzhhc = new zzdnz();

  public static zzdnz zzaxq()
  {
    return zzhhc;
  }

  public final boolean zzc(Class<?> paramClass)
  {
    return zzdoa.class.isAssignableFrom(paramClass);
  }

  public final zzdph zzd(Class<?> paramClass)
  {
    if (!zzdoa.class.isAssignableFrom(paramClass))
    {
      String str3 = String.valueOf(paramClass.getName());
      if (str3.length() != 0);
      for (String str4 = "Unsupported message type: ".concat(str3); ; str4 = new String("Unsupported message type: "))
        throw new IllegalArgumentException(str4);
    }
    String str1;
    try
    {
      zzdph localzzdph = (zzdph)zzdoa.zze(paramClass.asSubclass(zzdoa.class)).zza(zzdoa.zze.zzhhm, null, null);
      return localzzdph;
    }
    catch (Exception localException)
    {
      str1 = String.valueOf(paramClass.getName());
      if (str1.length() == 0);
    }
    for (String str2 = "Unable to get message info for ".concat(str1); ; str2 = new String("Unable to get message info for "))
      throw new RuntimeException(str2, localException);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdnz
 * JD-Core Version:    0.6.2
 */