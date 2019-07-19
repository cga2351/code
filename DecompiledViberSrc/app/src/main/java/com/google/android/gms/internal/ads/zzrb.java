package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzrb
{
  public static final zzrb zzbkw = new zzrb(new zzra[0]);
  public final int length;
  private int zzafx;
  private final zzra[] zzbkx;

  public zzrb(zzra[] paramArrayOfzzra)
  {
    this.zzbkx = paramArrayOfzzra;
    this.length = paramArrayOfzzra.length;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    zzrb localzzrb;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localzzrb = (zzrb)paramObject;
    }
    while ((this.length == localzzrb.length) && (Arrays.equals(this.zzbkx, localzzrb.zzbkx)));
    return false;
  }

  public final int hashCode()
  {
    if (this.zzafx == 0)
      this.zzafx = Arrays.hashCode(this.zzbkx);
    return this.zzafx;
  }

  public final int zza(zzra paramzzra)
  {
    for (int i = 0; i < this.length; i++)
      if (this.zzbkx[i] == paramzzra)
        return i;
    return -1;
  }

  public final zzra zzbg(int paramInt)
  {
    return this.zzbkx[paramInt];
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzrb
 * JD-Core Version:    0.6.2
 */