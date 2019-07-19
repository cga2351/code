package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzra
{
  public final int length;
  private int zzafx;
  private final zzlh[] zzbju;

  public zzra(zzlh[] paramArrayOfzzlh)
  {
    if (paramArrayOfzzlh.length > 0);
    for (boolean bool = true; ; bool = false)
    {
      zzsk.checkState(bool);
      this.zzbju = paramArrayOfzzlh;
      this.length = paramArrayOfzzlh.length;
      return;
    }
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    zzra localzzra;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localzzra = (zzra)paramObject;
    }
    while ((this.length == localzzra.length) && (Arrays.equals(this.zzbju, localzzra.zzbju)));
    return false;
  }

  public final int hashCode()
  {
    if (this.zzafx == 0)
      this.zzafx = (527 + Arrays.hashCode(this.zzbju));
    return this.zzafx;
  }

  public final zzlh zzbf(int paramInt)
  {
    return this.zzbju[paramInt];
  }

  public final int zzh(zzlh paramzzlh)
  {
    for (int i = 0; i < this.zzbju.length; i++)
      if (paramzzlh == this.zzbju[i])
        return i;
    return -1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzra
 * JD-Core Version:    0.6.2
 */