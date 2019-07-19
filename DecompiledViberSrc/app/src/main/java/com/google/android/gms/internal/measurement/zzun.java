package com.google.android.gms.internal.measurement;

final class zzun
  implements zzvu
{
  private static final zzun zzbye = new zzun();

  public static zzun zzwe()
  {
    return zzbye;
  }

  public final boolean zze(Class<?> paramClass)
  {
    return zzuo.class.isAssignableFrom(paramClass);
  }

  public final zzvt zzf(Class<?> paramClass)
  {
    if (!zzuo.class.isAssignableFrom(paramClass))
    {
      String str3 = String.valueOf(paramClass.getName());
      if (str3.length() != 0);
      for (String str4 = "Unsupported message type: ".concat(str3); ; str4 = new String("Unsupported message type: "))
        throw new IllegalArgumentException(str4);
    }
    String str1;
    try
    {
      zzvt localzzvt = (zzvt)zzuo.zzg(paramClass.asSubclass(zzuo.class)).zza(zzuo.zze.zzbyo, null, null);
      return localzzvt;
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
 * Qualified Name:     com.google.android.gms.internal.measurement.zzun
 * JD-Core Version:    0.6.2
 */