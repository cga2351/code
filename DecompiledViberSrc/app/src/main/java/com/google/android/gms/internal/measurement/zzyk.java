package com.google.android.gms.internal.measurement;

import java.util.Arrays;

final class zzyk
{
  final int tag;
  final byte[] zzbtz;

  zzyk(int paramInt, byte[] paramArrayOfByte)
  {
    this.tag = paramInt;
    this.zzbtz = paramArrayOfByte;
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    zzyk localzzyk;
    do
    {
      return true;
      if (!(paramObject instanceof zzyk))
        return false;
      localzzyk = (zzyk)paramObject;
    }
    while ((this.tag == localzzyk.tag) && (Arrays.equals(this.zzbtz, localzzyk.zzbtz)));
    return false;
  }

  public final int hashCode()
  {
    return 31 * (527 + this.tag) + Arrays.hashCode(this.zzbtz);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzyk
 * JD-Core Version:    0.6.2
 */