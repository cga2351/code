package com.google.android.gms.internal.ads;

public final class zzdtg<T>
  implements zzdtd<T>, zzdtt<T>
{
  private static final Object zzhuh = new Object();
  private volatile Object zzdyb = zzhuh;
  private volatile zzdtt<T> zzhui;

  private zzdtg(zzdtt<T> paramzzdtt)
  {
    this.zzhui = paramzzdtt;
  }

  public static <P extends zzdtt<T>, T> zzdtt<T> zzao(P paramP)
  {
    zzdtn.checkNotNull(paramP);
    if ((paramP instanceof zzdtg))
      return paramP;
    return new zzdtg(paramP);
  }

  public static <P extends zzdtt<T>, T> zzdtd<T> zzap(P paramP)
  {
    if ((paramP instanceof zzdtd))
      return (zzdtd)paramP;
    return new zzdtg((zzdtt)zzdtn.checkNotNull(paramP));
  }

  public final T get()
  {
    Object localObject1 = this.zzdyb;
    if (localObject1 == zzhuh)
    {
      while (true)
      {
        try
        {
          localObject1 = this.zzdyb;
          if (localObject1 != zzhuh)
            break label164;
          localObject1 = this.zzhui.get();
          Object localObject3 = this.zzdyb;
          if ((localObject3 != zzhuh) && (!(localObject3 instanceof zzdtm)))
          {
            i = 1;
            if ((i == 0) || (localObject3 == localObject1))
              break;
            String str1 = String.valueOf(localObject3);
            String str2 = String.valueOf(localObject1);
            throw new IllegalStateException(118 + String.valueOf(str1).length() + String.valueOf(str2).length() + "Scoped provider was invoked recursively returning different results: " + str1 + " & " + str2 + ". This is likely due to a circular dependency.");
          }
        }
        finally
        {
        }
        int i = 0;
      }
      this.zzdyb = localObject1;
      this.zzhui = null;
    }
    label164: return localObject1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdtg
 * JD-Core Version:    0.6.2
 */