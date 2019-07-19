package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzro
{
  public final int length;
  private int zzafx;
  private final zzrm[] zzblw;

  public zzro(zzrm[] paramArrayOfzzrm)
  {
    this.zzblw = paramArrayOfzzrm;
    this.length = paramArrayOfzzrm.length;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
      return false;
    zzro localzzro = (zzro)paramObject;
    return Arrays.equals(this.zzblw, localzzro.zzblw);
  }

  public final int hashCode()
  {
    if (this.zzafx == 0)
      this.zzafx = (527 + Arrays.hashCode(this.zzblw));
    return this.zzafx;
  }

  public final zzrm zzbi(int paramInt)
  {
    return this.zzblw[paramInt];
  }

  public final zzrm[] zzjs()
  {
    return (zzrm[])this.zzblw.clone();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzro
 * JD-Core Version:    0.6.2
 */