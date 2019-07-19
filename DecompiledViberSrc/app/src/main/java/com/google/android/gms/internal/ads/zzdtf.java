package com.google.android.gms.internal.ads;

public final class zzdtf<T>
  implements zzdth<T>
{
  private zzdtt<T> zzhug;

  public static <T> void zzaw(zzdtt<T> paramzzdtt1, zzdtt<T> paramzzdtt2)
  {
    zzdtn.checkNotNull(paramzzdtt2);
    zzdtf localzzdtf = (zzdtf)paramzzdtt1;
    if (localzzdtf.zzhug != null)
      throw new IllegalStateException();
    localzzdtf.zzhug = paramzzdtt2;
  }

  public final T get()
  {
    if (this.zzhug == null)
      throw new IllegalStateException();
    return this.zzhug.get();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdtf
 * JD-Core Version:    0.6.2
 */