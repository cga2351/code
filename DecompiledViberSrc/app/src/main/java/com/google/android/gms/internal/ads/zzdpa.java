package com.google.android.gms.internal.ads;

final class zzdpa
  implements zzdpi
{
  private zzdpi[] zzhjh;

  zzdpa(zzdpi[] paramArrayOfzzdpi)
  {
    this.zzhjh = paramArrayOfzzdpi;
  }

  public final boolean zzc(Class<?> paramClass)
  {
    zzdpi[] arrayOfzzdpi = this.zzhjh;
    int i = arrayOfzzdpi.length;
    for (int j = 0; ; j++)
    {
      boolean bool = false;
      if (j < i)
      {
        if (arrayOfzzdpi[j].zzc(paramClass))
          bool = true;
      }
      else
        return bool;
    }
  }

  public final zzdph zzd(Class<?> paramClass)
  {
    for (zzdpi localzzdpi : this.zzhjh)
      if (localzzdpi.zzc(paramClass))
        return localzzdpi.zzd(paramClass);
    String str1 = String.valueOf(paramClass.getName());
    if (str1.length() != 0);
    for (String str2 = "No factory is available for message type: ".concat(str1); ; str2 = new String("No factory is available for message type: "))
      throw new UnsupportedOperationException(str2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdpa
 * JD-Core Version:    0.6.2
 */