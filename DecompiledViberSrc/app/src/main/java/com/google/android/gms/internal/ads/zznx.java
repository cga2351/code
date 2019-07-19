package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zznx
{
  public final int zzazp = 1;
  public final byte[] zzazq;

  public zznx(int paramInt, byte[] paramArrayOfByte)
  {
    this.zzazq = paramArrayOfByte;
  }

  public final boolean equals(Object paramObject)
  {
    if (this == paramObject);
    zznx localzznx;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localzznx = (zznx)paramObject;
    }
    while ((this.zzazp == localzznx.zzazp) && (Arrays.equals(this.zzazq, localzznx.zzazq)));
    return false;
  }

  public final int hashCode()
  {
    return 31 * this.zzazp + Arrays.hashCode(this.zzazq);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zznx
 * JD-Core Version:    0.6.2
 */