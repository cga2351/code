package com.google.android.gms.internal.ads;

public final class zzdts<T>
  implements zzdtt<T>
{
  private static final Object zzhuh = new Object();
  private volatile Object zzdyb = zzhuh;
  private volatile zzdtt<T> zzhui;

  private zzdts(zzdtt<T> paramzzdtt)
  {
    this.zzhui = paramzzdtt;
  }

  public static <P extends zzdtt<T>, T> zzdtt<T> zzao(P paramP)
  {
    if (((paramP instanceof zzdts)) || ((paramP instanceof zzdtg)))
      return paramP;
    return new zzdts((zzdtt)zzdtn.checkNotNull(paramP));
  }

  public final T get()
  {
    Object localObject1 = this.zzdyb;
    zzdtt localzzdtt;
    if (localObject1 == zzhuh)
    {
      localzzdtt = this.zzhui;
      if (localzzdtt == null)
        localObject1 = this.zzdyb;
    }
    else
    {
      return localObject1;
    }
    Object localObject2 = localzzdtt.get();
    this.zzdyb = localObject2;
    this.zzhui = null;
    return localObject2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdts
 * JD-Core Version:    0.6.2
 */